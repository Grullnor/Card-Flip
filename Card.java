/**
 * A self project demonstrating object orientation
 * 
 * @Raffi Sahagian 
 * @version 1.0
 */
public class Card
{
    int color;
    boolean picked;
    int BLACK = 1, RED = 0, FLIPPED = -1;
    
    public Card()
    {
        // initialize instance variables
        this.color = RED;
        this.picked = false;
    }
    public boolean isPicked()
    {
        return this.picked;    
    }
    public boolean isNotPicked()
    {
        return !this.picked;    
    }
    public boolean isBlack()
    {
        if (this.color == BLACK) {return true;}
        else {return false;}
    }
    public boolean isRed()
    {
        if (this.color == RED) {return true;}
        else {return false;}
    }
    public boolean isFlipped()
    {
        if (this.color == FLIPPED) {return true;}
        else {return false;}
    }
    public void pickCard()
    {
        this.picked = true;
    }
    public void unPickCard()
    {
        this.picked = false;
    }
    public void blackCard()
    {
        this.color = BLACK;
    }
    public void flipCard()
    {
        this.color = FLIPPED;
    }
    public int color()
    {
        return this.color;
    }
}
