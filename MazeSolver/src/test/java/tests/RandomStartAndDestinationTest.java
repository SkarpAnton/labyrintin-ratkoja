package tests;

import maze.datastructures.RandomStartAndDestination;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomStartAndDestinationTest {
    
    @Test
    public void startAndDestinationDifferent() {
        int mazeWidth = 100;
        for (int i = 0; i < 10000; i++) {
            RandomStartAndDestination startAndDestination = 
                    new RandomStartAndDestination(mazeWidth * mazeWidth, mazeWidth);
            assertTrue(startAndDestination.getStart() != startAndDestination.getDestination());
        }
    }
    @Test
    public void startAndDestinationDistanceBiggerThanMazeWidth() {
         int mazeWidth = 100;
        for (int i = 0; i < 10000; i++) {
            RandomStartAndDestination startAndDestination = 
                    new RandomStartAndDestination(mazeWidth * mazeWidth, mazeWidth);
            int xDiff = Math.abs(startAndDestination.getStart() % mazeWidth -
                    startAndDestination.getDestination() % mazeWidth);
            int yDiff = Math.abs(startAndDestination.getStart() / mazeWidth -
                    startAndDestination.getDestination() / mazeWidth);
            assertTrue(xDiff + yDiff >= mazeWidth);
        }
    }
        
    
}
