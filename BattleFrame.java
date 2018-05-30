import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 *  Creates the window of the Battle between a Monster
 *  and a Player
 *
 *  @author  Shannon
 *  @version May 29, 2018
 *  @author  Period: 4
 *  @author  Assignment: ApcsFinalProject
 *
 *  @author  Sources: 
 */
public class BattleFrame extends JFrame
{
    /**
     * Width of the window
     */
    private static final int FRAME_WIDTH = 400;

    /**
     * Height of the window
     */
    private static final int FRAME_HEIGHT = 300;
    
    /**
     * The controls GUI in the frame
     */
    private BattleControls controls;
    
    /**
     * The drawing in the frame
     */
    private BattleComponent scene;
    
    /**
     * Assembles the frame with a component and a
     * GUI. Set the title and size.
     * @param b the Battle the frame involves.
     */
    public BattleFrame(Battle b) 
    {
        this.setTitle( "Battle" );
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controls = new BattleControls( b, this );
        scene = new BattleComponent( controls );
        add(scene);
        this.add(controls, BorderLayout.SOUTH);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
    }
}
