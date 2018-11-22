package tests;

import maze.datastructures.RandomStartAndDestination;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomStartAndDestinationTest {
    
    @Test
    public void startAndDestinationDifferent() {
        for (int i = 0; i < 10000; i++) {
            RandomStartAndDestination startAndDestination = new RandomStartAndDestination(10000, 100);
            assertTrue(startAndDestination.getStart() != startAndDestination.getDestination());
        }

    }
    
    
}
