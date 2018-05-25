import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridLayout;

import java.util.Timer;
import java.util.TimerTask;


public class BattleControls extends JPanel
{
    private JLabel label = new JLabel( "Fight!" );

    private ActionListener attack;

    private ActionListener block;
    
    private Battle battle;

    private BattleFrame frame;
    
    private boolean skip = false;
    
    Timer timer;

    public BattleControls( Battle b, BattleFrame f )
    {
        battle = b;
        frame = f;
        JButton aButton = new JButton( "Attack" );
        JButton bButton = new JButton( "Block" );
        
        timer = new Timer();
        attack = new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                if ( !battle.checkEnded() )
                {
                    
                    battle.playerAttack();
                    if ( !battle.checkEnded() )
                    {
                        System.out.println(skip);
                    	if (!skip) 
                        {
                    	    
                            timer.schedule(new TimerTask() {
                                public void run()
                                {
                                    battle.monsterAttack();
                                }
                                
                            }, 200);
                        	
                        }
                        else
                        {
                        	skip = false;
                        }
                    	
                    }
                    else
                    {
                        timer.cancel();
                    }
                }
                else
                {
                    System.out.println( "Not Attacked" );
                    timer.cancel();
                    
                    frame.dispose();
                }
                
                if (battle.checkEnded()) {
                    timer.cancel();
                    frame.dispose();
                }
            }
        };
        aButton.addActionListener( attack );
        block = new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                if (!battle.checkEnded())
                {
                    double chanceOfBlock = .35;
                    if ( Math.random() <= chanceOfBlock )
                    {
                        if ( battle.getPlayer().getHealth() <= (battle.getPlayer().getMaxHealth() - 10) )
                        {
                            battle.getPlayer().increaseHealth(10);
                            skip = true;
                            System.out.println( "Blocked" );
                        }
                    }
                    else
                    {
                        skip = false;
                        battle.monsterAttack();
                        System.out.println( "Not Blocked" );
                    }
                }
                else
                {
                    System.out.println( "Not Attacked" );
                    timer.cancel();
                    
                    frame.dispose();
                }
                
                if (battle.checkEnded()) {
                    timer.cancel();
                    frame.dispose();
                }
                
            }
        };
        bButton.addActionListener( block );
        add( aButton );
        this.setBorder( BorderFactory.createEmptyBorder( 30, 30, 10, 30 ) );
        this.setLayout( new GridLayout( 0, 1 ) );
        this.add( aButton );
        this.add( bButton );
        this.add( label );
    }

    public Battle getBattle() 
    {
        return battle;
    }
    
    public Player getPlayer()
    {
        return battle.getPlayer();
    }
    
    public Monster getMonster() 
    {
        return battle.getMonster();
    }
}
