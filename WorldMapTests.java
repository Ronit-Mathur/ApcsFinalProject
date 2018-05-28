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
        // TODO regular showAround
        // TODO showAroundRandom
    }


    public void getMapTest()
    {
        WorldMap m = new WorldMap( 10, 10 );
        assertNotNull( m.getMap() );
    }

}
