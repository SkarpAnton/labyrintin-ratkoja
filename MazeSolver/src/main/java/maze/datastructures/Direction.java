package maze.datastructures;

import maze.datastructures.Square;

public class Direction {


    private Direction() {
    }
    
    public static int getDirection(int side, Square square) {
        switch (side) {
            case 0:
                return square.getUpper();
            case 1:
                return square.getLower();
            case 2:
                return square.getLeft();
        }
        return square.getRight();
    }

    public static void setAsHallway(int side, Square current, Square next) {
        setThisAsHallway(side, current);
        setOppositeAsHallway(side, next);
    }
    private static void setThisAsHallway(int side, Square square) {
        switch (side) {
            case 0:
                square.setUpper(TypesOfSquares.getHALLWAY());
                return;
            case 1:
                square.setLower(TypesOfSquares.getHALLWAY());
                return;
            case 2:
                square.setLeft(TypesOfSquares.getHALLWAY());
                return;
        }
        square.setRight(TypesOfSquares.getHALLWAY());
    }

    private static void setOppositeAsHallway(int side, Square square) {
        switch (side) {
            case 0:
                square.setLower(TypesOfSquares.getHALLWAY());
                return;
            case 1:
                square.setUpper(TypesOfSquares.getHALLWAY());
                return;
            case 2:
                square.setRight(TypesOfSquares.getHALLWAY());
                return;
        }
        square.setLeft(TypesOfSquares.getHALLWAY());
    }
}
