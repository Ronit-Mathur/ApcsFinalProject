import java.util.*;


public class WorldMap
{
    private char[][] map;
    public WorldMap(int width, int height) {
        map = new char[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[j][i] = '+';
            }
        }
    }
    public char[][] getMap() {
        return map;
    }
}
