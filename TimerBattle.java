import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimerBattle implements ActionListener
{
    private Player player;

    private Monster monster;

    private Timer timer;

    
    public TimerBattle( Player p, Monster m )

    {
        player = p;
        monster = m;

        timer = new Timer((int)monster.getCool(), this);
    }


    public void startBattle()
    {
        timer.start();
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
        timer.stop();
        if ( win )
        {
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
    private void monsterAttack()
    {
        System.out.println( "monster attack" );
        if ( player.getHealth() >= monster.getDamage() )
        {
            // player gets attacked by monster
            player.lowerHealth(monster.getDamage());
        }
        else
        {
            endBattle( false );
        }
    }


    public void playerAttack()
    {
        if ( monster.getHealth() >= player.getDamage() )
        {
            // player attacks monster
            monster.lowerHealth( player.getDamage() );
        }
        else
        {
            endBattle( true );
        }
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
    
    // this is to test it
//    public static void main(String[] args) throws InterruptedException {
//        Player p = new Player(5,5,null);
//        Monster m = new Monster();
//        Battle battle = new Battle(p, m);
//        battle.startBattle();
//        Thread.sleep( 5000 );
//    }
}
