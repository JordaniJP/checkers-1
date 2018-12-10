
/**
 * Write a description of class Piece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Piece
{
    // instance variables - replace the example below with your own
    private boolean isBlack;
    private boolean isKing;
    protected int verticalDirection;

    /**
     * Constructor for objects of class Piece.  Will create a black piece
     */
    public Piece()
    {
        // initialise instance variables
        this.isBlack=false;
        this.isKing=false;
        verticalDirection=0;
    }
    
    /**
     * Constructor for objects of class Piece.  Will create with the given color
     * @pram isBlack  a boolean value for if the piecece is black
     */
    public Piece(boolean isBlack)
    {
        this.isBlack=isBlack;
        isKing=false;
        verticalDirection=0;
    }
    
    public String toString()
    {
        return "this is a " + isBlack+ " which is a king " + isKing;
    }
    
    public boolean isBlack()
    {
        return this.isBlack;
    }
   
    
    public int getVerticalDirection()
    {
     return verticalDirection;   
    }
}
