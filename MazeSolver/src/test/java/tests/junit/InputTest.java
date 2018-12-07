package tests.junit;



import java.io.ByteArrayInputStream;
import java.io.InputStream;
import maze.userinterface.Input;
import org.junit.*;
import static org.junit.Assert.*;

public class InputTest {

    @Before
    public void setUp() {
        String input = "2\n10\n8\n16";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void getWidthOfMazeStdTest() {
        int mazeWidth = Input.getMazeSizes(new String[] {}).getMazeWidth();
        assertEquals(10, mazeWidth);
    }
    
    @Test
    public void getWidthOfFrameStdTest() {
        int frameWidth = Input.getMazeSizes(new String[] {}).getFrameWidth();
        assertEquals(16, frameWidth);
    }
    @Test
    public void getWidthOfMazeCommandLineCorrectSizeTest() {
        int mazeWidth = Input.getMazeSizes(new String[] {"10", "20"}).getMazeWidth();
        assertEquals(10, mazeWidth);
    }
    @Test
    public void getWidthOfFrameCommandLineCorrectSizeTest() {
        int frameWidth = Input.getMazeSizes(new String[] {"10", "20"}).getFrameWidth();
        assertEquals(20, frameWidth);
    }
}
