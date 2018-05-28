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

    /**
     * Player's row on map grid
     */
    private int playerRow;

    /**
     * Player's column on map grid
     */
    private int playerCol;

    /**
     * WorldMap player is in
     */
    private WorldMap world;

    /**
     * Attack Damage
     */
    private int dmg;

    /**
     * Player's Health
     */
    private int health;

    /**
     * Block constant Multiplied by a random value to determine whether user can
     * block monster's attack or not
     */
    private int block;

    /**
     * Player's maximum health ntk for health restoration
     */
    private int maxHealth;

    /**
     * Number of steps it takes for player to reach end or die
     */
    private int steps;


    /**
     * Constructs player and lets them start somewhere on the grid
     * 
     * @param r
     *            row number for player to start (begins at 0)
     * @param c
     *            column number for player to start (begins at 0)
     * @param w   worldmap player spawns in
     */ 
    public Player( int r, int c, WorldMap w )
    {
        this( r, c, w, 10, 100, 35 );

    }


    /**
     * Constructs player and lets them start somewhere on the grid
     * @param r row number for player to start (begins at 0)
     * @param c column number for player to start (begins at 0)
     * @param w worldmap player spawns in
     * @param damage starting attack damage
     * @param h starting health
     * @param b block constant
     */
    public Player( int r, int c, WorldMap w, int damage, int h, int b )
    {
        playerRow = r;
        playerCol = c;
        world = w;

        if ( dmg < 0 )
        {
            dmg = 10;
        }
        else
        {
            dmg = damage;
        }
        if ( health < 0 )
        {
            health = 100;
        }
        else
        {
            health = h;
        }

        if ( block < 0 )
        {
            block = 0;
        }
        else if ( block > 100 )
        {
            block = 100;
        }
        else
        {
            block = b;
        }

        maxHealth = health;
        steps = 0;
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
            world.showAround( this );
            world.getSquare( playerRow, playerCol ).visit( this );
            steps++;
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
            world.showAround( this );
            world.getSquare( playerRow, playerCol ).visit( this );
            steps++;
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
            world.showAround( this );
            world.getSquare( playerRow, playerCol ).visit( this );
            steps++;
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
            world.showAround( this );
            world.getSquare( playerRow, playerCol ).visit( this );
            steps++;
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


    /**
     * Checks whether player's move is valid and within grid
     * @param r row player is moving to
     * @param c column player is moving to
     * @return true if within the grid
     */
    private boolean checkMove( int r, int c )
    {
        return !( r < 0 || r > world.getMapRows() - 1 || c < 0 || c > world.getMapCols() - 1 );
    }


    /**
     * Return's player's current health
     * @return player's current health
     */
    public int getHealth()
    {
        return health;

    }


    /**
     * Return's the max health the player can reach
     * @return player's max health
     */
    public int getMaxHealth()
    {
        return maxHealth;

    }


    /**
     * Returns player's potential damage
     * @return potential damage
     */
    public int getBaseDamage()
    {
        return dmg;
    }


    /**
     * Calculates random damage player deals with an attack
     * @return damage
     */
    public int getDamage()
    {
        return (int)( dmg / 2.0 + ( dmg * Math.random() ) );
    }


    /**
     * Returns block constant
     * @return block value
     */
    public int getBlock()
    {
        return block;
    }


    public int lowerHealth( int d )
    {
        health -= d;
        if ( health < 0 )
        {
            health = 0;
            return 0;
        }
        return health;
    }


    /**
     * Heals the player by a specified amount
     * @param d value to heal player by
     * @return new health
     */
    public int increaseHealth( int d )
    {
        if ( ( health + d ) < maxHealth )
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


    /**
     * Increases health threshold by specified amuount
     * @param d value to increase maxHealth by
     * @return new maxHealth
     */
    public int increaseMaxHealth( int d )
    {
        maxHealth += d;
        return maxHealth;
    }


    /**
     * Heals player completely
     * @return health
     */
    public int increaseHealthToMax()
    {
        health = maxHealth;
        return health;
    }


    /**
     * Increases damage constant
     * @param d value to increase damage by
     * @return new attack damage
     */
    public int increaseDamage( int d )
    {
        dmg += d;
        return dmg;
    }


    /**
     * Increases block constant, max of 100
     * @param d value to increase block by
     * @return new block value
     */
    public int increaseBlock( int d )
    {
        block += d;
        if ( block > 100 )
        {
            block = 100;
        }
        return block;
    }


    /**
     * Checks if player's health is at 0
     * @return true if dead
     */
    public boolean checkDeath()
    {
        return health == 0;
    }


    public int getSteps()
    {
        return steps;
    }


    public WorldMap getWorld()
    {
        return world;
    }
}
