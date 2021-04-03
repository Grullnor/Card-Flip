import java.util.Random;
/**
 * The simulation version of Card flip.
 * 
 * @Raffi Sahagian 
 * @version 1.0
 */

public class WLStats extends Deck
{
    public static void main(String[] args)
    {
        double numOfTries = Integer.parseInt(args[0]);
        int currTry = 0;
        double numOfWins = 0;
        double numOfLosses;
        double perOfWins;
        double perOfLosses;
        int TOTALCARDS = 5;
        Random random = new Random();
        char perc = '%';
        
        while(currTry < numOfTries)
        {
            Deck playerDeck = new Deck();
            
            playerDeck.PlayersPick(random.nextInt(TOTALCARDS));
            
            playerDeck.MakeBlack();
            
            playerDeck.ThreeCardFlip();
            
            if(playerDeck.pickedColor() == 1) {numOfWins++;}
            
            currTry++;
        }
        
        numOfLosses = numOfTries - numOfWins;
        
        perOfWins = (numOfWins / numOfTries) * 100;
        perOfLosses = (numOfLosses / numOfTries) * 100;
        
        System.out.println("Win/Loss ratio if you do not switch");
        System.out.printf("Win: %.1f%c Loss %.1f%c\n", perOfWins, perc, perOfLosses, perc);
        
        currTry = 0;
        numOfWins = 0;

        
        while(currTry < numOfTries)
        {
            Deck playerDeck = new Deck();
            
            playerDeck.PlayersPick(random.nextInt(TOTALCARDS));
            
            playerDeck.MakeBlack();
            
            playerDeck.ThreeCardFlip();
            
            playerDeck.Swap();
            
            if(playerDeck.pickedColor() == 1) {numOfWins++;}
            
            currTry++;
        }
        
        numOfLosses = numOfTries - numOfWins;
        
        perOfWins = (numOfWins / numOfTries) * 100;
        perOfLosses = (numOfLosses / numOfTries) * 100;
        
        System.out.println("Win/Loss ratio if you do switch");
        System.out.printf("Win: %.1f%c Loss %.1f%c\n", perOfWins, perc, perOfLosses, perc);
    }
}
