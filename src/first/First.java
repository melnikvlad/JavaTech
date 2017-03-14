
package first;
import java.sql.*;
import java.util.*;
import java.io.*;

public class First {
   
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet result = null;
  
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ConClass conClass = new ConClass();
        connection = conClass.setConnection(); 
        result = conClass.getResponse(connection);
        conClass.makeQuery(statement, connection, result);
        conClass.closeConnection(statement, connection, result);
}
}
