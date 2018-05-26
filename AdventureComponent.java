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
 * Draws the Adventure game and controls some of it
 *
 * @author
 * @version Apr 27, 2018
 * @author Period: 4
 * @author Assignment: Adventure
 *
 * @author Sources: TODO
 */
public class AdventureComponent extends JComponent 
{
	private WorldMapSquare[][] map;
	private WorldMap world;
	private Player player;
	private boolean endScreen;

	/**
	 * Creates the aspects of the game
	 */
	public AdventureComponent() 
	{
		world = new WorldMap(31, 31);
		map = world.getMap();
		player = new Player(world.getMapRows() / 2 + 1, world.getMapCols() / 2 + 1, world);
		endScreen = false;
	}

	/**
	 * Paints the game
	 * 
	 * @param g
	 *            graphics interface to draw the shapes
	 */
	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		drawSidebar(g2);
		if (checkPlayerDeath())
		{
		    drawGameOver(g2);
		    endScreen = true;
		}
		else if (checkExit())
		{
		    drawGameWon(g2);
		}
		// TODO: add when player reaches exit to draw win screen
		else 
		{
		    drawWorld(g2);
		}
		
	}

	private void drawWorld(Graphics2D g2) 
	{
	    map = world.getMap();
		Font mapFont = new Font("Courier", Font.BOLD, 12);
		g2.setColor( Color.BLACK );
		g2.setFont(mapFont);
		int x = 50;
		int y = 50;
		for (int r = 0; r < map.length; r++) 
		{
			for (int c = 0; c < map[r].length; c++) 
			{
				if (r == player.getPlayerRow() && c == player.getPlayerCol()) 
				{
					// draw player
					g2.drawString(Square.PLAYER.character() + "", y + 12 * c, x + 12 * r);
				} 
				else 
				{
				    if (world.getSquare( r, c ).visited())
				    {
				        g2.setColor( Color.GRAY );
				    }
				    
				    if (world.getSquare( r, c ).getSquare() == Square.E)
				    {
				        g2.setColor( Color.GREEN );
				    }
				    if (world.getSquare( r, c ).getSquare() == Square.M)
                    {
                        g2.setColor( Color.RED );
                    }
					g2.drawString(map[r][c].getCharacter() + "", y + 12 * c, x + 12 * r);
					g2.setColor( Color.BLACK );
				}
			}
		}
	}

	private void drawSidebar(Graphics2D g2) 
	{
	    g2.setColor(Color.BLACK);
	    Font f1 = new Font("Courier", Font.BOLD, 18);
	    g2.setFont( f1 );
	    g2.drawString("Adventure", 475, 85);
		Font sideFont = new Font("Courier", Font.PLAIN, 14);
		

		// Right sidebar menu
		g2.setFont(sideFont);
		Rectangle sidebar = new Rectangle(450, 45, 300, 375);
		g2.draw(sidebar);
		
		g2.drawString("Row: " + player.getPlayerRow(), 475, 105);
		g2.drawString("Col: " + player.getPlayerCol(), 475, 120);
		drawPlayerStats(g2, 475, 150);
	}
	
	private void drawPlayerStats(Graphics2D g2, int x, int y)
	{
	    Font f = new Font("Courier", Font.PLAIN, 12);
	    g2.setColor( Color.BLACK );
	    g2.setFont( f );
	    g2.drawString( "PLAYER", x, y );
        g2.drawString( player.getHealth() + "/" + player.getMaxHealth(), x + 200, y );
        Rectangle h = new Rectangle(x, y + 5, (int)(250 * (player.getHealth() * 1.0 / player.getMaxHealth() )), 25);
        g2.setColor( Color.GREEN );
        g2.fill( h );
        Rectangle border = new Rectangle(x, y + 5, 250, 25);
        g2.setColor( Color.BLACK );
        g2.draw( border );
        
        g2.drawString( "DAMAGE: " + player.getBaseDamage(), x, y + 55 );
        g2.drawString( "BLOCK: " + player.getBlock(), x, y + 70 );
        
        g2.drawString( "NEXT: " + Battle.q.peek().getName(), x, y + 85 );
	}
	
	private void drawGameOver(Graphics2D g2) 
	{
	    Font f = new Font("Courier", Font.BOLD, 18);
	    g2.setFont( f );
	    Rectangle r = new Rectangle(50, 50, 340, 350);
	    g2.setColor( Color.RED);
	    g2.fill(r);
	    g2.setColor( Color.WHITE );
	    
	    g2.drawString( "GAME OVER", 170, 200 );
	}
	
	private void drawGameWon(Graphics2D g2) 
    {
        Font f = new Font("Courier", Font.BOLD, 18);
        g2.setFont( f );
        Rectangle r = new Rectangle(50, 50, 340, 350);
        g2.setColor( Color.GREEN);
        g2.fill(r);
        g2.setColor( Color.WHITE );
        
        g2.drawString( "YOU WON", 175, 200 );
        g2.drawString( "STEPS: " + player.getSteps(), 170, 220 );
    }

	public void movePlayer(Move m) {
	    world.setSquareToRoad( player.getPlayerRow(), player.getPlayerCol() );
		if (m == Move.UP) {
			player.moveUp();
		} else if (m == Move.DOWN) {
			player.moveDown();
		} else if (m == Move.LEFT) {
			player.moveLeft();
		} else if (m == Move.RIGHT) {
			player.moveRight();
		}
		repaint();
	}

	public boolean checkMonster() {
		return world.checkMonster(player.getPlayerRow(), player.getPlayerCol());
	}

	public boolean checkPlayerDeath() 
	{
	    //System.out.println( "CHECK DEATH IS " + player.checkDeath() );
	    if (!endScreen && player.checkDeath() == true ) {
	        repaint();
	    }
	    return player.checkDeath();
	}
	
	public boolean checkExit()
	{
	    return world.getSquare( player.getPlayerRow(), player.getPlayerCol() ).isExit();
	}
	public Player getPlayer() {
		return player;
	}
}
