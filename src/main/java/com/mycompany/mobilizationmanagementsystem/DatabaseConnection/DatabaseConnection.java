
package com.mycompany.mobilizationmanagementsystem.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    public String DatabaseURL="jdbc:mysql://localhost:3306/mobilization database";
    public String Driver="com.mysql.cj.jdbc.Driver";
    public String Username="root";
    public String Password="";
    public Connection con;
    
    
        // Connection Method
    public Connection getConnection() throws ClassNotFoundException{
        
        con=null;
        Class.forName(Driver);
        try {
            con=DriverManager.getConnection(DatabaseURL,Username,Password);
            
        } catch (SQLException ex) {
         ex.printStackTrace();
        }
        
                
       return con;         
    }
    
}
