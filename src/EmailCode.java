import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailCode extends JDialog {
    private JPanel EmailCodePanel;
    private JTextField emailCode;
    private JButton btnCheckCode;

    static boolean codeCheck = false;
    public EmailCode(JFrame parent){
        super(parent);
        setTitle("Create a new account");
        setContentPane(EmailCodePanel);
        setMinimumSize(new Dimension(500, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnCheckCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RegisterForm.code == Integer.parseInt(emailCode.getText())){
                    JOptionPane.showMessageDialog(null,"Code verified with success !", "Success",JOptionPane.INFORMATION_MESSAGE);
                    codeCheck = true;
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Code is incorrect !", "Error",JOptionPane.ERROR_MESSAGE);
                    codeCheck = false;

                }
            }
        });
        setVisible(true);
    }
}
