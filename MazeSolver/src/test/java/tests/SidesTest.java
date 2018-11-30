package tests;

import maze.datastructures.Sides;
import maze.datastructures.Square;
import maze.datastructures.TypesOfSides;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SidesTest {

    private Square square = new Square(11, 10);

    @Before
    public void setup() {
        square = new Square(11, 10);
    }

    @Test
    public void getSuuntaTestUp() {
        assertEquals(1, Sides.getIndexOfNextSquare(0, square));
    }
    
    @Test
    public void getSuuntaTestDown() {

        assertEquals(21, Sides.getIndexOfNextSquare(1, square));
    }
    @Test
    public void getSuuntaTestLeft() {
        assertEquals(10, Sides.getIndexOfNextSquare(2, square));
    }
    @Test
    public void getSuuntaTestRight() {
        assertEquals(12, Sides.getIndexOfNextSquare(3, square));
    }
    @Test
    public void getSuuntaTestNotSide() {
        try {
            Sides.getIndexOfNextSquare(5, square);
            fail("did not throw IllegalArgumentException with unvalid parameter side");
        } catch (IllegalArgumentException e) {
            
        }
    }
    

    @Test
    public void setKaytavaTest() {
        Square next = new Square(1, 10);
        Sides.setAsHallway(0, square, next);
        assertEquals(-2, square.getUpperSide());
        assertEquals(-2, next.getLowerSide());
    }
    
    @Test
    public void getTypeOfSideTestUp() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(0, square));
    }
    @Test
    public void getTypeOfSideTestDown() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(1, square));
    }
    @Test
    public void getTypeOfSideTestLeft() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(2, square));
    }
    @Test
    public void getTypeOfSideTestRight() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(3, square));
    }
    @Test
    public void getTypeOfSideTestUpHallway() {
        square.setUpperSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(0, square));
    }
    @Test
    public void getTypeOfSideTestDownHallway() {
        square.setLowerSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(1, square));
    }
    @Test
    public void getTypeOfSideTestLeftHallway() {
        square.setLeftSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(2, square));
    }
    @Test
    public void getTypeOfSideTestRightHallway() {
        square.setRightSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(3, square));
    }
    @Test
    public void getTypeOfSideTestNotSide() {
        try{
            Sides.getTypeOfSide(5, square);
            fail("did not throw IllegalArgumentException with unvalid parameter side");
        } catch (IllegalArgumentException e) {
            
        }
    }
}
