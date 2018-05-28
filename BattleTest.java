import static org.junit.Assert.*;

import org.junit.Test;


public class BattleTest
{
    WorldMap w = new WorldMap( 31, 31 );

    Player player = new Player( 10, 10, w, 10, 100, 10 );

    Monster monster = new gPeck();


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
//    @Test
//    public void checkEndedTest()
//    {
//        Battle b = new Battle( player, monster );
//        b.startBattle();
//        b.monsterAttack();
//        assertTrue( b.checkEnded() );
//    }


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
    public void playerAttackTest()
    {
        Battle b = new Battle( player, monster );
        b.playerAttack();
        assertTrue(
            ( monster.getHealth() > ( 300 - 15 ) ) || ( monster.getHealth() < ( 300 - 5 ) ) );
    }

    // actionperformed test ????
    // TODO

}
