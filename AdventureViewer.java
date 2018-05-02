import javax.swing.JFrame;


/**
 * 
 * Opens a window with the Adventure game
 *
 * @author
 * @version Apr 27, 2018
 * @author Period: 4
 * @author Assignment: Adventure
 *
 * @author Sources: TODO
 */
public class AdventureViewer
{

    public static void main( String[] args )
    {
        JFrame frame = new AdventureFrame();
        frame.setTitle( "ADR" );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
}
