import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DBManager {

    public static void connectToDb() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
        Statement statement = connection.createStatement();
    }

   public static boolean checkCredentialsRegister(User user){
       try {
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from users");

           //Get all users in DB
           ArrayList<String> activeUsers = getAllUsersPasswords();
           for (int i = 0; i < activeUsers.size();i++)
           {
               System.out.println(activeUsers.get(i));
           }
           //Check email
           for(int i=0 ; i < activeUsers.size(); i++){
               if (user.getName().equals("")) {
                   System.out.println("\t\tCan't have null username");
                   return false;
               }
               else {
                   for(int j = 0 ; j < activeUsers.size(); j ++)
                    if(user.getEmail().equals(activeUsers.get(j).toString()) )
                    {
                        System.out.println("\t\tThere is already an account on this email !");
                        return false;
                    }
                   return true;
               }
             }
       }catch (Exception e){
           e.printStackTrace();
       }
       return true;
   }

    public static String checkCredentialsLogin(User user) throws SQLException {

        //BIG TO DO :
        //Ia alea ca hashmap User name si parola si verifica in functie de ambele, momentan verifica doar parola
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");

        //Get all users in DB
        HashMap<String,String> activeUsers = getLoginInfo();

        //System.out.println(activeUsers.get(user.getName()));

        return activeUsers.get(user.getName());

    }

    public static ArrayList<String> getAllUsersPasswords() {
       //Get all user's mail from DB
        ArrayList<String> users = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            users = new ArrayList<String>();

            while (resultSet.next()) {
                users.add(resultSet.getString("Password"));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<String> getAllUsersNames() {
        //Get all user's mail from DB
        ArrayList<String> users = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            users = new ArrayList<String>();


            while (resultSet.next()) {
                users.add(resultSet.getString("Name"));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static HashMap<String,String> getLoginInfo() throws SQLException {
       HashMap<String,String> credentials = new HashMap<>();
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()) {
        String name = resultSet.getString("Name");
        String password = resultSet.getString("Password");
        credentials.put(name,password);
        }


        return credentials;
    }

    public static void insertUser(User user) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO Users(Name,Password,Email,Balance) " + "VALUES(?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getEmail());
        pstmt.setInt(4, user.getBalance());
        int rowAffected = pstmt.executeUpdate();
        if(rowAffected == 1)
        {
            // process further here
            System.out.println("User created with success. Good Luck !");
        }


    }

    public static int getUserBalance(String userName) throws SQLException {
        int balance = 0;
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
        //Statement statement = connection.createStatement();

       PreparedStatement statement = connection.prepareStatement("SELECT balance from users WHERE Name=?");
       statement.setString(1, userName);
       ResultSet rs = statement.executeQuery();
       while (rs.next()) {
           balance = Integer.parseInt(rs.getString("balance"));
       }


        return balance;
    }

    public static void updateBalance(User user){
       //TODO: UPDATE BALANCE FOR WIN/LOSE
    }
}

