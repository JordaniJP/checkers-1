import java.util.ArrayList;
/**
 * Write a description of class Sqaure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square
{
    private int x;
    private int y;
    private Piece piece;
    private boolean isEmpty;
    private ArrayList<Square> neighbor;
    private Square northWest;
    private Square northEast;
    private Square southEast;
    private Square southWest;
    public static final int BLACK=1;
    public static final int RED=2;
    public static final int EMPTY=-1;
    public static final int NORTHEAST=1;
    public static final int SOUTHEAST=2;
    public static final int NORTHWEST=3;
    public static final int SOUTHWEAST=4;

    /**
     * A constructor that will create an empty square at the given location
     * @pram x the x location starting at 0
     * @pram y the y location starting at 0
     */
    public Square(int x, int y)
    {
        this.x=x;
        this.y=y;
        isEmpty=true;
        piece = null;
        neighbor = new ArrayList<Square>();
    }

    /**
     * A constructor that will create an square at the given location with the given piece
     * @pram x the x location starting at 0
     * @pram y the y location starting at 0
     * @pram piece the piece the location
     * 
     */
    public Square(int x, int y, Piece piece)
    {
        this.x=x;
        this.y=y;
        isEmpty=false;
        this.piece = piece;
        neighbor = new ArrayList<Square>();
    }

    public void removePiece()
    {
        this.isEmpty=true;   
    }

    public void addPiece(Piece p)
    {
        this.isEmpty=false;
        this.piece = p;
    }

    public void addNorthEastNeighbor(Square s)
    {
        northEast=s;
        neighbor.add(s);
    }

    public void addNorthWestNeighbor(Square s)
    {
        northWest=s;
        neighbor.add(s);
    }

    public void addSouthEastNeighbor(Square s)
    {
        southEast=s;
        neighbor.add(s);
    }

    public void addSouthWestNeighbor(Square s)
    {
        southWest=s;
        neighbor.add(s);
    }

    public Square getSW()
    {
        return southWest;
    }

    public Square getNW()
    {
        return northWest;
    }

    public Square getNE()
    {
        return northEast;
    }

    public Square getSE()
    {
        return southEast;
    }

    public Jump getJump(boolean isBlack)
    {
        Jump ans = null;
        if(this.getColor()!=Square.EMPTY){
            if(x<=5 && y<= 5 && (northEast.getColor()!=this.getColor() && northEast.getColor()!=Square.EMPTY && this.getNE().getNE().isEmpty()))
            {
                String to = this.getSquareCode();
                String over = this.getNE().getSquareCode();
                String from = this.getNE().getNE().getSquareCode();
                ArrayList<String> jumped = new ArrayList<String>();
                jumped.add(over);
                ans = new Jump(to,from,jumped);
            }
        }
        return ans;
    }

    public boolean isEmpty()
    {
        return isEmpty;
    }

    /**
     * A method that will return the color of the piece on the square.  
     * @ retun Returns 0 if red,  1 if black, -1 if empty
     * 
     */
    public int getColor()
    {
        if (isEmpty)
        {
            return EMPTY;
        }
        else if (piece.isBlack())
        {
            return BLACK;
        }
        else
        {
            return RED;
        }
    }

    public String getMoves(boolean isBlack)
    {
        String moves = "";
        if(isEmpty)
        {
            return "";
        }
        else if(piece.isBlack()==isBlack)
        {
            int vertical = piece.getVerticalDirection();
            for (int i=0;i<neighbor.size();i++)
            {
                Square n = neighbor.get(i);
                if(this.getY()+vertical==n.getY() && n.isEmpty())
                {
                    moves+="|"+this.getSquareCode()+"-"+n.getSquareCode();
                }
            }
        }
        return moves;
    }

    public String getSquareCode()
    {
        return getLetter(x)+(1+y);
    }

    public static String getLetter(int i)
    {
        String[] letters ={"A","B","C","D","E","F","G","H"};
        return letters[i];
    }

    public static int getNumber(String input)
    {
        switch (input)
        {
            case "A":
            return 0;
            case "B":
            return 1;
            case "C":
            return 2;
            case "D":
            return 3;
            case "E":
            return 4;
            case "F":
            return 5;
            case "G":
            return 6;
            case "H":
            return 7;
            default:
            return -1;
        }
    }

    public int getX()
    {   
        return x;
    }

    public int getY()
    {
        return y;
    }
}
