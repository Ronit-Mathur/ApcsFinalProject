import static org.junit.Assert.*;

import org.junit.Test;

public class AdventureTest {

	WorldMap w = new WorldMap(31, 31);
	@Test
	public void playerInitialization() 
	{
		Player player = new Player(10, 10, w, 10, 100, 10);
		assertEquals(player.getHealth(), 100);
	}
	
	@Test
	public void checkIfMoveUp()
	{
		Player player = new Player(10, 10, w, 10, 100, 10);
		int rTest = player.getPlayerRow();
		player.moveUp();
		assertEquals( rTest, player.getPlayerRow() + 1);
	}

	@Test
	public void checkIfMoveDown()
	{
		Player player = new Player(10, 10, w, 10, 100, 10);
		int rTest = player.getPlayerRow();
		player.moveDown();
		assertEquals( rTest, player.getPlayerRow() - 1);
	}
	
	@Test
	public void checkIfMoveLeft()
	{
		Player player = new Player(10, 10, w, 10, 100, 10);
		int rTest = player.getPlayerRow();
		player.moveLeft();
		assertEquals( rTest, player.getPlayerCol() + 1);
	}
	
	@Test
	public void checkIfMoveRight()
	{
		Player player = new Player(10, 10, w, 10, 100, 10);
		int rTest = player.getPlayerRow();
		player.moveRight();
		assertEquals( rTest, player.getPlayerCol() - 1);
	}
	
	public void checkJump()
	{
		Player player = new Player(10, 10, 2, 10, 100, 10);
		
	}
}
	