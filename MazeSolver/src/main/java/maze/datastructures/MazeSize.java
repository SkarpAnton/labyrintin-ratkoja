
package maze.datastructures;

public class MazeSize {
    private int roomWidth;
    private final int mazeWidth;
    private final int amountOfSquares;
    private final int frameWidth;
    private final int widthOfPathMark;

    public MazeSize(int mazeWidth, int frameWidth) {
        this.mazeWidth = mazeWidth;
        amountOfSquares = mazeWidth * mazeWidth;
        this.frameWidth = frameWidth;
        roomWidth = frameWidth / mazeWidth;
        if (roomWidth < 2) {
            roomWidth = 2;
        }
        widthOfPathMark = roomWidth / 2;
    }

    public int getRoomWidth() {
        return roomWidth;
    }

    public int getMazeWidth() {
        return mazeWidth;
    }

    public int getAmountOfRooms() {
        return amountOfSquares;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getWidthOfPathMark() {
        return widthOfPathMark;
    }

    
}
