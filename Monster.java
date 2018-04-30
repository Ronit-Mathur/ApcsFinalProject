
public class Monster {
	private int dmg;
	private int health;
	private double cooldown;
	
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