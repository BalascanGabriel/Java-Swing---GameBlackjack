package Games.CoinFlip;

import Database.User;

import java.sql.SQLException;
import java.util.Random;

public class Coinflip{

    CoinSide choice;
    public Coinflip(CoinSide choice){
        this.choice = choice;
    }

    public String start(CoinSide choice, int bet, User user) throws SQLException {
        CoinSide generated = sideRandomiser();

        if(choice == generated){
            //To upgrade balance
            System.out.println("You guessed it right");
            user.setBalance(user.getBalance() + bet);

            //DBManager.updateBalance();

        }
        else if(choice != generated){
            //To decrease balance
            System.out.println("You were wrong");
            user.setBalance(user.getBalance() - bet);
        }

        System.out.println(generated);
        System.out.println("Bet : " + bet);
        if(generated == CoinSide.Tails){
            return "Tails";
        }
        else{
            return "Heads";
        }

    }

    public static CoinSide sideRandomiser(){
        Random random = new Random();
        int number = Integer.parseInt(String.format("%d", random.nextInt(2)));
        if(number == 1){
            return CoinSide.Heads;
        }
        else return CoinSide.Tails;
    }

    public void stop() {
    }
}
