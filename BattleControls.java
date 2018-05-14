import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridLayout;


public class BattleControls extends JPanel
{
    private JLabel label = new JLabel( "Fight!" );

    private ActionListener attack;

    private ActionListener block;
    
    private Battle battle;

    private BattleFrame frame;

    public BattleControls( Battle b, BattleFrame f )
    {
        battle = b;
        frame = f;
        JButton aButton = new JButton( "Attack" );
        JButton bButton = new JButton( "Block" );
        attack = new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                if ( !battle.checkEnded() )
                {
                    
                    battle.playerAttack();
                    if ( !battle.checkEnded() )
                    {
                        // TODO: Add a delay for the monster attack
                        battle.monsterAttack();
                    }
                    else 
                    {
                        frame.dispose();
                    }
                }
                else
                {
<<<<<<< HEAD
                    System.out.println( "Not Attacked" );
                    
                    // TODO: close window
=======
                    frame.dispose();
>>>>>>> b111fd139305efe8d5e0dc9df3ba620240612479
                }
            }
        };
        aButton.addActionListener( attack );
        block = new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                System.out.println( "Blocked" ); // TODO
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
