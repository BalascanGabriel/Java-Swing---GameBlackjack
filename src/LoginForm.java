import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends JDialog {
    private JTextField fnName;
    private JPasswordField fnPassword;
    private JButton btnCancel;
    private JButton btnLogin;
    private JPanel LoginPanel;


    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fnName.getText();
                String password = fnPassword.getText();
                User newUser = new User(name,password);

                try {
                    if (DBManager.checkCredentialsLogin(newUser).equals(password)) {
                        setVisible(false);
                        JOptionPane.showMessageDialog(null,"Connection succeded !", "Success",JOptionPane.INFORMATION_MESSAGE);
                        Platform.setCurrentUser(newUser);
                        GameSelector gameSelector = new GameSelector(null);
                        System.out.println("Matched password");

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"User or password wrong ! Try again", "Error",JOptionPane.ERROR_MESSAGE);
                        System.out.println("Missmatch");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainWindow mainWindow = new MainWindow(null);
            }
        });
        setVisible(true);

    }


}
