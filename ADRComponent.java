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
    public ADRComponent() {
//        r = new Rectangle (5, 5, 490, 490);
    }
    public void paintComponent(Graphics g) {
        Font f = new Font("Courier", Font.BOLD, 18);
        Graphics2D g2 = (Graphics2D) g;
//        g2.setColor( Color.BLACK );
//        g2.draw(r);
//        g2.fill( r );
        g2.setColor( Color.GRAY );
        WorldMap wm = new WorldMap(30, 30);
        int x = 50;
        int y = 50;
        char[][] m = wm.getMap();
        for (int i = 0; i < m.length; i++)  {
            for (int j = 0; j < m[i].length; j++) {
                g2.setFont( f );
                g2.drawString( m[i][j] + "", x + 12 * i, y + 12 * j );
            }
        }
    }
}
