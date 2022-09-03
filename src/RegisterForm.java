import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class RegisterForm extends JDialog {
    private JButton btnRegister;
    private JButton btnBack;
    private JPasswordField fnPassword;
    private JTextField fnEmail;
    private JPanel RegisterPanel;
    private JTextField fnName;
    private JLabel Name;
    private JLabel Password;
    private JLabel Email;

    static int code = 0;
    Random random = new Random();

    public RegisterForm(JFrame parent){
        super(parent);
        setTitle("Create a new account");
        setContentPane(RegisterPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fnName.getText();
                String password = fnPassword.getText();
                String email = fnEmail.getText();
                User newUser = new User(name,password,email);
                if(DBManager.checkCredentialsRegister(newUser) == true){

                    code = Integer.parseInt(String.format("%04d", random.nextInt(10000) + 1000));
                    Mail.sendMail(email, name, code);
                    EmailCode emailCode = new EmailCode(null);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Can't register this user, try again !", "Error",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\tFalse returned");
                }

                if(EmailCode.codeCheck==true){
                    try {
                        DBManager.insertUser(newUser);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null,"User registered with success !", "Success",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("\tUser added with success");
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"User cannot register :(", "Error !",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\tUser cannot register :(");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainWindow mainWindow = new MainWindow(null);
            }
        });
        setVisible(true);
    }

}
