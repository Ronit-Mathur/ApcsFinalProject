import java.awt.Color;

import javax.swing.JFrame;

public class BattleFrame extends JFrame
{
    private static final int FRAME_WIDTH = 400;

    private static final int FRAME_HEIGHT = 300;
    
    private BattleComponent scene;
    
    public BattleFrame() {
        this.setTitle( "Battle" );
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        scene = new BattleComponent();
        add(scene);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
    }
}
