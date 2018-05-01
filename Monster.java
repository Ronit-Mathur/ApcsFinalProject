
public class Monster {
	private int dmg;
	public int health;
	private double cooldown;
	
	/**
	 * @param d dmg
	 * @param h health
	 * @param c cooldown
	 */
	public Monster(int d, int h, double c) {
		dmg = d;
		health = h;
		cooldown = c;
	}
	/**
	 * @return damge
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