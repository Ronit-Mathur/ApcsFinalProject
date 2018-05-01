import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * Describes the JFrame the Adventure game should open in Also controls the game
 * // TODO
 *
 * @author
 * @version Apr 27, 2018
 * @author Period: 4
 * @author Assignment: Adventure
 *
 * @author Sources:
 */
public class AdventureFrame extends JFrame
{
    private AdventureComponent scene;

    private static final int FRAME_WIDTH = 800;

    private static final int FRAME_HEIGHT = 500;

    private PlayerMovementKeyListener keyListener;
    
    private Timer timer;


    class PlayerMovementKeyListener implements KeyListener
    {
        private boolean pressed;


        public void keyPressed( KeyEvent k )
        {
            if ( !pressed )
            {
                int keyCode = k.getKeyChar();
                if ( keyCode == 97 )
                {
                    // A
                    scene.movePlayer( Move.LEFT );
                }
                else if ( keyCode == 119 )
                {
                    // W
                    scene.movePlayer( Move.UP );
                }
                else if ( keyCode == 100 )
                {
                    // D
                    scene.movePlayer( Move.RIGHT );
                }
                else if ( keyCode == 115 )
                {
                    // S
                    scene.movePlayer( Move.DOWN );
                }
                pressed = true;
            }

        }


        public void keyReleased( KeyEvent k )
        {
            pressed = false;
        }


        public void keyTyped( KeyEvent k )
        {
      
        }
    }


    /**
     * Sets parameters of the JFrame and adds the Adventure game to it
     */
    public AdventureFrame()
    {
        scene = new AdventureComponent();
        add( scene );
        setSize( FRAME_WIDTH, FRAME_HEIGHT );
        keyListener = new PlayerMovementKeyListener();
        scene.addKeyListener( keyListener );
        
        TimerTask task = new TimerTask() {
        	public void run() {
        		System.out.println("hello");
        		
        	}
        };
        timer = new Timer("Attack");
        timer.scheduleAtFixedRate(task, 100, 1000);
        
        scene.setFocusable( true );
        
    }
}
