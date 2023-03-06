import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slot extends JDialog{
    private JTextField userNameField;
    private JTextField userBalanceField;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField userBetField;
    private JButton startButton;
    private JPanel photoLabel;
    private JLabel photoPut;
    private JPanel photoPanel;

    public static void waiting() throws InterruptedException {
        Thread.sleep(500);
    }

    public Slot(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(photoLabel);
        setMinimumSize(new Dimension(700, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        userNameField.setText(Platform.getUserName());
        userBalanceField.setText(Integer.toString(Platform.getUserBalance()));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String [][] panel = new String[3][3];
                Slots slots = new Slots();
                panel = Slots.makeMatrixSymbol();
                textField3.setText(panel[0][0]);
                textField4.setText(panel[0][1]);
                textField5.setText(panel[0][2]);
                textField6.setText(panel[1][0]);
                textField7.setText(panel[1][1]);
                textField8.setText(panel[1][2]);
                textField9.setText(panel[2][0]);
                textField10.setText(panel[2][1]);
                textField11.setText(panel[2][2]);
                
                photoPut = new JLabel("Image", new ImageIcon("C:\\Java\\BlackJackGame\\img\\Slots-icon.png"),JLabel.CENTER);
                photoPanel = new JPanel();
                photoPut.setIcon(new ImageIcon("C:\\Java\\BlackJackGame\\img\\Slots-icon.png"));
                photoPanel.add(photoPut);

                setVisible(true);


                slots.start(panel,Integer.parseInt(userBetField.getText()));
            }
        });
        setVisible(true);
    }
}
