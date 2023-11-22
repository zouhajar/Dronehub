package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl {

    public static boolean validate(String username, String password) {
        PreparedStatement pst = null;
        String sql = "SELECT username, password FROM login WHERE username = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/sunita";
            String user = "root" ;
            String pwd = "root" ;
            Connection con = DriverManager.getConnection(url, user, pwd);

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();

                return rs.next(); // true if a row is found, false otherwise
            } finally {
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
