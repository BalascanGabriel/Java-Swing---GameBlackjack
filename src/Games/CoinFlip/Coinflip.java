package Games.CoinFlip;
import Interfaces.iGame;

public class Coinflip implements iGame{

    CoinSide choice;
    public Coinflip(CoinSide choice){
        this.choice = choice;
    }
    @Override
    public void start() {
        if(choice.equals(CoinSide.HEADS)){
            System.out.println("Heads");
        }
        else {
            System.out.println("Tail");
        }
    }

    @Override
    public void stop() {
    }
}
