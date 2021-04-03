import java.util.Scanner;
/**
 * The game version of Card flip.
 * 
 * @Raffi Sahagian 
 * @version 1.0
 */
public class Card_Flip_Game extends Deck
{
    public static void main(String[] args)
    {
        int cardPicked;
        String choice;
        int[] cardsFlipped;
        
        Deck playerDeck = new Deck();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please pick a card. Enter a number between 1 and 5:"); 
        cardPicked = sc.nextInt();
        System.out.println("Player picked card "+ cardPicked + ".");
        
        playerDeck.PlayersPick(cardPicked - 1);
        
        playerDeck.MakeBlack();
        
        System.out.println("Flipping three cards...");
        
        cardsFlipped = playerDeck.ThreeCardFlip();
        
        System.out.println("The three cards that were flipped were...");
        
        for (Integer i:cardsFlipped)
        {
            System.out.println("Card " + (i + 1));
        }
        
        System.out.println("Two cards remain, would you like to swap your choice? Y/N");
        choice = sc.next();
        
        switch(choice)
        {
            case "Y": case "y": playerDeck.Swap();
                               break;
            case "N": case "n": break;
            default : System.out.println("Not valid input, please use Y or N next time.");
                      System.exit(1);
        }
        
        System.out.println("You picked card " + playerDeck.pickedNumber() + ".");
        switch(playerDeck.pickedColor())
        {
            case 0: System.out.println("That card was Red, you lose! ");
                    break;
            case 1: System.out.println("That card was Black, you win! ");
                    break;
        }
        
        System.out.println("Thank you for playing!");
    }
}
