import java.util.Random;
public class Slots {
   static String[][] symbols = new String[3][3];
    Slots(){

    }

    public void start(String[][] panel, int bet){
        for(int i = 0; i < 3; i++){
            if(panel[1][0].equals(panel [1][1]) && panel[1][0].equals(panel[1][2]) && panel[1][1].equals(panel[1][2])){
                System.out.println("That's a line !!!!YOU WON : "+ bet*2.5);
            } else if ((panel[0][0].equals(panel [0][1]) && panel[0][0].equals(panel[0][2]) && panel[0][1].equals(panel[0][2])))
            {
                System.out.println("That's a line !!!! YOU WON : "+ bet*2.5);
            } else if (panel[2][0].equals(panel [2][1]) && panel[2][0].equals(panel[2][2]) && panel[2][1].equals(panel[2][2])) {
                System.out.println("That's a line !!!! YOU WON : "+ bet*2.5);

            } else {
                System.out.println("You kinda lost :(");
            }
            }
        }



    public static String[][] makeMatrixSymbol(){
        for(int i = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                symbols[i][j] = generateRandomSymbol();
            }
        }
        return symbols;
    }

    public static String generateRandomSymbol(){
        Random random = new Random();
        int nr = random.nextInt(7) + 1;
        if(nr == 0){
            return "A";
        }
        else if(nr == 1){
            return "K";
        }
        else if(nr == 2){
            return "Q";
        } else if (nr == 3) {
            return "J";
        }
        else if(nr == 4){
            return "10";
        }
        else if(nr == 5){
            return "9";
        }
        return "7";
    }
}
