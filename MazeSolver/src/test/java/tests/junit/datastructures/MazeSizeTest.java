
package tests.junit.datastructures;

import maze.datastructures.MazeSize;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MazeSizeTest {

    int mazeWidth = 100;
    int frameWidth = 1000;
    MazeSize mazeSize;

    @Before
    public void setUp() {
        mazeSize = new MazeSize(mazeWidth, frameWidth);
    }

    @Test
    public void getFrameWidthTest() {
        assertEquals(frameWidth, mazeSize.getFrameWidth());
    }

    @Test
    public void getMazeWidthTest() {
        assertEquals(mazeWidth, mazeSize.getMazeWidth());
    }

    @Test
    public void getRoomWidthTestSmallMaze() {
        assertEquals(mazeSize.getFrameWidth() / mazeSize.getMazeWidth(),
                mazeSize.getRoomWidth());
    }

    @Test
    public void getRoomWidthTestBigMaze() {
        mazeSize = new MazeSize(1000, frameWidth);
        assertEquals(2, mazeSize.getRoomWidth());
    }

    @Test
    public void getAmountOfRoomsTest() {
        assertEquals(mazeSize.getMazeWidth() * mazeSize.getMazeWidth(),
                mazeSize.getAmountOfRooms());
    }

    @Test
    public void getWidthOfPathMarkerTest() {
        assertEquals(mazeSize.getRoomWidth() / 2, mazeSize.getWidthOfPathMark());
    }

}
