import static org.junit.Assert.*;

import java.awt.Graphics2D;

import org.junit.Test;


public class AdventureTest
{

    WorldMap w = new WorldMap( 31, 31 );
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


    @Test
    public void checkExitTest()
    {
        AdventureComponent scene = new AdventureComponent();
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        assertEquals( w.getSquare( player.getPlayerRow(), player.getPlayerCol() ).isExit(),
            scene.checkExit() );

    }


    // Battle Tests

    @Test
    public void getBattlesPlayerTest()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        assertNotNull( b.getPlayer() );
    }


    @Test
    public void getBattlesMonsterTest()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        assertNotNull( b.getMonster() );
    }

    // Monster and Monster subclasses Tests

    // TODO
    // Move.java ?

    // TODO
    // Square.java


    // WorldMap.java Tests

    // TODO AdventureFrame
    // TODO AdventureComponent ?
}
