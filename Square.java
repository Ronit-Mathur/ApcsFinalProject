
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
    E('E'),
    PLAYER('@');
    private final char character;
    Square(char c) {
        character = c;
    }
    char character() {
        return character;
    }
}
