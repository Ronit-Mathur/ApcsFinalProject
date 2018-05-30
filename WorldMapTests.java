import static org.junit.Assert.*;

import org.junit.Test;

public class WorldMapTests
{
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
        
        // TODO regular showAround
        // TODO showAroundRandom
    }


    public void getMapTest()
    {
        WorldMap m = new WorldMap( 10, 10 );
        assertNotNull( m.getMap() );
    }

}
