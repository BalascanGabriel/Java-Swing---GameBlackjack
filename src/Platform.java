import Database.DBManager;
import Database.User;
import Interfaces.iPlatform;

import java.sql.SQLException;
import java.util.Scanner;

public class Platform implements iPlatform {


    Scanner scanner = new Scanner(System.in);
    private static Platform instance = null;
    private static User currentUser;
    private Platform(){


    }

    public static Platform getInstance(){
        if(instance == null)
            instance = new Platform();

        return instance;
    }

    @Override
    public void start() {
        MainWindow mainWindow = new MainWindow(null);
    }

    @Override
    public boolean register() throws SQLException {
        String Name = "";
        String Password = "";
        String Email = "";

        System.out.println("\t--REGISTER--");
        System.out.println("Username : ");
        Name = scanner.nextLine();
        System.out.println("Password");
        Password = scanner.nextLine();
        System.out.println("Email");
        Email = scanner.nextLine();

        User newUser = new User(Name,Password,Email);
        if(DBManager.checkCredentialsRegister(newUser) == true){
            DBManager.insertUser(newUser);
            return true;
        }
        else{
            System.out.println("\tFalse returned");
            return false;
        }

    }

    @Override
    public boolean login() {
        System.out.println("\t--LOGIN--");
        System.out.println("Name : ");
        String Name = "";
        Name = scanner.nextLine();
        System.out.println("Password : ");
        String Password="";
        Password=scanner.nextLine();
        return true;
    }

    @Override
    public void stop() {

    }

    public static void setCurrentUser(User currentUser) {
        Platform.currentUser = currentUser;
        try {
            Platform.currentUser.setBalance(DBManager.getUserBalance(currentUser.getName()));
        }
        catch (SQLException e){

        }
    }

    public static String getUserName(){
        return currentUser.getName();
    }

    public static int getUserBalance(){ return currentUser.getBalance();}

    //TO DO :
    //To insert here login/register on platform
}
