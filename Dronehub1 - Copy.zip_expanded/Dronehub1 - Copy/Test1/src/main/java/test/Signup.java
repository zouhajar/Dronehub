package test;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Signup implements Serializable {

    private static final long serialVersionUID = 1L;

    // Fields corresponding to the information you provided
    private String nom;
    private String email;
    private String password;
    private String password2;
    private String telephone;

    // Constructors

    // Default constructor
    public Signup() {
        super();
    }

    // Parameterized constructor
    public Signup(String nom, String email, String password, String password2, String telephone) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.telephone = telephone;
    }

    // Getter and Setter methods for each field

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Methods for handling user registration and login

    public String validateUserPassword() {
        // Implementation details...
    }

    public String invalidPassword() {
        // Implementation details...
    }

    public void registerUser() {
        // Implementation details...
    }

    public String loginUser() {
        // Implementation details...
    }

    public String logout() {
        // Implementation details...
    }

    // Other methods as needed...
}
