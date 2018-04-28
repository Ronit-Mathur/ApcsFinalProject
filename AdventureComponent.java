import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Font;
/**
 * 
 *  Draws the Adventure game and controls some of it
 *
 *  @author  
 *  @version Apr 27, 2018
 *  @author  Period: 4
 *  @author  Assignment: Adventure
 *
 *  @author  Sources: TODO
 */
public class AdventureComponent extends JComponent
{
//    private Rectangle r;
    private WorldMapSquare[][] map;
    private Player player;
    
    /**
     * Creates the aspects of the game
     */
    public AdventureComponent() {
//        r = new Rectangle (5, 5, 490, 490);
        WorldMap wm = new WorldMap(31, 31);
        map = wm.getMap();
        player = new Player(wm.getMapRows() / 2 + 1, wm.getMapCols() / 2 + 1, wm);
    }
    
    /**
     * Paints the game
     * @param g graphics interface to draw the shapes
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font mapFont = new Font("Courier", Font.BOLD, 12);
        Font sideFont = new Font("Courier", Font.BOLD, 18);
        g2.setColor( Color.GRAY );
        
        // Right sidebar menu
        g2.setFont( sideFont );
        Rectangle sidebar = new Rectangle(450, 45, 300, 375);
        g2.draw( sidebar );
        g2.drawString( "Adventure", 475, 85 );
        g2.drawString( "Row: " + player.getPlayerRow(), 475, 100 );
        g2.drawString( "Col: " + player.getPlayerCol(), 475, 115 );
        
        g2.setFont( mapFont );
        
        int x = 50;
        int y = 50;
        for (int i = 0; i < map.length; i++)  {
            for (int j = 0; j < map[i].length; j++) {
                g2.drawString( map[i][j].getCharacter() + "", x + 12 * i, y + 12 * j );
            }
        }
    }
}
