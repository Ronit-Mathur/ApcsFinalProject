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
    public WorldMap(int rows, int cols) {
        map = new WorldMapSquare[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == rows / 2 + 1 && j == cols / 2 + 1) {
                    map[j][i] = new WorldMapSquare(Square.A, 50);
                }
                else {
                    map[j][i] = new WorldMapSquare(Square.PERIOD, 50);
                }
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
