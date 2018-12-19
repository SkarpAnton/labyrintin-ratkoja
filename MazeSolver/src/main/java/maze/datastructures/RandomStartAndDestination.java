package maze.datastructures;

import java.util.Random;

public final class RandomStartAndDestination {

    private int start;
    private int destination;
    
    /**
     * Selects random start and destination index. The distance between the corresponding rooms 
     * are at least the width of the maze based on the euclidian distance.
     * @param widthOfMaze 
     *          Labyrinth has mazeWidth x mazeWidth rooms, thus mazeWidth is the
     *          amount of rooms that this maze has on a row or column
     */
    public RandomStartAndDestination(int widthOfMaze) {
        int amountOfRooms = widthOfMaze * widthOfMaze;
        Random rand = new Random();
        start = rand.nextInt(amountOfRooms);
        destination = rand.nextInt(amountOfRooms);
        while (start == destination || distance(widthOfMaze) < widthOfMaze) {
            start = rand.nextInt(amountOfRooms);
            destination = rand.nextInt(amountOfRooms);
        }
    }
    
    private int distance(int widthOfMaze) {
        int xDiff = Math.abs(destination % widthOfMaze - start % widthOfMaze);
        int yDiff = Math.abs(destination / widthOfMaze - start / widthOfMaze);
        return xDiff + yDiff;
    }
    
    public int getStart() {
        return start;
    }

    public int getDestination() {
        return destination;
    }

}
