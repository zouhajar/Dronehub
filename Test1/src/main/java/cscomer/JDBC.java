package cscomer;
import java.sql.DriverManager;
import java.sql.Connection;

public class JDBC {
    public static void main(String[] args) {
        try {
            // TODO Auto-generated method stub
            String url = "jdbc:mysql://localhost:3306/employe_service"; // Replace 'your_database_name' with your actual database name
            String user = "root"; // Replace 'your_username' with your MySQL username
            String password = "wawa"; // Replace 'your_password' with your MySQL password
            
            Connection con = DriverManager.getConnection(url, user, password);
            
            if (con != null) {
                System.out.println("Connected to the database!");
                // Perform your database operations here
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
