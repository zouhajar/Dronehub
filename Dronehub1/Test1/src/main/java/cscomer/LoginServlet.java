package cscomer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;  // Import the WebServlet annotation
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")  // Specify the URL pattern for the servlet
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/projet"; // Update the database URL
            String username = "root";
            String password = "wawa";

            Connection con = DriverManager.getConnection(url, username, password);
            String n = request.getParameter("username");
            String p = request.getParameter("password");

            PreparedStatement ps = con.prepareStatement("select username from users where username = ? and password = ?");
            ps.setString(1, n);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	request.getRequestDispatcher("welcome.jsp").forward(request, response);


            } else {
                out.println("<font color='red' size='11'>LOGIN FAILED !! </font><br>");
                out.println("<font color='red'>Incorrect username or password. Please try again.</font><br>");
                out.println("<a href='login.jsp'>Try AGAIN !!</a>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
