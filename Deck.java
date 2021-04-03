import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * A self project demonstrating object orientation
 * 
 * @author Raffi Sahagian 
 * @version 1.0
 */


public class Deck extends Card
{
    // instance variables
    final int TOTALCARDS = 5;
    Card[] cardInHand = new Card[TOTALCARDS];
    Random random = new Random();
    
    public Deck()
    // initialize instance variables
    {
        for (int i = 0; i < TOTALCARDS; i++)
        {
            this.cardInHand[i] = new Card();
        }
    }
    public void PlayersPick(int pick)
    /* takes an int value and picks that card in the deck */
    {
        this.cardInHand[pick].pickCard();
    }
    public void MakeBlack()
    /* randomly creates a black card */
    {
        this.cardInHand[random.nextInt(TOTALCARDS)].blackCard();
    }
    public int[] ThreeCardFlip()
    /* Uses FlipOrder to flip cards and returns which ones where flipped*/
    {
        int totalFlipped = 0;
        int[] flippedCards = new int[TOTALCARDS - 2];
        ArrayList<Integer> flip = FlipOrder();
        //int[] flip = {0, 1, 2, 3, 4};
        for (int i = 0; totalFlipped < TOTALCARDS - 2; i++)
        {
            int j = flip.get(i);
            if (this.cardInHand[j].isBlack() || this.cardInHand[j].isPicked()) {continue;}
            else
            {
               this.cardInHand[j].flipCard();
               flippedCards[totalFlipped] = j;
               totalFlipped++;
            }
        }
        
        Arrays.sort(flippedCards);
        
        return flippedCards;
    }
    private ArrayList<Integer> FlipOrder()
    /* Randomizes a flip order */
    {
        ArrayList<Integer> flip = new ArrayList<Integer>();
        for (int i = 0; i < TOTALCARDS; i++)
        {
            flip.add(i);
        }
        Collections.shuffle(flip);
        return flip;
    }
    public void Swap()
    /* Swaps the picked card for a non-flipped, non-picked card */
    {
        for (int i = 0; i < TOTALCARDS; i++)
        {
            if (this.cardInHand[i].isFlipped()) {continue;}
            if (this.cardInHand[i].isPicked()) {this.cardInHand[i].unPickCard();}
            else if (this.cardInHand[i].isNotPicked()) {this.cardInHand[i].pickCard();}
        }
    }
    public int pickedColor()
    /* Returns what color the picked card is */
    {
        int picked = 0;
        for (int i = 0; i < TOTALCARDS; i++)
        {
            if (this.cardInHand[i].isPicked()) {picked = i; break;}
        }
        
        return this.cardInHand[picked].color();
    }
    public int pickedNumber()
    /* Returns what card number the picked card is */
    {
        int picked = 0;
        for (int i = 0; i < TOTALCARDS; i++)
        {
            if (this.cardInHand[i].isPicked()) {picked = i;}
        }
        
        return picked + 1;
    }
}
