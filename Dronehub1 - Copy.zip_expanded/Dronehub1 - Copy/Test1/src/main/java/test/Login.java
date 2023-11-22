package test;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    // Getter and Setter methods for each field

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method for handling user login
    public String loginUser() {
        // Implementation details...

        // Check username and password
        if ("yourUsername".equals(username) && "yourPassword".equals(password)) {
            return "success"; // Redirect to a success page
        } else {
            return "failure"; // Redirect to a failure page
        }
    }

    // Other methods as needed...
}
