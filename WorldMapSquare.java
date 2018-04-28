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
    public boolean checkDanger() {
        int d = (int) Math.random() * 101;
        return d < danger;
    }
    
    /**
     * Set a new character to be displayed
     * @param s a Square to set character to
     */
    public void setCharacter(Square s) {
        square = s;
    }
}
