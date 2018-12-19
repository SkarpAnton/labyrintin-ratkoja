package maze.datastructures;

/**
 * Contains all of the size related data about the maze.
 */
public class MazeSize {

    private int roomWidth;
    private final int mazeWidth;
    private final int amountOfRooms;
    private final int frameWidth;
    private final int widthOfPathMark;

    /**
     * Constructor for MazeSize. Calculates room width, sizes of path marks 
     * and amount of rooms from parameters.
     * @param mazeWidth 
     *          Labyrinth has mazeWidth x mazeWidth rooms, thus mazeWidth is the
     *          amount of rooms that this maze has on a row or column
     * @param frameWidth
     *          Width and height of the picture in pixels.
     */
    public MazeSize(int mazeWidth, int frameWidth) {
        this.mazeWidth = mazeWidth;
        amountOfRooms = mazeWidth * mazeWidth;
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
        return amountOfRooms;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getWidthOfPathMark() {
        return widthOfPathMark;
    }

}
