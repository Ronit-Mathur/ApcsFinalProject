import java.lang.Math;
/**
 * 
 *  Describes each grid square of the WorldMap. Has a chance of holding a
 *  Monster. 
 *
 *  @author  Shannon
 *  @version Apr 27, 2018
 *  @author  Period: 4
 *  @author  Assignment: Adventure
 *
 *  @author  Sources: TODO
 */
public class WorldMapSquare
{
    /**
     * The type of square it is (displays a constant character)
     */
    private Square square;
    
    /**
     * A percent that there will be a monster on the square
     */
    private int danger; 
    /**
     * True if the Player has been on this square before.
     */
    private boolean visited;
    /**
     * True if this square is an exit to the game (if the player
     * steps on it, they win the game).
     */
    private boolean exit;
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
        
        exit = (s == Square.E);
    }
    
    /**
     * Returns the character displayed
     * @return the character displayed
     */
    public char getCharacter() {
        return square.character();
    }
    
    /**
     * Returns the square enum type
     * @return the square enum type
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
    
    /**
     * Sets visited to true when the Player is on the square. If the Player hasn't visited the
     * square before, it calls to make the WorldMapSquare have an effect on the Player's stats.
     * @param p the Player to visit the square and be influenced by the square.
     */
    public void visit(Player p)
    {
        if (!visited)
        {
            effect(p, getSquare());
        }
        if (getSquare() == Square.P || getSquare() == Square.H || getSquare() == Square.D || getSquare() == Square.B) 
        {
            visited = true;
        }
        
    }
    
    /**
     * Returns whether the player has visited the square before or not
     * @return true if the player has visited the square before. false if the player hasn't.
     */
    public boolean visited()
    {
        return visited;
    }
    
    /**
     * Returns whether this square is the exit.
     * @return true if the square is an exit. (the "exit" field)
     */
    public boolean isExit()
    {
        return exit;
    }
    
    /**
     * Called if the Player hasn't visited the square before. Depending on the Square enum
     * of this WorldMapSquare, the Player's health, damage, or block will be affected when stepping
     * on this square. Stepping on a 'P' increases the Player's health by 50. Stepping on
     * the 'H' increases the Player's max health by 20 and increases their health to max. Stepping
     * on 'D' increases the Player's damage by 5. Stepping on 'B' increases the Player's block
     * by 3. Stepping on 'M' makes the WorldMap reveal a random area.
     * @param p the Player to affect by stepping on the square
     * @param s the Square enum type the player stepped on
     */
    private void effect(Player p, Square s)
    {
        if (s == Square.P)
        {
            p.increaseHealth(50);
        }
        else if (s == Square.H)
        {
            p.increaseMaxHealth( 20 );
            p.increaseHealthToMax();
        }
        else if (s == Square.D) 
        {
            p.increaseDamage(5);
        }
        else if (s == Square.B)
        {
            p.increaseBlock(3);
        }
        else if (s == Square.M)
        {
            p.getWorld().showAroundRandom();
        }
    }
}
