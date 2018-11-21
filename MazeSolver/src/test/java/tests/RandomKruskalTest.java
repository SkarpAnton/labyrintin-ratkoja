/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import maze.datastructures.Square;
import maze.algorithms.RandomKruskal;
import maze.datastructures.TypesOfSquares;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class RandomKruskalTest {
    private final Square[] maze;
    private final int mazeWidth = 1000;
    private final int amountOfSquares = mazeWidth * mazeWidth;
    private final int border = TypesOfSquares.getBORDER();
    private final int hallway = TypesOfSquares.getHALLWAY();
    public RandomKruskalTest() {
        maze = RandomKruskal.createMaze(mazeWidth);
    }
    
    @Test
    public void borderTest() {
        for (int i = 0; i < mazeWidth; i++) {
            
            assertEquals(border, maze[i].getUpper());
            assertEquals(border, maze[amountOfSquares - i - 1].getLower());
            assertEquals(border, maze[i * mazeWidth].getLeft());
            assertEquals(border, maze[amountOfSquares - i * mazeWidth - 1].getRight());
            
        }
    }
    
    @Test
    public void everySquareHasHallway() {
        for(int i = 0; i < amountOfSquares; i++) {
            assertTrue(maze[i].getLeft() == hallway || maze[i].getUpper() == hallway ||
                    maze[i].getLower() == hallway || maze[i].getRight() == hallway);
        }
    }
    
}
