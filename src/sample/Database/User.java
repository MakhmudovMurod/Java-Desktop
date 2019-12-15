package sample.Database;

public class User {
    private String firstname;
    private String lastname;
    private String userId;
    private String password;

    public User(String firstname, String lastname, String userId, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.userId = userId;
        this.password = password;
    }
//Constructor:
    public User() {};


    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
