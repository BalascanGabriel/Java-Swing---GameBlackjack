import Games.CoinFlip.CoinSide;
import Games.CoinFlip.Coinflip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinFlipMode extends JDialog {
    private JTextField betField;
    private JPanel CoinFlipPanel;
    private JTextField userNameField;
    private JTextField balanceField;
    private JTextField textField4;
    private JButton btnCoinFlip;
    private JComboBox sideComboBox;

    public CoinFlipMode(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(CoinFlipPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        userNameField.setText(Platform.getUserName());
        balanceField.setText(Integer.toString(Platform.getUserBalance()));
        btnCoinFlip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(betField.getText()) <= 0){
                    JOptionPane.showMessageDialog(null,"Can't bet zero or negative amount", "Error",JOptionPane.ERROR_MESSAGE);
                }else if(Integer.parseInt(betField.getText()) >= Platform.getUserBalance()) {
                    JOptionPane.showMessageDialog(null,"You don't have enough money", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    CoinSide choice = CoinSide.valueOf((String)sideComboBox.getSelectedItem()) ;
                    Coinflip game = new Coinflip(choice);
                    game.start();
                }
            }

        });
        setVisible(true);

    }
   /* public static void play(){
        //Aici se joaca bossu coinflip futu-l in gura
        String choice = null;
        if(sideComboBox.getSelectedItem() == "Heads"){
            choice = "Heads";
        }
        else{
            choice="Tails";
        }
    }*/


    public static void updateBudget(){
        //Aici vedem daca a pierdut sau a castigat fraieru
    }

}
