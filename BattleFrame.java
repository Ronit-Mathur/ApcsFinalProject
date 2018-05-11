import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BattleFrame extends JFrame
{
    private static final int FRAME_WIDTH = 400;

    private static final int FRAME_HEIGHT = 300;
    
    private BattleControls controls;
    private BattleComponent scene;
    private JPanel panel;
    
    public BattleFrame(Battle b) 
    {
        this.setTitle( "Battle" );
        
//        this.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        controls = new BattleControls( b, this );
        scene = new BattleComponent( controls );
//        panel.add(scene);
//        add(controls);
        add(scene);
        this.add(controls, BorderLayout.SOUTH);
//        this.add(scene, BorderLayout.EAST);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
    }
}
