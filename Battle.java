import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;


public class Battle implements ActionListener
{
    private Player player;
    private Queue<Monster> q;
    private Monster monster;
    private boolean ended;
  
    public Battle( Player p, Monster m )

    {
        player = p;
        monster = m;
        ended = false;
        q = new LinkedList<Monster>();
        fillMonsterQueue();
    }

    public Battle(Player p) 
    {
        player = p;
        ended = false;
        q = new LinkedList<Monster>();
        fillMonsterQueue();
        monster = getNextMonster();
    }
    public void startBattle()
    {
        
    	ended = false;
    }

    private Monster getNextMonster() 
    {
        return q.peek();
    }
    
    private void fillMonsterQueue() 
    {
        q.add( new gPeck() );
        q.add( new lilPeck() );
        q.add( new papaPeck() );
    }

    /**
     * Ending battle Close battle window? or user closes it themselves? >>
     * possibly move to different class
     * 
     * @param win
     *            true if win
     */
    public void endBattle( boolean win )
    {
        if ( win )
        {
            q.remove();
            // player win
            System.out.println( "Player won" );
        }
        else
        {
            // player lose
            System.out.println( "Player lost" );
            
        }
    }


    /**
     * Monster attacks player Ends battle if monster atkDmg > player health
     */
    public void monsterAttack()
    {
        System.out.println( "monster attack" );
        player.lowerHealth(monster.getDamage());
        if ( player.getHealth() != 0 )
        {
            // player gets attacked by monster
            
            System.out.println("Monster attacked with " + monster.getDamage() + " and the player's health is now " + player.getHealth());
            
        }
        else
        {
            endBattle( false );
            ended = true;
        }
    }


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

    public boolean checkEnded() 
    {
    	return ended;
    }

//    public void attackMade( KeyEvent k )
//    {
//        int keyCode = k.getKeyChar();
//        if ( keyCode == 32 )
//        {
//            // spacebar to attack
//            playerAttack();
//        }
//    }
    
    @Override
    public void actionPerformed( ActionEvent e )
    {
        monsterAttack();
        System.out.println( "Player HP: " + player.getHealth() );
        System.out.println( "Monster HP: " + monster.getHealth() );
    }
    
    
    public Player getPlayer() 
    {
        return player;
    }
    
    public Monster getMonster()
    {
        return monster;
    }
    // this is to test it
//    public static void main(String[] args) throws InterruptedException {
//        Player p = new Player(5,5,null);
//        Monster m = new Monster();
//        Battle battle = new Battle(p, m);
//        battle.startBattle();
//        Thread.sleep( 5000 );
//    }
}
