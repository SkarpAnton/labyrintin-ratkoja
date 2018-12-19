package maze.datastructures;

public class Sides {


    private Sides() {
    }
    
    /**
     * ´Side's value 0 returns the upper room's index, with value 1 returns the 
     *  lower room's index, value 2 return the left room's index, value 3
     *  returns the right room's index. 
     * 
     *  Throws IllegalArgumentException if side is not 0, 1, 2 or 3 
     * @return index of the room that is on parameter rooms side that corresponds
     *         to the parameter side
    */
    public static int getIndexOfNextRoom(int side, Room room) {
        switch (side) {
            case 0:
                return room.getUpperRoomIndex();
            case 1:
                return room.getLowerRoomIndex();
            case 2:
                return room.getLeftRoomIndex();
            case 3: 
                return room.getRightRoomIndex();
        }
        throw new IllegalArgumentException(side + " is not 0, 1, 2 or 3");
    }
    
    /**
     * ´Side's value 0 returns the upper room's type, with value 1 returns the 
     *  lower room's typex, value 2 return the left room's type, value 3
     *  returns the right room's type. 
     * 
     *  Throws IllegalArgumentException if side is not 0, 1, 2 or 3 
     * @param side side corresponds to a side of the room, 0: upper, 1: 1ower, 
     * 2: left, 3: right
     * @param room room which sides type is returned in this method
     * @return type of the side
    */
    public static int getTypeOfSide(int side, Room room) {
        switch (side) {
            case 0:
                return room.getUpperSide();
            case 1:
                return room.getLowerSide();
            case 2:
                return room.getLeftSide();
            case 3: 
                return room.getRightSide();
        }
        throw new IllegalArgumentException(side + " is not 0, 1, 2 or 3");
    }
    /**
    * Sets hallway between two rooms that are next to each other. 
    * Parameter side is used to set the hallway on current rooms corresponding side
    * and side is used on the next room to set the opposite of the corresponding 
    * side to hallway.
     * @param side  side corresponds to a side of the current room, 0: upper, 1: 1ower, 
     * 2: left, 3: right. 
     * @param current current room
     * @param next room that is on the current rooms side that corresponds to parameter 
     * side
    */
    public static void setAsHallway(int side, Room current, Room next) {
        setThisAsHallway(side, current);
        setOppositeAsHallway(side, next);
    }
    
    private static void setThisAsHallway(int side, Room room) {
        switch (side) {
            case 0:
                room.setUpperSide(TypesOfSides.getHALLWAY());
                return;
            case 1:
                room.setLowerSide(TypesOfSides.getHALLWAY());
                return;
            case 2:
                room.setLeftSide(TypesOfSides.getHALLWAY());
                return;
        }
        room.setRightSide(TypesOfSides.getHALLWAY());
    }

    private static void setOppositeAsHallway(int side, Room room) {
        switch (side) {
            case 0:
                room.setLowerSide(TypesOfSides.getHALLWAY());
                return;
            case 1:
                room.setUpperSide(TypesOfSides.getHALLWAY());
                return;
            case 2:
                room.setRightSide(TypesOfSides.getHALLWAY());
                return;
        }
        room.setLeftSide(TypesOfSides.getHALLWAY());
    }
}
