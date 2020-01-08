/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp User
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class calculate extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/db";
    String DB_USERNAME = "root";
    String DB_PASSWORD = "21071993";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
	
        String sex = request.getParameter("sex");
        Double height = Double.valueOf(request.getParameter("height"));
        Double weight =Double.valueOf(request.getParameter("weight"));
        String times = request.getParameter("times");
        
        try {
        
            // loading drivers for mysql
                Class.forName("com.mysql.jdbc.Driver");
 
            Connection con = DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
             
            PreparedStatement ps = con.prepareStatement ("insert into user_info(sex,height,weight,times) values(?,?,?,?)");

            ps.setString(1, sex);
            ps.setDouble(2, height);
            ps.setDouble(3, weight);
            ps.setString(4, times);
            int i = ps.executeUpdate();
            
            if(i > 0) {
                //out.println("You are sucessfully registered");
                response.sendRedirect("index3.html");
            }
            else{
                response.sendRedirect("error.html");
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
}