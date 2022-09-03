import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GameSelector extends JDialog {
    private JButton btnBlackJack;
    private JButton btnRoulette;
    private JButton btnCoinFlip;
    private JPanel SelectorPanel;
    private JTextField userTxtField;
    private JTextField balanceTxtField;

    public GameSelector(JFrame parent) throws SQLException {
        super(parent);
        setTitle("Login");
        setContentPane(SelectorPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        userTxtField.setText(Platform.getUserName());
        //balanceTxtField.setText(Integer.toString(DBManager.getUserBalance(Platform.getUserName())));
        balanceTxtField.setText(Integer.toString(Platform.getUserBalance()));
        btnBlackJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRoulette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCoinFlip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoinFlipMode coinFlipMode = new CoinFlipMode(null);
            }
        });
        setVisible(true);

    }
}
