
import javax.swing.JComponent;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class BattleComponent extends JComponent
{
	private Battle battle;
	private BattleControls battleControls;
	private Player player;
	private Monster monster;

	public BattleComponent(BattleControls b) 
	{
		
		battleControls = b;
		battle = battleControls.getBattle();
		player = battleControls.getPlayer();
		monster = battleControls.getMonster();
	}


	public void paintComponent(Graphics g) 
	{
		
		Graphics2D g2 = (Graphics2D) g;
		drawPlayerHealth(g2, 50, 50);
		drawMonsterHealth(g2, 50, 100);
	}
	
	public void drawPlayerHealth(Graphics2D g2, int x, int y) 
	{
	    g2.drawString( "PLAYER", x, y );
	    Rectangle h = new Rectangle(x, y + 5, (int)(300 * (player.getHealth() * 1.0 / player.getMaxHealth() )), 25);
	    g2.setColor( Color.GREEN );
	    g2.fill( h );
	    Rectangle border = new Rectangle(x, y + 5, 300, 25);
	    g2.setColor( Color.BLACK );
	    g2.draw( border );
	    repaint();
	}
	public void drawMonsterHealth(Graphics2D g2, int x, int y) 
    {
	    g2.drawString( "MONSTER", x, y );
	    Rectangle h = new Rectangle(x, y + 5, (int)(300 * (monster.getHealth() * 1.0 / monster.getMaxHealth())), 25);
        g2.setColor( Color.RED );
        g2.fill( h );
        Rectangle border = new Rectangle(x, y + 5, 300, 25);
        g2.setColor( Color.BLACK );
        g2.draw( border );
        repaint();
    }
}
