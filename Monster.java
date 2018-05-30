/**
 * 
 *  An entity that can hurt the health of the Player and fights
 *  against the Player in Battles. Has a damage and health.
 *
 *  @author  
 *  @version May 29, 2018
 *  @author  Period: 4
 *  @author  Assignment: ApcsFinalProject
 *
 *  @author  Sources: 
 */
public class Monster
{
    /**
     * Attack Damage
     */
    private int dmg;

    /**
     * Current health Begins same as max health
     */
    private int health;

    /**
     * Monster's maximum health >> ntk for battles and health restoration
     */
    private int maxHealth;


    /**
     * Creates a Monster with a damage and health level
     * @param d
     *            dmg
     * @param h
     *            health
     */
    public Monster( int d, int h )
    {
        dmg = d;
        health = h;
        maxHealth = health;
    }


    /**
     * Monster constructor without parameters Default attack damage of 5 Default
     * health of 40
     */
    public Monster()
    {
        dmg = 5;
        health = 40;
        maxHealth = health;
    }


    /**
     * Returns a random damage between 0.5 to 1.5 times of the damage value.
     * @return a random damage value
     */
    public int getDamage()
    {
        return (int)( dmg / 2.0 + ( dmg * Math.random() ) );
    }


    /**
     * Returns the remaining health
     * @return health remaining
     */
    public int getHealth()
    {
        return health;
    }


    /**
     * Lowers the monster's health by a specified amount
     * 
     * @param d
     *            amount to lower health by
     * @return new health
     */
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
     * Returns the monster's maximum health
     * 
     * @return Monster's max health
     */
    public int getMaxHealth()
    {
        return maxHealth;
    }


    /**
     * Returns the monster's name
     * 
     * @return name
     */
    public String getName()
    {
        return "Monster";
    }

}