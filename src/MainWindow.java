import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JDialog{
    private JButton btnRegister;
    private JButton btnLogin;
    private JPanel MainWindowForm;


    public MainWindow(Object o) {
        //super(parent);
        setTitle("Create a new account");
        setContentPane(MainWindowForm);
        setMinimumSize(new Dimension(470, 474));
        setModal(true);
        //setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginForm loginForm = new LoginForm(null);
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RegisterForm registerForm = new RegisterForm(null);
            }
        });
        setVisible(true);
    }



}
