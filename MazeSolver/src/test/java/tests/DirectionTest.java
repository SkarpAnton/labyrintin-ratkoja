

import maze.datastructures.Direction;
import maze.datastructures.Square;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DirectionTest {
    
    private final Square square = new Square();
    
    @Before
    public void setup() {
        square.setUpper(0);
        square.setLower(10);
        square.setLeft(20);
        square.setRight(30);
        
    }
    @Test
    public void getSuuntaTest() {
        assertEquals(0, Direction.getDirection(0, square));
        assertEquals(10, Direction.getDirection(1, square));
        assertEquals(20, Direction.getDirection(2, square));
        assertEquals(30, Direction.getDirection(3, square));
    }
    @Test
    public void setKaytavaTest() {
        Square next = new Square();
        next.setLower(10);
        Direction.setAsHallway(0, square, next);
        assertEquals(-2, square.getUpper());
        assertEquals(-2, next.getLower());
    }
}
