package tests;

import maze.datastructures.Square;
import maze.algorithms.RandomKruskal;
import maze.datastructures.TypesOfSides;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomKruskalTest {
    private final Square[] maze;
    private final int mazeWidth = 1000;
    private final int amountOfSquares = mazeWidth * mazeWidth;
    private final int border = TypesOfSides.getBORDER();
    private final int hallway = TypesOfSides.getHALLWAY();
    
    public RandomKruskalTest() {
        maze = RandomKruskal.createMaze(mazeWidth);
    }
    
    @Test
    public void borderTest() {
        for (int i = 0; i < mazeWidth; i++) {
            
            assertEquals(border, maze[i].getUpperSide());
            assertEquals(border, maze[amountOfSquares - i - 1].getLowerSide());
            assertEquals(border, maze[i * mazeWidth].getLeftSide());
            assertEquals(border, maze[amountOfSquares - i * mazeWidth - 1].getRightSide());
            
        }
    }
    
    @Test
    public void everySquareHasHallway() {
        for(int i = 0; i < amountOfSquares; i++) {
            assertTrue(maze[i].getLeftSide() == hallway || maze[i].getUpperSide() == hallway ||
                    maze[i].getLowerSide() == hallway || maze[i].getRightSide() == hallway);
        }
    }
    
}
