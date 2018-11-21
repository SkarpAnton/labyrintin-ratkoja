
package maze.datastructures;

public class MazeSize {
    private int squareWidth;
    private final int mazeWidth;
    private final int amountOfSquares;
    private final int frameWidth = 1000;
    private final int widthOfPathMark;

    public MazeSize(int mazeWidth) {
        this.mazeWidth = mazeWidth;
        amountOfSquares = mazeWidth * mazeWidth;
        squareWidth = frameWidth / mazeWidth;
        if (squareWidth < 2) {
            squareWidth = 2;
        }
        widthOfPathMark = squareWidth / 2;
    }

    public int getSquareWidth() {
        return squareWidth;
    }

    public int getMazeWidth() {
        return mazeWidth;
    }

    public int getAmountOfSquares() {
        return amountOfSquares;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getWidthOfPathMark() {
        return widthOfPathMark;
    }

    
    
    
}
