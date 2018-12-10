import java.util.ArrayList;
/**
 * Write a description of class Jump here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jump
{
    // instance variables - replace the example below with your own
    private String to;
    private String from;
    private ArrayList<String> jumped;

    /**
     * Constructor for objects of class Jump
     */
    public Jump(String to, String from)
    {
        this.to=to;
        this.from=from;
        jumped = new ArrayList<String>();
    }
    
    public Jump(String to, String from, ArrayList<String> _jump)
    {
        this.to=to;
        this.from=from;
        jumped = new ArrayList<String>();
        for (String test : _jump) {
                jumped.add(test);
        }
    }

    public void addJumped(String _jumped)
    {
        jumped.add(_jumped);
    }

    public void setTo(String to)
    {
        this.to=to;
    }

    public boolean isInJumped(String jump)
    {
        for (String test : jumped) {
            if(test.equals(jump))
            {
                return true;
            }
        }
        return false;

    }
    
    public String toString()
    {
        String temp = this.to+"-"+this.from+":";
        for (String test : jumped) {
                temp+=test+",";
        }
        return  temp.substring(0, temp.length() - 1);
    }
}
