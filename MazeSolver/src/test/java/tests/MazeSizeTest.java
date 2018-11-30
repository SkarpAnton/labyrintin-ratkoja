
package tests;

import maze.datastructures.MazeSize;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MazeSizeTest {

    int mazeWidth = 100;
    MazeSize mazeSize;

    @Before
    public void setUp() {
        mazeSize = new MazeSize(mazeWidth);
    }

    @Test
    public void getFrameWidthTest() {
        assertEquals(1000, mazeSize.getFrameWidth());
    }

    @Test
    public void getMazeWidthTest() {
        assertEquals(mazeWidth, mazeSize.getMazeWidth());
    }

    @Test
    public void getSquareWidthTestSmallMaze() {
        assertEquals(mazeSize.getFrameWidth() / mazeSize.getMazeWidth(),
                mazeSize.getSquareWidth());
    }

    @Test
    public void getSquareWidthTestBigMaze() {
        mazeSize = new MazeSize(1000);
        assertEquals(2, mazeSize.getSquareWidth());
    }

    @Test
    public void getAmountOfSquaresTest() {
        assertEquals(mazeSize.getMazeWidth() * mazeSize.getMazeWidth(),
                mazeSize.getAmountOfSquares());
    }

    @Test
    public void getWidthOfPathMarkerTest() {
        assertEquals(mazeSize.getSquareWidth() / 2, mazeSize.getWidthOfPathMark());
    }

}
