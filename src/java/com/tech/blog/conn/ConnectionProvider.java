
package com.tech.blog.conn;
import java.sql.*;
public class ConnectionProvider {
    
    private  static Connection con;
    public static Connection  getConnection(){
        
            try{
               if(con==null){
                    //driver
                Class.forName("com.mysql.jdbc.Driver");
                //create a connection
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root", "");
                
                
               }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        return con;
    }
    
}
