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

        assertNotNull( player );
        Player player2 = new Player( 10, 10, w );
        assertNotNull( player2 );
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
    public void checkPlayerRow()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        assertEquals( player.getPlayerRow(), 10 );
    }


    @Test
    public void checkPlayerCol()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        assertEquals( player.getPlayerCol(), 10 );
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
    public void checkBaseDamage()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        int d = player.getBaseDamage();
        assertEquals( player.increaseDamage( 10 ), d + 10 );
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
    public void checkLower()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        player.lowerHealth( 10 );
        assertEquals( player.getHealth(), 90 );
    }


    @Test
    public void checkIncrease()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        player.lowerHealth( 50 );
        player.increaseHealth( 10 );
        assertEquals( player.getHealth(), 60 );
    }


    @Test
    public void checkIncreaseMax()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        player.increaseMaxHealth( 10 );
        assertEquals( player.getMaxHealth(), 110 );
    }


    @Test
    public void increaseDmgTest()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        player.increaseDamage( 10 );
        assertEquals( player.getBaseDamage(), 20 );
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

    // IDK HOW TO DO THIS ONE
    //
    // TODO
    //
    //
    // @Test
    // public void testPaintComponent()
    // {
    // Graphics2D g;
    // AdventureComponent.paintComponent( g );
    // }


    // Battle Tests
    @Test
    public void battleConstructor()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        Battle b2 = new Battle( player );
        assertNotNull( b );
        assertNotNull( b2 );
    }


    @Test
    public void startBattleTest()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        b.startBattle();
        assertFalse( b.checkEnded() );
    }


    @Test
    public void checkEndedTest()
    {
        Player player = new Player( 10, 10, w, 10, 1, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        b.startBattle();
        b.monsterAttack();
        assertTrue( b.checkEnded() );
    }


    /**
     * NEED TO FINISH TODO
     * 
     * 
     */
    @Test
    public void endBattleTest()
    {
        Player player = new Player( 10, 10, w, 10, 10, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        b.startBattle();
        b.monsterAttack();
        b.endBattle( false );

    }


    @Test
    public void monsterAttackTest()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        b.monsterAttack();
        assertTrue( ( player.getHealth() > ( 100 - 15 ) ) || ( player.getHealth() < ( 100 - 5 ) ) );
    }


    @Test
    public void playerAttackTest()
    {
        Player player = new Player( 10, 10, w, 10, 100, 10 );
        Monster monster = new gPeck();
        Battle b = new Battle( player, monster );
        b.playerAttack();
        assertTrue(
            ( monster.getHealth() > ( 300 - 15 ) ) || ( monster.getHealth() < ( 300 - 5 ) ) );
    }

    // actionperformed test ????
    // TODO


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

    @Test
    public void monsterConstructor()
    {
        Monster mon = new Monster( 10, 100 );
        Monster mon2 = new Monster();
        assertNotNull( mon );
        assertNotNull( mon2 );
    }


    @Test
    public void getMonsterDamage()
    {
        Monster mon = new Monster( 10, 100 );
        int d = mon.getDamage();
        assertTrue( ( d > ( 100 - 15 ) ) || ( d < ( 100 - 5 ) ) );
    }


    @Test
    public void getMonsterHealth()
    {
        Monster mon = new Monster( 10, 100 );
        assertEquals( 100, mon.getHealth() );
    }


    @Test
    public void monsterLowerHealth()
    {
        Monster mon = new Monster();
        mon.lowerHealth( 10 );
        assertEquals( mon.getHealth(), 40 );
    }


    @Test
    public void getMonsMaxHealth()
    {
        Monster mon = new Monster();
        mon.lowerHealth( 10 );
        assertEquals( mon.getMaxHealth(), mon.getHealth() + 10 );
    }


    @Test
    public void getMonsName()
    {
        Monster mon = new Monster();
        assertEquals( "Monster", mon.getName() );
    }


    // gPeck
    @Test
    public void gPeckConstructor()
    {
        Monster g = new gPeck();
        assertNotNull( g );
    }


    @Test
    public void gPeckName()
    {
        Monster g = new gPeck();
        assertEquals( "G Peck", g.getName() );
    }


    @Test
    public void papaPeckConstructor()
    {
        Monster p = new papaPeck();
        assertNotNull( p );
    }


    @Test
    public void papaPeckName()
    {
        Monster g = new papaPeck();
        assertEquals( "Papa Peck", g.getName() );
    }


    @Test
    public void lilPeckConstructor()
    {
        Monster lil = new lilPeck();
        assertNotNull( lil );

    }


    @Test
    public void lilPeckName()
    {
        Monster g = new lilPeck();
        assertEquals( "lil' Peck", g.getName() );
    }


    @Test
    public void ShannonsterConstructor()
    {
        Monster sh = new Shannonster();
        assertNotNull( sh );
    }

}
