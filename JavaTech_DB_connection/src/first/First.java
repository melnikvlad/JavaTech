
package first;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class First extends JFrame{

  
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        
        EventQueue.invokeLater(new First()::display); 
    }
    
    
    public void viewData(String mTable) throws SQLException, IOException, ClassNotFoundException{        
    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;
    ResponseClass mData;
    
        
        String query = "SELECT * FROM "+ mTable;
 
        mData = new ResponseClass();
        ConClass obj = ConClass.getInstance();
        connection = obj.setConnection(); 
        result = obj.getResponse(connection);
        
        System.out.println("");
        System.out.println(query);
        System.out.println("");
        
        mData = obj.makeQuery(query,statement, connection, result);
        
        
        Vector<String> col= new Vector<>();
        for(String column : mData.getColumnNames())
        {
            col.add(column);
        }

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        JTable table = new JTable(tableModel);
        
        Vector<String> data;
        for(List<String> row : mData.getRows()){
            data= new Vector<>();
            for(int i = 0;i<row.size();i++){
                    data.add(row.get(i));
            } 
            tableModel.addRow(data);
        }
        
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
        obj.closeConnection(statement, connection, result);
    }
    
      private void display() {
        JFrame f = new JFrame("Test");
        String[] data = {"COUNTRY", "CUSTOMER","DEPARTMENT", "EMPLOYEE", "EMPLOYEE_PROJECT",
                         "PHONE_LIST","PROJECT","SALARY_HISTORY","SALES"};
        JList list = new JList(data);
        f.add(list);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            
              String s = (String) list.getSelectedValue();
              System.out.println("Value Selected: " + s);
                try {
                    viewData(s.toString());
                } catch (SQLException ex) {
                    Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(First.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
            });
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
