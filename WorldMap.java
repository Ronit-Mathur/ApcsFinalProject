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
    private WorldMapSquare[][] hiddenMap;
    
    /**
     * Creates a grid with a width and height
     * @param width width of grid
     * @param height height of grid
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
    
    
    private void fillHiddenMap()
    {
        int row = (int)(Math.random() * map.length);
        int col = (int)(Math.random() * map.length);
        int i = 0;
        while (i < 15)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.P, 0);
                i++;
            }
            i++;
            row = (int)(Math.random() * map.length);
            col = (int)(Math.random() * map.length);
        }
        
        i = 0;
        while (i < 5)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.H, 0);
                i++;
            }
            row = (int)(Math.random() * map.length);
            col = (int)(Math.random() * map.length);
        }
        
        i = 0;
        while (i < 5)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.D, 0);
                i++;
            }
            row = (int)(Math.random() * map.length);
            col = (int)(Math.random() * map.length);
        }
        
        i = 0;
        while (i < 2)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.B, 0);
                i++;
            }
            row = (int)(Math.random() * map.length);
            col = (int)(Math.random() * map.length);
        }
        
//        i = 0;
//        while (i < 60)
//        {
//            if (!isLocation(row, col))
//            {
//                hiddenMap[row][col] = new WorldMapSquare(Square.M, 100);
//                i++;
//            }
//            row = (int)(Math.random() * map.length);
//            col = (int)(Math.random() * map.length);
//        }
        
        i = 0;
        while (i < 1)
        {
            if (!isLocation(row, col))
            {
                hiddenMap[row][col] = new WorldMapSquare(Square.E, 0);
                i++;
            }
            i++;
            row = (int)(Math.random() * map.length);
            col = (int)(Math.random() * map.length);
        }
    }
    
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
    
    public void showAroundRandom() 
    {
        int r = (int)(Math.random() * map.length);
        int c = (int)(Math.random() * map[r].length);
        while (map[r][c].getSquare() != Square.SPACE)
        {
            r = (int)(Math.random() * map.length);
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
    
    public WorldMapSquare getSquare(int r, int c) {
      if (checkValid(r, c)) {
          return map[r][c];
      }
      else {
          return null;
      }
    }
    
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
    
    public void setSquareToRoad(int r, int c) 
    {
        if (!isLocation(r, c))
        {
            map[r][c] = new WorldMapSquare(Square.HASHTAG, 0);
            hiddenMap[r][c] = new WorldMapSquare(Square.HASHTAG, 0);
        }
        
    }
    
    private boolean isLocation(int r, int c) 
    {
        if (checkValid(r, c)) 
        {
            return (hiddenMap[r][c].getSquare() != Square.PERIOD);
        }
        return false;
    }
    
    public void reset() {
//        map = new WorldMapSquare[getMapRows()][getMapCols()];
//        for (int r = 0; r < getMapRows(); r++) {
//            for (int c = 0; c < getMapCols(); c++) {
//                map[r][c] = new WorldMapSquare(Square.PERIOD, 15);
//            }
//        }
    }
}
