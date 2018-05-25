import java.lang.Math;
/**
 * 
 *  Describes each grid square of the WorldMap
 *
 *  @author  
 *  @version Apr 27, 2018
 *  @author  Period: 4
 *  @author  Assignment: Adventure
 *
 *  @author  Sources: TODO
 */
public class WorldMapSquare
{
    private Square square;
    private int danger; 
    private boolean visited;
    /**
     * Creates a grid square
     * @param s the Square enum the square should display
     * @param d the probability there will be a monster on the square
     */
    public WorldMapSquare(Square s, int d) {
        square = s;
        
     // danger level from 0 to 100
        if (d > 100) {
            danger = 100;
        }
        else if (d < 0) {
            danger = 0;
        }
        else {
            danger = d;
        }
        visited = false;
    }
    
    /**
     * Returns the character displayed
     * @return the character displayed
     */
    public char getCharacter() {
        return square.character();
    }
    
    /**
     * Returns the square type
     * @return the square type
     */
    public Square getSquare() {
        return square;
    }
    
    /**
     * Returns true (danger / 100) the time
     * @return true if there is a monster, false if not
     */
    public boolean checkMonster() {
        int dMonster = (int) (Math.random() * 101);
        return dMonster < danger;
    }
    
    /**
     * Set a new character to be displayed
     * @param s a Square to set character to
     */
    public void setCharacter(Square s) {
        square = s;
    }
    
    public void visit(Player p)
    {
        if (!visited)
        {
            effect(p, getSquare());
        }
        if (getSquare() == Square.P || getSquare() == Square.H || getSquare() == Square.D) 
        {
            visited = true;
        }
        
    }
    
    public boolean visited()
    {
        return visited;
    }
    
    private void effect(Player p, Square s)
    {
        if (s == Square.P)
        {
            p.increaseHealth(50);
        }
        else if (s == Square.H)
        {
            p.increaseMaxHealth( 20 );
            p.increaseHealth( 20 );
        }
        else if (s == Square.D) 
        {
            p.increaseDamage(5);
        }
    }
}
