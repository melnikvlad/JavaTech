
package first;
import java.sql.*;
import java.util.*;
import java.io.*;

public class First {
   
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet result = null;
  
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ConClass obj = ConClass.getInstance();
        connection = obj.setConnection(); 
        result = obj.getResponse(connection);
        obj.makeQuery(statement, connection, result);
        obj.closeConnection(statement, connection, result);
}
}
