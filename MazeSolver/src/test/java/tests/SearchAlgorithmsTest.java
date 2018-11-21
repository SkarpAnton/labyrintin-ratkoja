

import maze.algorithms.SearchAlgorithms;
import maze.datastructures.Square;
import maze.algorithms.RandomKruskal;
import org.junit.Test;
import static org.junit.Assert.*;


public class SearchAlgorithmsTest {
    private final int start = 150;
    private final int destination = 750;
    private final int widthOfMaze = 100;
    private final int hallway = -2;
    private final Square[] maze;
    
    public SearchAlgorithmsTest() {
        maze = RandomKruskal.createMaze(widthOfMaze);
        SearchAlgorithms.breadthFirstSearch(start, destination, maze, widthOfMaze);
        SearchAlgorithms.aStar(start, destination, maze, widthOfMaze);
    }
    
    @Test
    public void bfsAndAstarPathLengthIsTheSame() {
        int nextAStar = destination;
        int NextBfs = destination;
        while(nextAStar != start && NextBfs != start){
            Square squareBfs = maze[NextBfs];
            Square squareAStar = maze[nextAStar];
            nextAStar = squareAStar.getAStarPrevious();
            NextBfs = squareBfs.getBfsPrevious();
        }
        assertEquals(nextAStar, start);
        assertEquals(NextBfs, start);
    }
    
    @Test
    public void bfsDoesNotGoOverWalls() {
        int current = destination;
        while(current != start){
            Square square = maze[current];
            int old = current;
            current = square.getBfsPrevious();
            if(current - old == -widthOfMaze) {
                assertTrue(square.getUpper() == hallway);
            }
            if(current - old == widthOfMaze) {
                assertTrue(square.getLower() == hallway);
            }
            if(current - old == 1) {
                assertTrue(square.getRight() == hallway);
            }
            if(current - old == -1) {
                assertTrue(square.getLeft() == hallway);
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
                assertTrue(square.getUpper() == hallway);
            }
            if(current - old == widthOfMaze) {
                assertTrue(square.getLower() == hallway);
            }
            if(current - old == 1) {
                assertTrue(square.getRight() == hallway);
            }
            if(current - old == -1) {
                assertTrue(square.getLeft() == hallway);
            }
        }
    }
    
}
