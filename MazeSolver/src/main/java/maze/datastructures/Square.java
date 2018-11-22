package maze.datastructures;

public class Square {
    
    private final int index;
    private final int lowerSquareIndex;
    private final int upperSquareIndex;
    private final int rightSquareIndex;
    private final int leftSquareIndex;
    private int leftSide = TypesOfSides.getWALL();
    private int rightSide = TypesOfSides.getWALL();
    private int upperSide = TypesOfSides.getWALL();
    private int lowerSide = TypesOfSides.getWALL();
    private int bfsPrevious = -1;
    private int aStarPrevious = -1;
    private double bestPriority = 100000000;


    public Square(int index, int widthOfMaze) {
        this.index = index;
        lowerSquareIndex = index + widthOfMaze;
        upperSquareIndex = index - widthOfMaze;
        rightSquareIndex = index + 1;
        leftSquareIndex = index - 1;
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
        return index;
    }

    public int getLowerSquareIndex() {
        return lowerSquareIndex;
    }

    public int getUpperSquareIndex() {
        return upperSquareIndex;
    }

    public int getRightSquareIndex() {
        return rightSquareIndex;
    }

    public int getLeftSquareIndex() {
        return leftSquareIndex;
    }

    public int getaStarPrevious() {
        return aStarPrevious;
    }

    public void setaStarPrevious(int aStarPrevious) {
        this.aStarPrevious = aStarPrevious;
    }
    
}
