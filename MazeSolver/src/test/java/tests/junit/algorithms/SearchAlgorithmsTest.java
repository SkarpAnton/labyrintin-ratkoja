package tests.junit.algorithms;

import maze.algorithms.SearchAlgorithms;
import maze.datastructures.Room;
import maze.algorithms.RandomKruskal;
import maze.datastructures.RandomStartAndDestination;
import maze.datastructures.TypesOfSides;
import org.junit.Test;
import static org.junit.Assert.*;


public class SearchAlgorithmsTest {
    private final int start;
    private final int destination;
    private final int widthOfMaze = 1000;
    private final Room[] maze;
    
    public SearchAlgorithmsTest() {
        maze = RandomKruskal.createMaze(widthOfMaze);
        RandomStartAndDestination startAndDestination = new 
            RandomStartAndDestination(widthOfMaze);
        start = startAndDestination.getStart();
        destination = startAndDestination.getDestination();
        SearchAlgorithms.breadthFirstSearch(start, destination, maze, widthOfMaze);
        SearchAlgorithms.aStar(start, destination, maze, widthOfMaze);
    }
    
    @Test
    public void bfsHasPathFromStartToDestination() {
        int nextBfs = destination;
        int i = 0;
        while(nextBfs != start){
            Room roomBfs = maze[nextBfs];
            nextBfs = roomBfs.getBfsPrevious();
            i++;
            assertTrue(i < 1000000);
        }
    }
    
    @Test
    public void aStarHasPathFromStartToDestination() {
        int nextAStar = destination;
        int i = 0;
        while(nextAStar != start) {
            Room roomAStar = maze[nextAStar];
            nextAStar = roomAStar.getAStarPrevious();
            i++;
            assertTrue(i < 1000000);
        }
    }
    
    @Test
    public void bfsAndAstarPathLengthIsTheSame() {
        int nextAStar = destination;
        int nextBfs = destination;
        while(nextAStar != start || nextBfs != start){
            Room roomBfs = maze[nextBfs];
            Room roomAStar = maze[nextAStar];
            nextAStar = roomAStar.getAStarPrevious();
            nextBfs = roomBfs.getBfsPrevious();
        }
        assertEquals(start, nextAStar );
        assertEquals(start, nextBfs);
    }
    
    @Test
    public void bfsDoesNotGoOverWalls() {
        int current = destination;
        while(current != start){
            Room room = maze[current];
            int old = current;
            current = room.getBfsPrevious();
            if(current - old == -widthOfMaze) {
                assertTrue(room.getUpperSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == widthOfMaze) {
                assertTrue(room.getLowerSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == 1) {
                assertTrue(room.getRightSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == -1) {
                assertTrue(room.getLeftSide() == TypesOfSides.getHALLWAY());
            }
        }
    }
    
    @Test
    public void AStarDoesNotGoOverWalls() {
        int current = destination;
        while(current != start){
            Room room = maze[current];
            int old = current;
            current = room.getAStarPrevious();
            if(current - old == -widthOfMaze) {
                assertTrue(room.getUpperSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == widthOfMaze) {
                assertTrue(room.getLowerSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == 1) {
                assertTrue(room.getRightSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == -1) {
                assertTrue(room.getLeftSide() == TypesOfSides.getHALLWAY());
            }
        }
    }
    
    
}
