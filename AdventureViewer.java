import javax.swing.JFrame;


/**
 * 
 * Opens a window with the Adventure game
 *
 * @author Shannon, Ronit, Jessabelle
 * @version Apr 27, 2018
 * @author Period: 4
 * @author Assignment: Adventure
 *
 * @author Sources: TODO
 */
public class AdventureViewer
{

    /**
     * Main method to start the game. Opens the JFrame.
     * @param args default main argument
     */
    public static void main( String[] args )
    {
        JFrame frame = new AdventureFrame();
        frame.setTitle( "ADR" );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
}
