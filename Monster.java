
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
     * @return damge
     */
    public int getDamage()
    {
        return (int)( dmg / 2.0 + ( dmg * Math.random() ) );
    }


    /**
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