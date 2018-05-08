import javax.swing.JComponent;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class BattleComponent extends JComponent
{
    public BattleComponent() {
        
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle r = new Rectangle(100, 50, 50, 50);
        g2.setColor( Color.RED );
        g2.fill(r);
        g2.draw(r);
    }
}
