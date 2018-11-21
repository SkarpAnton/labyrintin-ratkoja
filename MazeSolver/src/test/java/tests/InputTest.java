

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import maze.userinterface.Input;
import org.junit.*;
import static org.junit.Assert.*;

public class InputTest {

    @Before
    public void setUp() {
        String input = "2\n10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void getWidthOfMazeTest() {
        int width = Input.getWidthOfMaze();
        assertEquals(10, width);
    }

}
