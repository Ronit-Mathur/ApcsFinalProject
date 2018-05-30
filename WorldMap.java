
/**
 * 
 *  Grid of the world with an array of each WorldMapSquare space in the grid
 *
 *  @author  Shannon, Ronit, Jessabelle
 *  @version Apr 27, 2018
 *  @author  Period: 4
 *  @author  Assignment: Adventure
 *
 *  @author  Sources: 
 */

public class WorldMap
{
    /**
     * The array displayed to the player
     */
    private WorldMapSquare[][] map;
    
    /**
     * The secret array with the locations and exit the
     * Player tries to discover.
     */
    private WorldMapSquare[][] hiddenMap;
    
    /**
     * Creates a grid with a width and height. Fills the map with spaces (from the Square enum)
     * and the hidden map with locations and periods (from the Square enum).
     * @param cols width of grid
     * @param rows height of grid
     */
    public WorldMap(int rows, int cols) {
        map = new WorldMapSquare[rows][cols];
        hiddenMap = new WorldMapSquare[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                map[r][c] = new WorldMapSquare(Square.SPACE, 15);
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                hiddenMap[r][c] = new WorldMapSquare(Square.PERIOD, 15);
            }
        }
        fillHiddenMap();
    }
    
    
    /**
     * Adds locations to the hidden map. Creates 15 'P', 5 'H', 
     * 5 'D', 2 'B', and one exit ('E')
     */
    private void fillHiddenMap()
    {
        int row = (int)(Math.random() * map[0].length);
        int col = (int)(Math.random() * map[0].length);
        int i = 0;
        while (i < 15)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.P, 0);
                i++;
            }
            i++;
            row = (int)(Math.random() * map[0].length);
            col = (int)(Math.random() * map[0].length);
        }
        
        i = 0;
        while (i < 5)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.H, 0);
                i++;
            }
            row = (int)(Math.random() * map[0].length);
            col = (int)(Math.random() * map[0].length);
        }
        
        i = 0;
        while (i < 5)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.D, 0);
                i++;
            }
            row = (int)(Math.random() * map[0].length);
            col = (int)(Math.random() * map[0].length);
        }
        
        i = 0;
        while (i < 2)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.B, 0);
                i++;
            }
            row = (int)(Math.random() * map[0].length);
            col = (int)(Math.random() * map[0].length);
        }
        
        
        i = 0;
        while (i < 1)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.E, 0);
                i++;
            }
            i++;
            row = (int)(Math.random() * map[0].length);
            col = (int)(Math.random() * map[0].length);
        }
    }
    
    /**
     * Reveals on the map what's around the player in the 
     * hidden map. Uses the player's location to show around.
     * @param p the player to reveal squares around
     */
    public void showAround(Player p) 
    {
        int pRow = p.getPlayerRow();
        int pCol = p.getPlayerCol();
        for (int i = -3; i <= 3; i++) 
        {
            for (int j = -3; j <= 3; j++) 
            {
                if (Math.abs( j ) + Math.abs( i ) <= 3)
                {
                    if (checkValid(pRow + i, pCol + j)) 
                    {
                        map[pRow + i][pCol + j] = hiddenMap[pRow + i][pCol+j];
                    }
                }
                
            }
        }
    }
    
    /**
     * Randomly picks a location on the map that is still hidden
     * to show around (by copying what's on the hidden map to the 
     * visible map).
     */
    public void showAroundRandom() 
    {
        int r = (int)(Math.random() * map[0].length);
        int c = (int)(Math.random() * map[r].length);
        while (map[r][c].getSquare() != Square.SPACE)
        {
            r = (int)(Math.random() * map[0].length);
            c = (int)(Math.random() * map[r].length);
        }
        for (int i = -4; i <= 4; i++) 
        {
            for (int j = -4; j <= 4; j++) 
            {
                if (Math.abs( j ) + Math.abs( i ) <= 4)
                {
                    if (checkValid(r + i, c + j)) 
                    {
                        map[r + i][c + j] = hiddenMap[r + i][c + j];
                    }
                }
                
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
    
    /**
     * Returns the WorldMap square at a row/col combination on the grid.
     * @param r the row of the square (from 0)
     * @param c the column of the square (from 0)
     * @return the WorldMapSquare at the row/col location, or null if the location
     * isn't valid.
     */
    public WorldMapSquare getSquare(int r, int c) {
      if (checkValid(r, c)) {
          return map[r][c];
      }
      else {
          return null;
      }
    }
    
    /**
     * Checks to see if the WorldMapSquare at a row and column contains a Monster.
     * @param r the row of the square (from 0)
     * @param c the column of the square (from 0)
     * @return true if the square at row/column has a monster. false if there's no
     * Monster or if the row/column isn't valid.
     */
    public boolean checkMonster(int r, int c) {
        if (checkValid(r, c)) {
            return getSquare(r, c).checkMonster();
        }
        return false;
    }
    
    /**
     * Helper method for whether the coordinate is in the map or not
     * @param r row number of coordinate (starting from 0)
     * @param c column number of coordinate (starting from 0)
     * @return true if the row and column are in the map
     */
    private boolean checkValid(int r, int c) {
        return !(r < 0 || r >= map.length || c < 0 || c >= map[0].length);
    }
    
    /**
     * Sets the WorldMapSquare at a row and column to a Square.HASHTAG with
     * 0 danger on the visible and hidden map.
     * @param r the row of the square (from 0)
     * @param c the column of the square (from 0)
     */
    public void setSquareToRoad(int r, int c) 
    {
        if (!isLocation(r, c))
        {
            map[r][c] = new WorldMapSquare(Square.HASHTAG, 0);
            hiddenMap[r][c] = new WorldMapSquare(Square.HASHTAG, 0);
        }
        
    }
    
    /**
     * Checks if the square at a row and column is a location, which means it isn't
     * a period. Locations are the other Square enum characters.
     * @param r the row of the square (from 0)
     * @param c the column of the square (from 0)
     * @return true if the WorldMapSquare is a location, false if it isn't a location or
     * the row/column combination isn't on the map.
     */
    private boolean isLocation(int r, int c) 
    {
        if (checkValid(r, c)) 
        {
            return (hiddenMap[r][c].getSquare() != Square.PERIOD);
        }
        return false;
    }
    
  
}
