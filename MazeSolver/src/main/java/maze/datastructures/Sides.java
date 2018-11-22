package maze.datastructures;

public class Sides {


    private Sides() {
    }
    
    /*
    * ´Side's value 0 returns the upper square's index, with value 1 returns the 
    *  lower square's index, value 2 return the left square's index, value 3
    *  returns the right square's index. 
    * 
    *  Throws IllegalArgumentException if side is not 0, 1, 2 or 3 
    */
    public static int getIndexOfSide(int side, Square square) {
        switch (side) {
            case 0:
                return square.getUpperSquareIndex();
            case 1:
                return square.getLowerSquareIndex();
            case 2:
                return square.getLeftSquareIndex();
            case 3: 
                return square.getRightSquareIndex();
        }
        throw new IllegalArgumentException(side + " is not 0, 1, 2 or 3");
    }
    
    public static int getTypeOfSide(int side, Square square) {
        switch (side) {
            case 0:
                return square.getUpperSide();
            case 1:
                return square.getLowerSide();
            case 2:
                return square.getLeftSide();
            case 3: 
                return square.getRightSide();
        }
        throw new IllegalArgumentException(side + " is not 0, 1, 2 or 3");
    }
    /*
    * Sets hallway between two squares that are next to each other. 
    * Parameter side is used to set the hallway on current squares coresponding side
    * and side is used on the next square to set the opposite of the corresponding 
    * side to hallway
    */
    public static void setAsHallway(int side, Square current, Square next) {
        setThisAsHallway(side, current);
        setOppositeAsHallway(side, next);
    }
    
    private static void setThisAsHallway(int side, Square square) {
        switch (side) {
            case 0:
                square.setUpperSide(TypesOfSides.getHALLWAY());
                return;
            case 1:
                square.setLowerSide(TypesOfSides.getHALLWAY());
                return;
            case 2:
                square.setLeftSide(TypesOfSides.getHALLWAY());
                return;
        }
        square.setRightSide(TypesOfSides.getHALLWAY());
    }

    private static void setOppositeAsHallway(int side, Square square) {
        switch (side) {
            case 0:
                square.setLowerSide(TypesOfSides.getHALLWAY());
                return;
            case 1:
                square.setUpperSide(TypesOfSides.getHALLWAY());
                return;
            case 2:
                square.setRightSide(TypesOfSides.getHALLWAY());
                return;
        }
        square.setLeftSide(TypesOfSides.getHALLWAY());
    }
}
