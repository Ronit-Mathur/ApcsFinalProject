
public class Monster
{
    private int dmg;

    public int health;

    private double cooldown;
    
    private int row;
    
    private int col;
    
    private WorldMap world;

    /**
     * @param d
     *            dmg
     * @param h
     *            health
     * @param cool
     *            cooldown
     */
    public Monster( int d, int h, double cool, int r, int c, WorldMap w)
    {
        dmg = d;
        health = h;
        cooldown = cool;
        row = r;
        col = c;
        world = w;
    }


    /**
     * @return attack damage dealt by monster
     */
    public int getDamage()
    {
        return dmg;
    }


    /**
     * @return health remaining
     */
    public int getHealth()
    {
        return health;
    }


    /**
     * @return Cooldown for attack
     */
    public double getCool()
    {
        return cooldown;
    }

}