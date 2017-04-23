
package first;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.swing.JFrame;

/*
Tables:
1. COUNTRY
2. CUSTOMER
3. DEPARTMENT
4. EMPLOYEE
5. EMPLOYEE_PROJECT
6. JOB
7. PHONE_LIST
8. PROJECT
9. PROJ_DEPT_BUDGET
10. SALARY_HISTORY
11. SALES
*/

public class First extends JFrame{
   
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet result = null;
    static ResponseClass mData;
  
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        String tableName = "EMPLOYEE";
        String query = "SELECT * FROM "+ tableName;
 
        mData = new ResponseClass();
        ConClass obj = ConClass.getInstance();
        connection = obj.setConnection(); 
        result = obj.getResponse(connection);
        
        System.out.println("");
        System.out.println(query);
        System.out.println("");
        
        obj.makeQuery(query,statement, connection, result);
         
        obj.closeConnection(statement, connection, result);
    }
    
}
