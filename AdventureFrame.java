import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * 
 * Describes the JFrame the Adventure game should open in Also controls the game
 * // TODO
 *
 * @author Shannon
 * @version Apr 27, 2018
 * @author Period: 4
 * @author Assignment: Adventure
 *
 * @author Sources:
 */
public class AdventureFrame extends JFrame
{
    /**
     * The drawing to display in the JFrame
     */
    private AdventureComponent scene;

    /**
     * The width of the window
     */
    private static final int FRAME_WIDTH = 800;

    /**
     * The height of the window
     */
    private static final int FRAME_HEIGHT = 500;

    /**
     * A custom KeyListener so the user can interact
     * with the game
     */
    private PlayerMovementKeyListener keyListener;
    
    /**
     * Allows/prevents the key listener from acting in certain conditions.
     */
    private boolean canMove;

    /**
     * 
     *  Listens for keyboard controls for the player.
     *  Looks for WASD to move.
     *
     *  @author  
     *  @version May 29, 2018
     *  @author  Period: 4
     *  @author  Assignment: ApcsFinalProject
     *
     *  @author  Sources: 
     */
    class PlayerMovementKeyListener implements KeyListener
    {
        /**
         * Tracks whether the key is pressed down already to
         * prevent unintentional multiple presses.
         */
        private boolean pressed;


        /**
         * Checks whether a key was pressed down. If it
         * is the movement keys (WASD), it updates the 
         * drawing and the position of the player.
         */
        public void keyPressed( KeyEvent k )
        {
            if ( !pressed && canMove )
            {
                int keyCode = k.getKeyChar();
                if ( keyCode == 97 )
                {
                    // A
                    scene.movePlayer( Move.LEFT );
                    checkMonster();
                    checkWon();
                }
                else if ( keyCode == 119 )
                {
                    // W
                    scene.movePlayer( Move.UP );
                    checkMonster();
                    checkWon();
                }
                else if ( keyCode == 100 )
                {
                    // D
                    scene.movePlayer( Move.RIGHT );
                    checkMonster();
                    checkWon();
                }
                else if ( keyCode == 115 )
                {
                    // S
                    scene.movePlayer( Move.DOWN );
                    checkMonster();
                    checkWon();
                }
                
                pressed = true;
            }

        }


        /**
         * Checks to see if the key was released, so
         * there aren't multiple presses registered
         * if the key is held down.
         */
        public void keyReleased( KeyEvent k )
        {
            pressed = false;
        }


        /**
         * Required method in the class. Not implemented.
         */
        public void keyTyped( KeyEvent k )
        {

        }
    }

    /**
     * Called each time the players moves to check if there
     * is a monster. If so, it creates a Battle and opens
     * a new window for the Battle interactive interface.
     */
    private void checkMonster() {
        if(scene.checkMonster()) {
            System.out.println("monster");
            Battle b = new Battle(scene.getPlayer());
            BattleFrame battle = new BattleFrame(b);
            battle.addWindowListener( new WindowListener() 
            {

                @Override
                public void windowActivated( WindowEvent arg0 ) {}

                /**
                 * Makes the Adventure JFrame interactive after the Battle JFrame is closed
                 */
                @Override
                public void windowClosed( WindowEvent arg0 )
                {
                    canMove = true;
                    scene.repaint();
                    if (scene.checkPlayerDeath()) 
                    {
                        System.out.println("RESET");
                        resetScene();
                    }
                    
                }

                @Override
                public void windowClosing( WindowEvent arg0 ) {}

                @Override
                public void windowDeactivated( WindowEvent arg0 ){}

                @Override
                public void windowDeiconified( WindowEvent arg0 ){}

                @Override
                public void windowIconified( WindowEvent arg0 ){}

                @Override
                public void windowOpened( WindowEvent arg0 ){}

            } );
            battle.setVisible( true );
            canMove = false;
        }
        else {
            System.out.println( "no monster" );
        }
    }
    
    /**
     * Checks if the game is over. If so, it resets what's displayed.
     */
    private void checkWon()
    {
        if (scene.checkExit()) 
        {
            resetScene();
        }
    }
    
    /**
     * Removes the key listener from the scene so the 
     * user can't interact with it anymore
     */
    private void resetScene() 
    {
        scene.removeKeyListener( keyListener );
    }

    /**
     * Sets parameters of the JFrame and adds the Adventure game to it
     * Sets up the KeyListener and allows the user to begin interacting
     * with the window.
     */
    public AdventureFrame()
    {
        scene = new AdventureComponent();
        add( scene );
        setSize( FRAME_WIDTH, FRAME_HEIGHT );
        setBackground(Color.WHITE);
        
        canMove = true;
        
        keyListener = new PlayerMovementKeyListener();
        scene.addKeyListener( keyListener );
        
        scene.setFocusable( true );
        
    }
}
