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
    private Player player;
    
    /**
     * Creates a grid with a width and height
     * @param width width of grid
     * @param height height of grid
     */
    public WorldMap(int rows, int cols) {
        map = new WorldMapSquare[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[j][i] = new WorldMapSquare(Square.PERIOD, 50);
                
            }
        }
    }
    
    /**
     * Returns the map
     * @return the grid of WorldMap
     */
    public WorldMapSquare[][] getMap() {
        return map;
    }
    
    /**
     * Returns the number of rows in map
     * @return number of rows in map
     */
    public int getMapRows() {
        return map.length;
    }
    
    /**
     * Returns the number of columns in map
     * @return number of columns in map, null if the coordinates are not valid
     */
    public int getMapCols() {
        return map[0].length;
    }
    
    public WorldMapSquare getSquare(int r, int c) {
      if (checkValid(r, c)) {
          return map[r][c];
      }
      else {
          return null;
      }
    }
    
    
    /**
     * Helper method for whether the coordinate is in the map or not
     * @param r row number of coordinate (starting from 0)
     * @param c column number of coordinate (starting from 0)
     * @return true if the row and column are in the map
     */
    private boolean checkValid(int r, int c) {
        return !(r < 0 || r > map.length || c < 0 || c > map[0].length);
    }
}
