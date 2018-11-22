package tests;

import maze.datastructures.Sides;
import maze.datastructures.Square;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SidesTest {

    private final Square square = new Square(11, 10);

    @Before
    public void setup() {
        square.setUpperSide(0);
        square.setLowerSide(12);
        square.setLeftSide(20);
        square.setRightSide(30);

    }

    @Test
    public void getSuuntaTest() {
        assertEquals(1, Sides.getIndexOfSide(0, square));
        assertEquals(21, Sides.getIndexOfSide(1, square));
        assertEquals(10, Sides.getIndexOfSide(2, square));
        assertEquals(12, Sides.getIndexOfSide(3, square));
    }

    @Test
    public void setKaytavaTest() {
        Square next = new Square(1, 10);
        Sides.setAsHallway(0, square, next);
        assertEquals(-2, square.getUpperSide());
        assertEquals(-2, next.getLowerSide());
    }
}
