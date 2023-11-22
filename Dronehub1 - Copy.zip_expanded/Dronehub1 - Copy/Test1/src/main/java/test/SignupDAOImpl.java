package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupDAOImpl {

    public static void registerUser(Signup user) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO signup (nom, email, password, telephone) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/sunita";
            String dbUser = "root";
            String dbPwd = "root";
            Connection con = DriverManager.getConnection(url, dbUser, dbPwd);

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, user.getNom());
                pst.setString(2, user.getEmail());
                pst.setString(3, user.getPassword());
                pst.setString(4, user.getTelephone());

                pst.executeUpdate();
            } finally {
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean validateLogin(String email, String password) {
        PreparedStatement pst = null;
        String sql = "SELECT name ,email, password, telephone FROM user WHERE email = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/sunita";
            String user = "root";
            String pwd = "root";
            Connection con = DriverManager.getConnection(url, user, pwd);

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);

                return pst.executeQuery().next(); // true if a row is found, false otherwise
            } finally {
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
