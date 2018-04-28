import javax.swing.JFrame;
/**
 * 
 *  Describes the JFrame the Adventure game should open in
 *  Also controls the game // TODO
 *
 *  @author  
 *  @version Apr 27, 2018
 *  @author  Period: 4
 *  @author  Assignment: Adventure
 *
 *  @author  Sources: 
 */
public class AdventureFrame extends JFrame
{
    private AdventureComponent scene;
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 500;
    
    /**
     * Sets parameters of the JFrame and adds the Adventure game to it
     */
    public AdventureFrame() {
        scene = new AdventureComponent();
        add(scene);
        setSize( FRAME_WIDTH, FRAME_HEIGHT);
    }
}
