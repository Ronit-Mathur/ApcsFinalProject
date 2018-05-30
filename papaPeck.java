/**
 * 
 *  A type of monster called "Papa Peck" with a health and damage.
 *
 *  @author  
 *  @version May 29, 2018
 *  @author  Period: 4
 *  @author  Assignment: ApcsFinalProject
 *
 *  @author  Sources: 
 */
public class papaPeck extends Monster
{
    /**
     * papaPeck is a type of Monster 
     * Attack Damage : 5 
     * Max health : 250
     */
    public papaPeck()
    {
        super( 5, 250 );
    }

    /**
     * @return Papa Peck's name
     */
    public String getName()
    {
        return "Papa Peck";
    }
}
