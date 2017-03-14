/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConClass {
private String databaseURL; 
private String user ;
private String password ;
private String driverName ;
private static ConClass instance;

public static ConClass getInstance(){
    if(instance==null)
    {
        instance = new ConClass();
    }
    return instance;
}

    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    
    private ConClass() { 
    }

    public Connection setConnection() throws IOException, SQLException, ClassNotFoundException{
                FileInputStream inp;
                Properties pr = new Properties();       
                Connection c = null;
       
                
                
                inp = new FileInputStream("C:\\Users\\Vlad\\Documents\\NetBeansProjects\\First\\database.prop");
                pr.load(inp);
                inp.close();
                this.setDatabaseURL(pr.getProperty("dbURL"));
                this.setUser(pr.getProperty("user"));
                this.setPassword(pr.getProperty("password"));
                this.setDriverName(pr.getProperty("driver"));
    
            
            System.err.println("Tag "+ this.getDriverName());
            Class.forName(this.getDriverName());
            System.out.println("OK !!!!");
            c = DriverManager.getConnection(this.getDatabaseURL(),this.getUser(),this.getPassword());
            System.out.println("Connect");
    return c;
    }

            
    public ResultSet getResponse(Connection c) throws SQLException{
        ResultSet rs = null; 
        DatabaseMetaData dbM = null;
        dbM=c.getMetaData();
            rs = dbM.getTables(null,null,"%",new String[]{"TABLE","VIEW"});
            while (rs.next()){
            System.out.println(rs.getString("TABLE_NAME")+" "+rs.getString("TABLE_TYPE"));
            }
            return rs;
    }
    
    public void makeQuery(Statement s,Connection c,ResultSet rs) throws SQLException
    {
        s=c.createStatement();
        rs = s.executeQuery("SELECT EMP_NO,FIRST_NAME,LAST_NAME AS employee FROM EMPLOYEE where HIRE_DATE BETWEEN '01.01.1992' AND '31.12.1995' ");
        ResultSetMetaData rsM=rs.getMetaData();
        for (int i=0; i< rsM.getColumnCount(); i++){
        System.out.print(rsM.getColumnName(i+1)+" - "+rsM.getColumnTypeName(i+1));
        }
        System.out.println("\nНайти сотрудников, которые поступили на работу с 1992 по 1995 год");
        System.out.println("columns="+rsM.getColumnCount() );
        while (rs.next()) {
        
        System.out.println(  rs.getString("emp_no")+ ' '
                            +rs.getString("first_name")+ ' '
                            +rs.getString("last_name"));
            }

}
    
    public void closeConnection(Statement s,Connection c,ResultSet rs) throws SQLException{
        if (rs!=null) rs.close();
        if (s!=null) s.close();
        if (c!=null) c.close();
        System.out.println("Connection was closed");
    }
}
