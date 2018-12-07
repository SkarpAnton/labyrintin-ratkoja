package tests.junit;

import maze.datastructures.Sides;
import maze.datastructures.Room;
import maze.datastructures.TypesOfSides;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SidesTest {

    private Room room = new Room(11, 10);

    @Before
    public void setup() {
        room = new Room(11, 10);
    }

    @Test
    public void getSuuntaTestUp() {
        assertEquals(1, Sides.getIndexOfNextRoom(0, room));
    }
    
    @Test
    public void getSuuntaTestDown() {

        assertEquals(21, Sides.getIndexOfNextRoom(1, room));
    }
    @Test
    public void getSuuntaTestLeft() {
        assertEquals(10, Sides.getIndexOfNextRoom(2, room));
    }
    @Test
    public void getSuuntaTestRight() {
        assertEquals(12, Sides.getIndexOfNextRoom(3, room));
    }
    @Test
    public void getSuuntaTestNotSide() {
        try {
            Sides.getIndexOfNextRoom(5, room);
            fail("did not throw IllegalArgumentException with unvalid parameter side");
        } catch (IllegalArgumentException e) {
            
        }
    }
    

    @Test
    public void setKaytavaTest() {
        Room next = new Room(1, 10);
        Sides.setAsHallway(0, room, next);
        assertEquals(-2, room.getUpperSide());
        assertEquals(-2, next.getLowerSide());
    }
    
    @Test
    public void getTypeOfSideTestUp() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(0, room));
    }
    @Test
    public void getTypeOfSideTestDown() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(1, room));
    }
    @Test
    public void getTypeOfSideTestLeft() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(2, room));
    }
    @Test
    public void getTypeOfSideTestRight() {
        assertEquals(TypesOfSides.getWALL(), Sides.getTypeOfSide(3, room));
    }
    @Test
    public void getTypeOfSideTestUpHallway() {
        room.setUpperSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(0, room));
    }
    @Test
    public void getTypeOfSideTestDownHallway() {
        room.setLowerSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(1, room));
    }
    @Test
    public void getTypeOfSideTestLeftHallway() {
        room.setLeftSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(2, room));
    }
    @Test
    public void getTypeOfSideTestRightHallway() {
        room.setRightSide(TypesOfSides.getHALLWAY());
        assertEquals(TypesOfSides.getHALLWAY(), Sides.getTypeOfSide(3, room));
    }
    @Test
    public void getTypeOfSideTestNotSide() {
        try{
            Sides.getTypeOfSide(5, room);
            fail("did not throw IllegalArgumentException with unvalid parameter side");
        } catch (IllegalArgumentException e) {
            
        }
    }
}
