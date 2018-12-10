
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    private Square[][] board;
    boolean isBlacksTurn;

    /**
     * Constructor for objects of class Board.  Creates an empty board
     */
    public Board()
    {
        board = new Square[8][8];
        isBlacksTurn=true;
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(y<=2 && (x+y)%2==0 )
                {
                    board[x][y]=new Square(x,y,new Red());
                }
                else if (y>=5 && (x+y)%2==0)
                {
                    board[x][y]=new Square(x,y,new Black());
                }
                else
                {
                    board[x][y]=new Square(x,y);
                }
            }
        }
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)

            {
                Square temp =board[x][y];
                if(x>0 && y>0)
                    temp.addSouthWestNeighbor(board[x-1][y-1]);
                if(x>0 && y<7)
                    temp.addNorthWestNeighbor(board[x-1][y+1]);
                if(x<7 && y>0)
                    temp.addSouthEastNeighbor(board[x+1][y-1]);
                if(x<7 && y<7)
                    temp.addNorthEastNeighbor(board[x+1][y+1]);
            }
        }
    }

    public Board(boolean rad)
    {
        board = new Square[8][8];
        isBlacksTurn=true;
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(y<=2 && (x+y)%2==0 )
                {
                    board[x][y]=new Square(x,y);
                }
                else if (y>=5 && (x+y)%2==0)
                {
                    board[x][y]=new Square(x,y);
                }
                else
                {
                    board[x][y]=new Square(x,y);
                }
            }
        }
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)

            {
                Square temp =board[x][y];
                if(x>0 && y>0)
                    temp.addSouthWestNeighbor(board[x-1][y-1]);
                if(x>0 && y<7)
                    temp.addNorthWestNeighbor(board[x-1][y+1]);
                if(x<7 && y>0)
                    temp.addSouthEastNeighbor(board[x+1][y-1]);
                if(x<7 && y<7)
                    temp.addNorthEastNeighbor(board[x+1][y+1]);
            }
        }
        board[2][2].addPiece(new Red());
        board[2][4].addPiece(new Red());
        board[4][4].addPiece(new Red());
        board[1][1].addPiece(new Black());
    }

    public String getMoves(boolean isBlack)
    {
        String moves="";
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)

            {
                moves+=board[x][y].getMoves(isBlack);
                Jump temp = board[x][y].getJump(isBlack);
                if (temp!=null)
                {
                    moves+="|"+temp.toString();
                }
            }

        }
        return moves;
    }

    public String getLegalMoves()
    {
        return getMoves(isBlacksTurn);
    }

    public boolean isLegalMove(String from, String to)
    {
        String moves = getMoves(isBlacksTurn);
        String testMove = from+"-"+ to;
        if (moves.contains(testMove))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /***
     * A method that will move a piece from a given sqaure to a given square.  This 
     * does not do any sanity checks.
     * @pram from the square to move from.  Given in chess format i.e. "A4"
     * @pram to the square to move to.  Given in chess format i.e. "B5".
     */
    public void move(String from, String to)
    {
        //A4-B5
        //move is in 
        int fromY= Integer.parseInt(""+from.charAt(1))-1;
        int fromX=Square.getNumber(""+from.charAt(0));
        int toY= Integer.parseInt(""+to.charAt(1))-1;
        int toX=Square.getNumber(""+to.charAt(0));
        int oldPiece = board[fromX][fromY].getColor();
        board[fromX][fromY].removePiece();
        if(oldPiece==Square.BLACK)
        {
            board[toX][toY].addPiece(new Black());
        }
        else
        {
            board[toX][toY].addPiece(new Red());
        }
        isBlacksTurn=!isBlacksTurn;
    }

    public String getMoves()
    {
        return this.getMoves(true) +" " + this.getMoves(false);
    }

    /**
     * A method that will return an ASCII text version of the board
     * @return the string version of the board;
     */
    public String toString()
    {
        String line="  +---+---+---+---+---+---+---+---+";
        String column = " |  |   |   |   |   |   |   |   |";
        String temp=line;
        for (int y=7;y>=0;y--)
        {
            temp+="\n"+ (y+1)+" |" ;
            for(int x=0;x<8;x++)
            {
                if(board[x][y].isEmpty())
                {
                    temp+="   |";
                }
                else if(board[x][y].getColor()==Square.BLACK )
                {
                    temp+=" b |";
                }
                else if(board[x][y].getColor()==Square.RED )
                {
                    temp+=" r |";
                }
            }
            temp+="\n"+line;
        }

        temp+="\n    a   b   c   d   e   f   g   h  ";
        return temp;
    }
}
