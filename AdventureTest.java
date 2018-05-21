import static org.junit.Assert.*;

import java.awt.Graphics2D;

import org.junit.Test;


public class AdventureTest
{

    WorldMap w = new WorldMap( 31, 31 );


    // Player Class Tests
    @Test
    public void playerInitialization()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        assertEquals( player.getHealth(), 100 );
    }


    @Test
    public void checkIfMoveUp()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        int rTest = player.getPlayerRow();
        player.moveUp();
        assertEquals( rTest, player.getPlayerRow() + 1 );
    }


    @Test
    public void checkIfMoveDown()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        int rTest = player.getPlayerRow();
        player.moveDown();
        assertEquals( rTest, player.getPlayerRow() - 1 );
    }


    @Test
    public void checkIfMoveLeft()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        int rTest = player.getPlayerRow();
        player.moveLeft();
        assertEquals( rTest, player.getPlayerCol() + 1 );
    }


    @Test
    public void checkIfMoveRight()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        int rTest = player.getPlayerRow();
        player.moveRight();
        assertEquals( rTest, player.getPlayerCol() - 1 );
    }


    @Test
    public void checkJump()
    {
        // diagonal jump
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        int rTest = player.getPlayerRow();
        int cTest = player.getPlayerCol();
        player.jump( 11, 11 );
        assertEquals( rTest, player.getPlayerCol() - 1 );
        assertEquals( cTest, player.getPlayerCol() - 1 );
        // when do we ever use jump tho
    }


    @Test
    public void checkHealth()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        player.lowerHealth( 10 );
        int h = player.getHealth();
        assertEquals( h, 90 );
    }


    @Test
    public void checkDamage()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        int d = player.getDamage();
        assertTrue( d >= 5 && d <= 15 );

    }


    @Test
    public void checkMaxHealth()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        player.lowerHealth( 10 );
        int h = player.getHealth();
        int m = player.getMaxHealth();
        assertEquals( h + 10, m );

    }


    @Test
    public void checkIfDead()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        player.lowerHealth( 100 );
        assertTrue( player.checkDeath() );
    }

    // //Battle tests TODO Battle Tests
    //
    // public void createBattle()
    // {
    // Player player = new Player( 10, 10, w, 10, 100, 10 );
    // Monster monster = new Monster( )
    // Battle battle = new Battle( player, m)
    // }


    // AdventureComponent Tests

    @Test
    public void getPlayerTest()
    {
        // Player player = new Player( 10, 10, w, 10, 100, 10 );
        AdventureComponent scene = new AdventureComponent();
        assertNotNull( scene.getPlayer() );
    }


    @Test
    public void checkPlayerDeathTest()
    {
        AdventureComponent scene = new AdventureComponent();
        // Player player = new Player( 10, 10, w, 10, 100, 10 );
        scene.getPlayer().lowerHealth( 100 );
        assertTrue( scene.checkPlayerDeath() );
    }


    @Test
    public void checkMonsterTest()
    {
        AdventureComponent scene = new AdventureComponent();
        assertNotNull( scene.checkMonster() );
    }


    @Test
    public void adventureComponentConstructor()
    {
        AdventureComponent scene = new AdventureComponent();
        assertNotNull( scene );
    }


    @Test
    public void movePlayerTest()
    {
        AdventureComponent scene = new AdventureComponent();
        int row = scene.getPlayer().getPlayerRow();
        scene.movePlayer( Move.UP );
        assertEquals( scene.getPlayer().getPlayerRow(), row - 1 );
    }


    // //Battle tests TODO Battle Tests
    //
    // public void createBattle()
    // {
    // Player player = new Player( 10, 10, w, 10, 100, 10 );
    // Monster monster = new Monster( )
    // Battle battle = new Battle( player, m)
    // }
@Test    
    public void testPaintComponent()
    {
    	Graphics2D g;
    	AdventureComponent.paintComponent( g );
    }
}
