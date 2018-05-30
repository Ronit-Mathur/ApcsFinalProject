import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 *  Simulates a battle between a Monster and Player. Affects their
 *  health levels and maximum health.
 *
 *  @author  
 *  @version May 29, 2018
 *  @author  Period: 4
 *  @author  Assignment: ApcsFinalProject
 *
 *  @author  Sources: 
 */
public class Battle
{
    /**
     * The player in the battle.
     */
    private Player player;
    
    /**
     * A list of the upcoming monsters the Battle will involve.
     */
    public static Queue<Monster> q = new LinkedList<Monster>() 
    {{
            add(new Monster());
    }};
    
    /**
     * The monster in the battle
     */
    private Monster monster;
    
    /**
     * Tells if the battle is over (either the Monster or Player
     * has 0 health).
     */
    private boolean ended;
  
    /**
     * Creates a Battle against a chosen Monster
     * @param p the player that fights in the battle
     * @param m the monster to face in the battle
     */
    public Battle( Player p, Monster m )
    {
        player = p;
        monster = m;
        ended = false;
    }

    /**
     * Creates a Battle against a monster in the queue
     * @param p the player that fights in the battle
     */
    public Battle(Player p) 
    {
        player = p;
        ended = false;
        monster = getNextMonster();
    }
    
    /**
     * Adds a new Monster to the queue of Monster to fight
     * based off random numbers.
     */
    private static void fillMonsterList() 
    {
        int r = (int)(Math.random() * 100);
        if (r < 80) 
        {
            q.add( new Monster() );
        }
        else if (r < 90)
        {
            q.add( new lilPeck() );
        }
        else if (r < 97)
        {
            q.add( new gPeck() );
        }
        else
        {
            q.add( new papaPeck() );
        }
    }
    
    /**
     * Begins the battle.
     */
    public void startBattle()
    {
        
    	ended = false;
    }

    /**
     * Checks for the next Monster in the Battle queue
     * @return the Monster at the front of the queue
     */
    private Monster getNextMonster() 
    {
        
        return q.peek();
    }
    
    /**
     * Ending battle and affects the Player depending on 
     * if they won or not
     * 
     * @param win
     *            true if the player won win and false if the Monster won
     */
    public void endBattle( boolean win )
    {
        if ( win )
        {
            q.remove();
            fillMonsterList();
            // player win
            System.out.println( "Player won" );
            player.increaseMaxHealth( 5 );
        }
        else
        {
            // player lose
            System.out.println( "Player lost" );
            
        }
    }


    /**
     * Monster attacks player and lowers the player's health
     * Says the battle ended if monster atkDmg > player health
     */
    public void monsterAttack()
    {
        System.out.println( "monster attack" );
        player.lowerHealth(monster.getDamage());
        if ( player.getHealth() != 0 )
        {
            // player gets attacked by monster
        }
        else
        {
            endBattle( false );
            ended = true;
        }
    }

    /**
     * Player attacks monster and lowers the monster's health
     * Says the battle ended if player's atkDmg > monster health
     */
    public void playerAttack()
    {
        monster.lowerHealth( player.getDamage() );
        if ( monster.getHealth() != 0 )
        {
            // player attacks monster
            
            System.out.println("Player attacked with " + player.getDamage() + " and the monster's health is now " + monster.getHealth());
        }
        else
        {
            endBattle( true );
            ended = true;
        }
    }

    /**
     * Returns if the Battle is over or not
     * @return true if the Battle is over and one side won, false otherwise.
     */
    public boolean checkEnded() 
    {
    	return ended;
    }

    
    /**
     * Returns the Player in the battle
     * @return the player in the battle
     */
    public Player getPlayer() 
    {
        return player;
    }
    
    /**
     * Returns the Monster in the battle
     * @return the monster in the battle
     */
    public Monster getMonster()
    {
        return monster;
    }
}
