import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class validate {
    
    public static boolean checkUser(String email,String psw) 
    {
        String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/db";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "21071993";
        boolean st =false;
        //ResultSet st =true;
        
        try {

            //loading drivers for mysql
                Class.forName("com.mysql.jdbc.Driver");
              
            //creating connection with the database
            Connection con = DriverManager.getConnection(DB_CONNECTION_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement ps = con.prepareStatement("select * from user where email=? and psw=?");
            ps.setString(1, email);
            ps.setString(2, psw);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}