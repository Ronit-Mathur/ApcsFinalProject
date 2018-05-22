import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Battle implements ActionListener
{
    private Player player;
    private static Queue<Monster> q = new LinkedList<Monster>() 
    {{
            add(new Monster());
    }};
    private Monster monster;
    private boolean ended;
  
    public Battle( Player p, Monster m )
    {
        player = p;
        monster = m;
        ended = false;
    }

    public Battle(Player p) 
    {
        player = p;
        ended = false;
        monster = getNextMonster();
    }
    
    private static void fillMonsterList() 
    {
        int r = (int)(Math.random() * 100);
        if (r < 80) 
        {
            q.add( new Monster() );
        }
        else if (r < 87)
        {
            q.add( new lilPeck() );
        }
        else if (r < 95)
        {
            q.add( new gPeck() );
        }
        else
        {
            q.add( new papaPeck() );
        }
    }
    public void startBattle()
    {
        
    	ended = false;
    }

    private Monster getNextMonster() 
    {
        for (Monster m: q) {
            System.out.println( m.getName() );
        }
        return q.peek();
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
            fillMonsterList();
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
}
