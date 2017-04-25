package pack;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
 
public class TicTacToeServer extends JFrame {
 
  
   private boolean xMove;
   private JTextArea output;
   private Player players[];
   private ServerSocket server;
   private int currentPlayer;
   private int[] board;
 
   public TicTacToeServer()
   {
 
      board = new int[] {0,0,0,0,0,0,0,0,0};
      
      xMove = true;
      players = new Player[ 2 ];
      currentPlayer = 0;
  
    
      try {
         server = new ServerSocket( 5000, 2 );
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }
 
      output = new JTextArea();
      getContentPane().add( output, BorderLayout.CENTER );
      output.setText( "Server awaiting connections\n" );
 
      setSize( 300, 300 );
      show();
   }
 
   // wait for two connections so game can be played
   public void execute()
   {
      for ( int i = 0; i < players.length; i++ ) {
         try {
            players[ i ] =
               new Player( server.accept(), this, i );
            players[ i ].start();
         }
         catch( IOException e ) {
            e.printStackTrace();
            System.exit( 1 );
         }
      }
 
      // Player X is suspended until Player O connects.
      // Resume player X now.          
      synchronized ( players[ 0 ] ) {
         players[ 0 ].threadSuspended = false;   
         players[ 0 ].notify();
      }
   
   }
    
   public void display( String s )
   {
      output.append( s + "\n" );
   }
  
   public synchronized boolean validMove( int loc,
                                          int player )
   {
      boolean moveDone = false;
 
      while ( player != currentPlayer ) {
         try {
            wait();
         }
         catch( InterruptedException e ) {
            e.printStackTrace();
         }
      }
 
      if ( !isOccupied( loc ) ) {
         board[ loc ] =
            (byte) ( currentPlayer == 0 ? 'X' : 'O' );
         currentPlayer = ( currentPlayer + 1 ) % 2;
         players[ currentPlayer ].otherPlayerMoved( loc );
         notify();    
         return true;
      }
      else
         return false;
   }
 
   public boolean isOccupied( int loc )
   {
      if ( board[ loc ] == 'X' || board [ loc ] == 'O' )
          return true;
      else
          return false;
   }
 
   public boolean gameOver()
   {
       return
            (board[0] != 0 && board[0] == board[1] && board[0] == board[2])
          ||(board[3] != 0 && board[3] == board[4] && board[3] == board[5])
          ||(board[6] != 0 && board[6] == board[7] && board[6] == board[8])
          ||(board[0] != 0 && board[0] == board[3] && board[0] == board[6])
          ||(board[1] != 0 && board[1] == board[4] && board[1] == board[7])
          ||(board[2] != 0 && board[2] == board[5] && board[2] == board[8])
          ||(board[0] != 0 && board[0] == board[4] && board[0] == board[8])
          ||(board[2] != 0 && board[2] == board[4] && board[2] == board[6]);
   }
 
   public static void main( String args[] )
   {
      TicTacToeServer game = new TicTacToeServer();
 
      game.addWindowListener( new WindowAdapter() {
        public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
 
      game.execute();
   }
}
 

class Player extends Thread {
   private Socket connection;
   private DataInputStream input;
   private DataOutputStream output;
   private TicTacToeServer control;
   private int number;
   private char mark;
   protected boolean threadSuspended = true;
 
   public Player( Socket s, TicTacToeServer t, int num )
   {
      mark = ( num == 0 ? 'X' : 'O' );
 
      connection = s;
       
      try {
         input = new DataInputStream(
                    connection.getInputStream() );
         output = new DataOutputStream(
                    connection.getOutputStream() );
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }
 
      control = t;
      number = num;
   }
 
   public void otherPlayerMoved( int loc )
   {
      try {
         output.writeUTF( "Opponent moved" );
         output.writeInt( loc );
      }
      catch ( IOException e ) { e.printStackTrace(); }
   }
 
   public void run()
   {
      boolean done = false;
 
      try {
         control.display( "Player " +
            ( number == 0 ? 'X' : 'O' ) + " connected" );
         output.writeChar( mark );
         output.writeUTF( "Player " +
            ( number == 0 ? "X connected\n" :
                            "O connected, please wait\n" ) );
 
         // wait for another player to arrive
         if ( mark == 'X' ) {
            output.writeUTF( "Waiting for another player" );
 
            try {
               synchronized( this ) {   
                  while ( threadSuspended )
                     wait();  
               }
            } 
            catch ( InterruptedException e ) {
               e.printStackTrace();
            }
 
            output.writeUTF(
               "Your move." );
         }
 
         
        while ( !done ) {
            int location = input.readInt();
            if ( control.gameOver() ){
                output.writeUTF( "Game over" );
                control.display( "Game over");
                done = true;
            }
            else{
               if ( control.validMove( location, number ) ) {
               control.display( "loc: " + location );
               output.writeUTF( "Valid move." );
            }
            else
               {
                 output.writeUTF( "Invalid move, try again" );  
               }  
            } 
        }
         connection.close();
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }
   }
}  