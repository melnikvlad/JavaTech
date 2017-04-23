/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class ConClass {
private String databaseURL; 
private String user ;
private String password ;
private String driverName ;
private static ConClass instance;
private final ResponseClass response = new ResponseClass();

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
                Class.forName(this.getDriverName());
                c = DriverManager.getConnection(this.getDatabaseURL(),this.getUser(),this.getPassword());
                
    return c;
    }

            
    public ResultSet getResponse(Connection c) throws SQLException{
        
        List<String> tables = new ArrayList<>();
        ResultSet rs = null; 
        DatabaseMetaData dbM = null;
        dbM=c.getMetaData();
            rs = dbM.getTables(null,null,"%",new String[]{"TABLE","VIEW"});
            while (rs.next()){
                tables.add(rs.getString("TABLE_NAME"));
            }
            response.setTables(tables);
            return rs;
    }
    
    public void makeQuery(String query,Statement s,Connection c,ResultSet rs) throws SQLException
    {
        
        List<String> columns = new ArrayList<>();
        List<List<String>> rows = new ArrayList<>();
        List<String> row = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        
        s=c.createStatement();
        rs = s.executeQuery(query);
        ResultSetMetaData rsM=rs.getMetaData();
        
        response.setColumnCount(rsM.getColumnCount());
 
        for(int i=1;i<=response.getColumnCount();i++){
            columns.add(rsM.getColumnName(i));
        }
        
        System.err.println(columns);

        while(rs.next()){
            row = new ArrayList<>();
            for(int i =0;i<columns.size();i++){
                row.add(rs.getString(columns.get(i)));
                
            }    
            rows.add(row);
            
        }

            
            for(List<String> _row : rows){
                String str ="";
                for(int i = 0;i<_row.size();i++){
                     str+=" | "+_row.get(i);
                     
                } 
                System.out.println("Row: "+str); 
            } 
    }
    
    public void closeConnection(Statement s,Connection c,ResultSet rs) throws SQLException{
        if (rs!=null) rs.close();
        if (s!=null) s.close();
        if (c!=null) c.close();
        System.out.println("Connection was closed");
    }
        
}
