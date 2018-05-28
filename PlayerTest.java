import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest
{
    WorldMap w = new WorldMap( 31, 31 );

    Player player = new Player( 10, 10, w, 10, 100, 10 );


    // Player Class Tests
    @Test
    public void playerInitialization()
    {
        assertEquals( player.getHealth(), 100 );

        assertNotNull( player );
        Player player2 = new Player( 10, 10, w );
        assertNotNull( player2 );
    }


    @Test
    public void checkIfMoveUp()
    {
        int rTest = player.getPlayerRow();
        player.moveUp();
        assertEquals( rTest, player.getPlayerRow() + 1 );
    }


    @Test
    public void checkIfMoveDown()
    {
        int rTest = player.getPlayerRow();
        player.moveDown();
        assertEquals( rTest, player.getPlayerRow() - 1 );
    }


    @Test
    public void checkIfMoveLeft()
    {
        int rTest = player.getPlayerRow();
        player.moveLeft();
        assertEquals( rTest, player.getPlayerCol() + 1 );
    }


    @Test
    public void checkIfMoveRight()
    {
        int rTest = player.getPlayerRow();
        player.moveRight();
        assertEquals( rTest, player.getPlayerCol() - 1 );
    }


    @Test
    public void checkJump()
    {
        // diagonal jump
        int rTest = player.getPlayerRow();
        int cTest = player.getPlayerCol();
        player.jump( 11, 11 );
        assertEquals( rTest, player.getPlayerCol() - 1 );
        assertEquals( cTest, player.getPlayerCol() - 1 );
        // when do we ever use jump tho
    }


    @Test
    public void checkPlayerRow()
    {
        assertEquals( player.getPlayerRow(), 10 );
    }


    @Test
    public void checkPlayerCol()
    {
        assertEquals( player.getPlayerCol(), 10 );
    }


    @Test
    public void checkHealth()
    {
        player.lowerHealth( 10 );
        int h = player.getHealth();
        assertEquals( h, 90 );
    }


    @Test
    public void checkDamage()
    {
        int d = player.getDamage();
        assertTrue( d >= 5 && d <= 15 );

    }


    @Test
    public void checkBaseDamage()
    {
        int d = player.getBaseDamage();
        assertEquals( player.increaseDamage( 10 ), d + 10 );
    }


    @Test
    public void checkMaxHealth()
    {
        player.lowerHealth( 10 );
        int h = player.getHealth();
        int m = player.getMaxHealth();
        assertEquals( h + 10, m );

    }


    @Test
    public void checkLower()
    {
        player.lowerHealth( 10 );
        assertEquals( player.getHealth(), 90 );
    }


    @Test
    public void checkIncrease()
    {
        player.lowerHealth( 50 );
        player.increaseHealth( 10 );
        assertEquals( player.getHealth(), 60 );
    }


    @Test
    public void checkIncreaseMax()
    {
      
        player.increaseMaxHealth( 10 );
        assertEquals( player.getMaxHealth(), 110 );
    }


    @Test
    public void checkIncToMax()
    {
        int mh = player.getMaxHealth();
        player.lowerHealth( 10 );
        assertEquals( mh, player.increaseHealthToMax() );

    }


    @Test
    public void increaseDmgTest()
    {
        player.increaseDamage( 10 );
        assertEquals( player.getBaseDamage(), 20 );
    }


    @Test
    public void getBlockTest()
    {
        assertEquals( player.getBlock(), 10 );

    }


    @Test
    public void increaseBlockTest()
    {
        int b = player.getBlock();
        int inc = player.increaseBlock( 10 );
        assertEquals( inc, b + 10 );
    }


    @Test
    public void checkIfDead()
    {
        player.lowerHealth( 100 );
        assertTrue( player.checkDeath() );
    }


    @Test
    public void checkSteps()
    {
        player.moveDown();
        assertEquals( player.getSteps(), 1 );
    }


    @Test
    public void getWorld()
    {
        WorldMap g = player.getWorld();
        assertEquals( w, g );
    }

}
