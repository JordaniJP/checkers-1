import java.util.Scanner;
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        System.out.println("Hello World");
        Board b = new Board(true);
        System.out.println(b);
        while(true)
        {
            System.out.println(b.getLegalMoves());
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter from square: ");
            String from = reader.next(); // Scans the next token of the input as an int.
            reader.close();
            
            reader = new Scanner(System.in);
            System.out.println("Enter to square: ");
            String to = reader.next(); // Scans the next token of the input as an int.
            reader.close();
            
            if(b.isLegalMove(from,to))
            {
            b.move(from,to);
            System.out.println(b);
            }
            else
            {
             System.out.println("This is not a legal move");   
            }
        }
    }


}
