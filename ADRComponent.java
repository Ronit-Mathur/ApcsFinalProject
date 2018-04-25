import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Font;

public class ADRComponent extends JComponent
{
//    private Rectangle r;
    private char[][] map;
    public ADRComponent() {
//        r = new Rectangle (5, 5, 490, 490);
        WorldMap wm = new WorldMap(20, 30);
        map = wm.getMap();
    }
    public void paintComponent(Graphics g) {
        Font f = new Font("Courier", Font.BOLD, 18);
        Graphics2D g2 = (Graphics2D) g;
//        g2.setColor( Color.BLACK );
//        g2.draw(r);
//        g2.fill( r );
        g2.setColor( Color.GRAY );
        int x = 50;
        int y = 50;
        for (int i = 0; i < map.length; i++)  {
            for (int j = 0; j < map[i].length; j++) {
                g2.setFont( f );
                g2.drawString( map[i][j] + "", x + 12 * i, y + 12 * j );
            }
        }
    }
}
