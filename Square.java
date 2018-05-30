/**
 * 
 *  Constants for the different squares in the WorldMap
 *
 *  @author  Shannon
 *  @version May 29, 2018
 *  @author  Period: 4
 *  @author  Assignment: ApcsFinalProject
 *
 *  @author  Sources: 
 */
public enum Square {
    SPACE(' '),
    PERIOD('.'), 
    COMMA(','),
    SEMICOLON(';'), 
    A('A'), 
    HASHTAG('#'), 
    P('P'), 
    H('H'),
    D('D'),
    B('B'),
    M('M'),
    E('E'),
    PLAYER('@');
    /**
     * The character each constant represents
     */
    private final char character;
    
    /**
     * Creates a constant based on a certain char
     * @param c the character the enum holds
     */
    Square(char c) {
        character = c;
    }
    /**
     * Returns the character the enum holds
     * @return the character the enum value represents
     */
    char character() {
        return character;
    }
}
