/**
 * 
 * Location of the player on the map
 *
 * @author 
 * @version Apr 27, 2018
 * @author Period: 4
 * @author Assignment: ApcsFinalProject
 *
 * @author Sources: TODO
 */
public class Player
{

    private int playerRow;

    private int playerCol;

    private WorldMap world;

    private int dmg;

    private int health;

    private int cooldown;
    
    private int maxHealth;


    /**
     * Constructs player and lets them start somewhere on the grid
     * 
     * @param r
     *            row number for player to start (begins at 0)
     * @param c
     *            column number for player to start (begins at 0)
     */
    public Player( int r, int c, WorldMap w )
    {
        this(r, c, w, 10, 100, 10);
    }
    
    public Player(int r, int c, WorldMap w, int damage, int h, int cool) {
        playerRow = r;
        playerCol = c;
        world = w;
        
        dmg = damage;
        health = h;
        cooldown = cool;
        maxHealth = h;
    }


    /**
     * Moves the location of the Player one row up
     * 
     * @return true if the change in location was successful
     */
    public boolean moveUp()
    {
        if ( checkMove( playerRow - 1, playerCol ) )
        {
            playerRow--;
            world.showAround(this);
            world.getSquare( playerRow, playerCol ).visit(this);
            return true;
        }
        else
        {
            return false;
        }
        
    }


    /**
     * Moves the location of the Player one row down
     * 
     * @return true if the change in location was successful
     */
    public boolean moveDown()
    {
        if ( checkMove( playerRow + 1, playerCol ) )
        {
            playerRow++;
            world.showAround(this);
            world.getSquare( playerRow, playerCol ).visit(this);
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Moves the location of the Player one column left
     * 
     * @return true if the change in location was successful
     */
    public boolean moveLeft()
    {
        if ( checkMove( playerRow, playerCol - 1 ) )
        {
            playerCol--;
            world.showAround(this);
            world.getSquare( playerRow, playerCol ).visit(this);
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Moves the location of the Player one column right
     * 
     * @return true if the change in location was successful
     */
    public boolean moveRight()
    {
        if ( checkMove( playerRow, playerCol + 1 ) )
        {
            playerCol++;
            world.showAround(this);
            world.getSquare( playerRow, playerCol ).visit(this);
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Moves player to an area in the grid
     * 
     * @param r
     *            row number for player to start (begins at 0)
     * @param c
     *            column number for player to start (begins at 0)
     */
    public void jump( int r, int c )
    {
        playerRow = r;
        playerCol = c;
    }


    /**
     * Returns the row the player is on
     * 
     * @return the row the player is on
     */
    public int getPlayerRow()
    {
        return playerRow;
    }


    /**
     * Returns the column the player is on
     * 
     * @return the column the player is on
     */
    public int getPlayerCol()
    {
        return playerCol;
    }


    private boolean checkMove( int r, int c )
    {
        return !( r < 0 || r > world.getMapRows() - 1 || c < 0 || c > world.getMapCols() - 1 );
    }


    public int getHealth()
    {
        return health;

    }
    
    public int getMaxHealth()
    {
        return maxHealth;

    }


    public int getBaseDamage()
    {
        return dmg;
    }
    
    public int getDamage()
    {
        return (int)(dmg / 2.0 + (dmg * Math.random()));
    }
    
    public int lowerHealth(int d) 
    {
        health -= d;
        if (health < 0) {
            health = 0;
            return 0;
        }
        return health;
    }
    
    public int increaseHealth(int d)
    {
    	if ((health +d ) < maxHealth )
    	{
    		health += d;
    		return health;
    	}
    	else
    	{
    		health = maxHealth;
    		return health;
    	}
    }
    
    public int increaseMaxHealth(int d) 
    {
        maxHealth += d;
        return maxHealth;
    }
    
    public int increaseDamage(int d)
    {
        dmg += d;
        return dmg;
    }
    
    public boolean checkDeath() 
    {
        return health == 0;
    }
}
