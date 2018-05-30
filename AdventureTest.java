import static org.junit.Assert.*;

import java.awt.Graphics2D;

import org.junit.Test;


public class AdventureTest
{

    WorldMap w = new WorldMap( 31, 31 );
    // AdventureComponent Tests
    
    Player player = new Player( 10, 10, w, 10, 100, 10 );

    Monster monster = new gPeck();
    
    Monster mon = new Monster( 10, 100 );


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


    // BATTLE TESTS

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
    
    @Test
    public void checkEndBattle()
    {
    	Battle b = new Battle( player, monster );
    	int initialHealth;
    	initialHealth = player.getMaxHealth();
    	b.endBattle( true );
    	assertEquals( 5, player.getMaxHealth() - initialHealth );
    }
    // Monster and Monster subclasses Tests


    // TODO
    // Square.java


    // WorldMap.java Tests
    
    
    //BATTLE TESTS
    
    @Test
    public void battleConstructor()
    {
        Battle b = new Battle( player, monster );
        Battle b2 = new Battle( player );
        assertNotNull( b );
        assertNotNull( b2 );
    }


    @Test
    public void startBattleTest()
    {
        Battle b = new Battle( player, monster );
        b.startBattle();
        assertFalse( b.checkEnded() );
    }


    // TODO
    // @Test
    // public void checkEndedTest()
    // {
    // Battle b = new Battle( player, monster );
    // b.startBattle();
    // b.monsterAttack();
    // assertTrue( b.checkEnded() );
    // }

    @Test
    public void endBattleTest()
    {
        Battle b = new Battle( player, monster );
        b.startBattle();
        b.monsterAttack();
        b.endBattle( false );
    }


    @Test
    public void monsterAttackTest()
    {
        Battle b = new Battle( player, monster );
        b.monsterAttack();
        assertTrue( ( player.getHealth() > ( 100 - 15 ) ) || ( player.getHealth() < ( 100 - 5 ) ) );
    }

    @Test
    public void monsterAttackTestZeroHealth()
    {
    	Battle b = new Battle( player, monster );
    	player.lowerHealth( 100 );
    	b.monsterAttack();
        assertEquals( 0, player.getHealth() );
    }

    @Test
    public void playerAttackTest()
    {
        Battle b = new Battle( player, monster );
        b.playerAttack();
        assertTrue(
            ( monster.getHealth() > ( 300 - 15 ) ) || ( monster.getHealth() < ( 300 - 5 ) ) );
    }
    
    @Test
    public void playerAttackTestZeroHealth()
    {
    	Battle b = new Battle( player, monster );
    	monster.lowerHealth( 1000 );
    	b.playerAttack();
        assertEquals( 0, monster.getHealth() );
    }

    // actionperformed test ????
    // TODO
    
    
    //MONSTER TESTS
    
    @Test
    public void monsterConstructor()
    {

        Monster mon2 = new Monster();
        assertNotNull( mon );
        assertNotNull( mon2 );
    }


    @Test
    public void getMonsterDamage()
    {
        int d = mon.getDamage();
        assertTrue( ( d > ( 100 - 15 ) ) || ( d < ( 100 - 5 ) ) );
    }


    @Test
    public void getMonsterHealth()
    {
        assertEquals( 100, mon.getHealth() );
    }


    @Test
    public void monsterLowerHealth()
    {
        // monster starting health 100
        mon.lowerHealth( 10 );
        assertEquals( 90, mon.getHealth() );
    }

    @Test
    public void monsterLowerHealthLessThanZero()
    {
    	mon.lowerHealth(100);
    	mon.lowerHealth(10);
    	assertEquals( 0, mon.getHealth());
    }

    @Test
    public void getMonsMaxHealth()
    {
        mon.lowerHealth( 10 );
        assertEquals( mon.getHealth() + 10, mon.getMaxHealth() );
    }


    @Test
    public void getMonsName()
    {
        assertEquals( "Monster", mon.getName() );
    }


    // gPeck
    /**
     * Tests constructor and getName() for gPeck
     */
    @Test
    public void gPeckTests()
    {
        Monster g = new gPeck();
        assertNotNull( g );
        assertEquals( "G Peck", g.getName() );
    }


    /**
     * Tests constructor and getName() for papaPeck
     */
    @Test
    public void papaPeckTests()
    {
        Monster p = new papaPeck();
        assertEquals( "Papa Peck", p.getName() );
        assertNotNull( p );
    }


    /**
     * tests constructor and getName() for lilPeck
     */
    @Test
    public void lilTests()
    {
        Monster lil = new lilPeck();
        assertNotNull( lil );
        assertEquals( "lil' Peck", lil.getName() );

    }


    /**
     * tests constructor and getName() for Shannonster
     */
    @Test
    public void ShannonsterConstructor()
    {
        Monster sh = new Shannonster();
        assertNotNull( sh );
        assertEquals( "Shannonster", sh.getName() );
    }
    
    
    //PLAYER TESTS
    
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

//    @Test TODO MOVES RETURN FALSE
//    public void checkIfNotMoveUp()
//    {
//    	Player playerNot = new Player( 0, 0, w );
//        assertFalse( player.moveUp() );
//    }

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
    public void checkIncreaseOver()
    {
        player.lowerHealth( 50 );
        player.increaseHealth( 60 );
        assertEquals( player.getHealth(), player.getMaxHealth() );
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
    public void increaseBlockOverTest()
    {
        int b = player.getBlock();
        player.increaseBlock( 1000 );
        b = player.getBlock();
        assertEquals( 100, b );
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
    
    
    //WORLD MAP TESTS
    
    @Test
    public void WorldMapTests()
    {
        WorldMap m = new WorldMap( 10, 10 );
        assertNotNull( m );
    }


    @Test
    public void showAroundTests()
    {
        WorldMap m = new WorldMap( 10, 10 );
        Player p = new Player(0, 0, m);
        m.showAround( p );
        assertNotEquals(m.getMap()[1][1].getSquare(), Square.SPACE);
		
		m.showAroundRandom();
    }
	
	@Test
    public void showAroundRandomTests()
    {
        WorldMap m = new WorldMap( 10, 10 );
		m.showAroundRandom();
		WorldMapSquare[][] w = m.getMap();
		boolean check = false;
		for (int i = 0; i < w.length; i++)
		{
			for (int j = 0; j < w[i].length; j++)
			{
			if (w[i][j].getSquare() != Square.SPACE)
			{
				check = true;
			}
			}
		
		}
		assertTrue(check);
    }

	@Test
    public void getMapRowsTest()
    {
        WorldMap m = new WorldMap( 12, 10 );
		assertEquals(m.getMapRows(), 12);
    }
	
	@Test
    public void getMapColsTest()
    {
        WorldMap m = new WorldMap( 12, 10 );
		assertEquals(m.getMapCols(), 10);
    }
	
	@Test
    public void getSquareTest()
    {
        WorldMap m = new WorldMap( 12, 10 );
		assertEquals(m.getSquare(0,0), Square.SPACE);
		assertNull(m.getSquare(-1, 0));
    }

	@Test
    public void checkMonsterMapTest()
    {
        WorldMap m = new WorldMap( 12, 10 );
		assertFalse(m.checkMonster(-1,0));
    }
	
	@Test
    public void setSquareToRoadTest()
    {
        WorldMap m = new WorldMap( 12, 10 );
		m.setSquareToRoad(0,0);
		assertEquals(m.getSquare(0,0), Square.HASHTAG);
		
    }
	
	@Test
    public void getMapTest()
    {
        WorldMap m = new WorldMap( 10, 10 );
        assertNotNull( m.getMap() );
    }
    
}
