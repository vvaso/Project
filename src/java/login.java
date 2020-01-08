
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String psw = request.getParameter("psw");
        
        if(validate.checkUser(email, psw))
        {
            RequestDispatcher rs = request.getRequestDispatcher("index2.html");
            rs.forward(request, response);
        }
        else
        {
           out.println(" Username or Password incorrect. Please try again!");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}