import java.util.Timer;
import java.util.TimerTask;

public class Battle {
	private Player player;
	private Monster monster;
	private Timer timer;
	public Battle( Player p, Monster m)
	
	{
		player = p;
		monster = m;
	}
	
	public void startBattle() 
	{
		TimerTask task = new TimerTask() {
        	public void run() {
        		attack();
        	}
        };
        timer = new Timer("Attack");
        timer.scheduleAtFixedRate(task, 100, 1000);
	}
	
	private void attack()
	{
		
	}
}
