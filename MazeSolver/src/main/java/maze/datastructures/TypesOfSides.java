
package maze.datastructures;

public class TypesOfSides {
    private static final int HALLWAY = -2;
    private static final int BORDER = -1;
    private static final int WALL = 1;
    
    private TypesOfSides() {}

    public static int getHALLWAY() {
        return HALLWAY;
    }

    public static int getBORDER() {
        return BORDER;
    }

    public static int getWALL() {
        return WALL;
    }
    
}
