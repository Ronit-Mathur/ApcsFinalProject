import java.util.*;
/**
 * 
 *  Grid of the world with an array of each block in the grid
 *
 *  @author  
 *  @version Apr 27, 2018
 *  @author  Period: 4
 *  @author  Assignment: Adventure
 *
 *  @author  Sources: 
 */

public class WorldMap
{
    private WorldMapSquare[][] map;
    
    /**
     * Creates a grid with a width and height
     * @param width width of grid
     * @param height height of grid
     */
    public WorldMap(int width, int height) {
        map = new WorldMapSquare[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[j][i] = new WorldMapSquare('+', 50);
            }
        }
        setStart(0,0);
    }
    
    /**
     * Returns the map
     * @return the grid of WorldMap
     */
    public WorldMapSquare[][] getMap() {
        return map;
    }
    
    /**
     * Sets where the player begins in the grid
     * @param r row number for player to start (begins at 0)
     * @param c column number for player to start (begins at 0)
     */
    private void setStart(int r, int c) {
        
    }
    
    /**
     * Moves player to an area in the grid
     * @param r row number for player to start (begins at 0)
     * @param c column number for player to start (begins at 0)
     */
    private void jump(int r, int c) {
        
    }
}
