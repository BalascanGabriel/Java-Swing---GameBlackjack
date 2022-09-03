package Database;

public class User {
    private String Name;
    private String Password;
    private String Email;
    private int Balance;

    public User(String name, String password, String email) {
        this.Name = name;
        this.Password = password;
        this.Email = email;
        this.Balance = 0;
    }

    public User(String name, String password) {
        this.Name = name;
        this.Password = password;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        this.Balance = balance;
    }

    public void setName(String name){this.Name = name;}

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
