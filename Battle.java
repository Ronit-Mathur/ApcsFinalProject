import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;


public class Battle
{
    private Player player;

    private Monster monster;

    private Timer timer;


    public Battle( Player p, Monster m )

    {
        player = p;
        monster = m;
    }


    public void startBattle()
    {
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                monsterAttack();
                // monster's movement on a timer? or both player and monster?
            }
        };
        timer = new Timer( "Attack" );

        timer.scheduleAtFixedRate( task, 100, 1000 );
    }


    // new vvvv
    /**
     * Ending battle Close battle window? or user closes it themselves? >>
     * possibly move to different class
     * 
     * @param win
     *            true if win
     */
    public void endBattle( boolean win )
    {
        timer.cancel();
        if ( win = true )
        {
            // player win
        }
        else
        {
            // player lose
        }
    }


    /**
     * Monster attacks player Ends battle if monster atkDmg > player health
     */
    private void monsterAttack()
    {
        if ( player.getHealth() < monster.getDamage() )
        {
            // player gets attacked by monster
            player.health -= monster.getDamage();
        }
        else
        {
            endBattle( false );
        }
    }


    public void playerAttack()
    {
        if ( monster.getHealth() > player.getDamage() )
        {
            // player attacks monster
            monster.health -= player.getDamage();
        }
        else
        {
            endBattle( true );
        }
    }


    public void attackMade( KeyEvent k )
    {
        int keyCode = k.getKeyChar();
        if ( keyCode == 32 )
        {
            // spacebar to attack
            playerAttack();
        }
    }
}
