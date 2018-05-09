import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


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
                    checkMonster();
                }
                else if ( keyCode == 119 )
                {
                    // W
                    scene.movePlayer( Move.UP );
                    checkMonster();
                }
                else if ( keyCode == 100 )
                {
                    // D
                    scene.movePlayer( Move.RIGHT );
                    checkMonster();
                }
                else if ( keyCode == 115 )
                {
                    // S
                    scene.movePlayer( Move.DOWN );
                    checkMonster();
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

    // TODO: Check if you're on a monster. Start battle.
    private void checkMonster() {
        if(scene.checkMonster()) {
            System.out.println("monster");
            Monster m = new Monster();
            Battle b = new Battle(scene.getPlayer(), m);
            BattleFrame battle = new BattleFrame(b);
            battle.setVisible( true );
        }
        else {
            System.out.println( "no monster" );
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
        setBackground(Color.WHITE);
        
        keyListener = new PlayerMovementKeyListener();
        scene.addKeyListener( keyListener );
        
        scene.setFocusable( true );
        
    }
}
