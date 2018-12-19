package maze.datastructures;

/**
 * Contains data about a given room in the maze
 */
public class Room {
    
    private final int roomIndex;
    private final int lowerRoomIndex;
    private final int upperRoomIndex;
    private final int rightRoomIndex;
    private final int leftRoomIndex;
    private int leftSide = TypesOfSides.getWALL();
    private int rightSide = TypesOfSides.getWALL();
    private int upperSide = TypesOfSides.getWALL();
    private int lowerSide = TypesOfSides.getWALL();
    private int bfsPrevious = -1;
    private int aStarPrevious = -1;
    private double bestPriority = 100000000;

    /**
     *
     * @param widthOfMaze
     *          Labyrinth has mazeWidth x mazeWidth rooms, thus mazeWidth is the
     *          amount of rooms that this maze has on a row or column
     */
    public Room(int roomIndex, int widthOfMaze) {
        this.roomIndex = roomIndex;
        lowerRoomIndex = roomIndex + widthOfMaze;
        upperRoomIndex = roomIndex - widthOfMaze;
        rightRoomIndex = roomIndex + 1;
        leftRoomIndex = roomIndex - 1;
    }
    

    public void setBfsPrevious(int leveyshakuEdellinen) {
        this.bfsPrevious = leveyshakuEdellinen;
    }

    public int getBfsPrevious() {
        return bfsPrevious;
    }

    public int getAStarPrevious() {
        return aStarPrevious;
    }

    public double getBestPriority() {
        return bestPriority;
    }

    public void setBestPriority(double bestPriority) {
        this.bestPriority = bestPriority;
    }

    public void setAStarPrevious(int aStarPrevious) {
        this.aStarPrevious = aStarPrevious;
    }

    public void setLeftSide(int left) {
        this.leftSide = left;
    }

    public void setRightSide(int right) {
        this.rightSide = right;
    }

    public void setUpperSide(int up) {
        this.upperSide = up;
    }

    public void setLowerSide(int down) {
        this.lowerSide = down;
    }

    public int getLeftSide() {
        return leftSide;
    }

    public int getRightSide() {
        return rightSide;
    }

    public int getUpperSide() {
        return upperSide;
    }

    public int getLowerSide() {
        return lowerSide;
    }

    public int getIndex() {
        return roomIndex;
    }

    public int getLowerRoomIndex() {
        return lowerRoomIndex;
    }

    public int getUpperRoomIndex() {
        return upperRoomIndex;
    }

    public int getRightRoomIndex() {
        return rightRoomIndex;
    }

    public int getLeftRoomIndex() {
        return leftRoomIndex;
    }

    public int getaStarPrevious() {
        return aStarPrevious;
    }

    public void setaStarPrevious(int aStarPrevious) {
        this.aStarPrevious = aStarPrevious;
    }
    
}
