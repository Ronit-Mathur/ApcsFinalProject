import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
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
        
        
        // Draw map
        g2.setFont( mapFont );
        
        int x = 50;
        int y = 50;
        for (int r = 0; r < map.length; r++)  {
            for (int c = 0; c < map[r].length; c++) {
                if (r == player.getPlayerRow() && c == player.getPlayerCol()) {
                    // draw player
                    g2.drawString( Square.PLAYER.character() + "", y + 12 * c, x + 12 * r );
                }
                else {
                    g2.drawString( map[r][c].getCharacter() + "", y + 12 * c, x + 12 * r );
                }
            }
        }
    }
    
    public void movePlayer(Move m) {
        if (m == Move.UP) {
            player.moveUp();
        }
        else if (m == Move.DOWN) {
            player.moveDown();
        }
        else if (m == Move.LEFT) {
            player.moveLeft();
        }
        else if (m == Move.RIGHT) {
            player.moveRight();
        }
        repaint();
    }
}
