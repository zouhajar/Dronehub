package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private static final String INSERT_QUERY = "INSERT INTO user (NAME, EMAIL, PASSWORD, PASSWORD2, TELEPHONE) VALUES (?, ?, ?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html;charset=UTF-8");

        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String telephone = req.getParameter("telephone");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found", e);
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql:///sunita", "root", "root");
             PreparedStatement ps = con.prepareStatement(INSERT_QUERY)) {

            ps.setString(1, nom);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, password2);
            ps.setString(5, telephone);

            int count = ps.executeUpdate();

            if (count == 0) {
                pw.println("Record not stored into the database");
            } else {
                pw.println("Record stored into the database");
            }

        } catch (SQLException se) {
            // Log the exception or print detailed information for debugging
            pw.println("SQL Error: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            // Log the exception or print detailed information for debugging
            pw.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signup.html");
    }
}
