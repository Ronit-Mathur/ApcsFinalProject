import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Monster and Monster subclass tests
 * Subclasses tested:
 * gPeck, lilPeck, papaPeck, Shannonster
 *
 * @author
 * @version May 27, 2018
 * @author Period: TODO
 * @author Assignment: ApcsFinalProject
 *
 * @author Sources: TODO
 */
public class MonsterTests
{
    Monster mon = new Monster( 10, 100 );


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

}
