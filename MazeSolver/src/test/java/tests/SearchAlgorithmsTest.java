package tests;

import maze.algorithms.SearchAlgorithms;
import maze.datastructures.Square;
import maze.algorithms.RandomKruskal;
import maze.datastructures.RandomStartAndDestination;
import maze.datastructures.TypesOfSides;
import org.junit.Test;
import static org.junit.Assert.*;


public class SearchAlgorithmsTest {
    private final int start;
    private final int destination;
    private final int widthOfMaze = 1000;
    private final Square[] maze;
    
    public SearchAlgorithmsTest() {
        maze = RandomKruskal.createMaze(widthOfMaze);
        RandomStartAndDestination startAndDestination = new 
            RandomStartAndDestination(widthOfMaze * widthOfMaze, widthOfMaze);
        start = startAndDestination.getStart();
        destination = startAndDestination.getDestination();
        SearchAlgorithms.breadthFirstSearch(start, destination, maze, widthOfMaze);
        SearchAlgorithms.aStar(start, destination, maze, widthOfMaze);
    }
    
    @Test
    public void bfsAndAstarPathLengthIsTheSame() {
        int nextAStar = destination;
        int nextBfs = destination;
        while(nextAStar != start || nextBfs != start){
            Square squareBfs = maze[nextBfs];
            Square squareAStar = maze[nextAStar];
            nextAStar = squareAStar.getAStarPrevious();
            nextBfs = squareBfs.getBfsPrevious();
        }
        assertEquals(start, nextAStar );
        assertEquals(start, nextBfs);
    }
    
    @Test
    public void bfsDoesNotGoOverWalls() {
        int current = destination;
        while(current != start){
            Square square = maze[current];
            int old = current;
            current = square.getBfsPrevious();
            if(current - old == -widthOfMaze) {
                assertTrue(square.getUpperSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == widthOfMaze) {
                assertTrue(square.getLowerSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == 1) {
                assertTrue(square.getRightSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == -1) {
                assertTrue(square.getLeftSide() == TypesOfSides.getHALLWAY());
            }
        }
    }
    
    @Test
    public void AStarDoesNotGoOverWalls() {
        int current = destination;
        while(current != start){
            Square square = maze[current];
            int old = current;
            current = square.getAStarPrevious();
            if(current - old == -widthOfMaze) {
                assertTrue(square.getUpperSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == widthOfMaze) {
                assertTrue(square.getLowerSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == 1) {
                assertTrue(square.getRightSide() == TypesOfSides.getHALLWAY());
            }
            if(current - old == -1) {
                assertTrue(square.getLeftSide() == TypesOfSides.getHALLWAY());
            }
        }
    }
    
}
