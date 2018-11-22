package maze.datastructures;

import java.util.Random;

public class RandomStartAndDestination {

    private int start;
    private int destination;

    public RandomStartAndDestination(int amountOfSquares, int widthOfMaze) {
        Random rand = new Random();
        start = rand.nextInt(amountOfSquares);
        destination = rand.nextInt(amountOfSquares);
        while (start == destination || distance(widthOfMaze) < widthOfMaze) {
            start = rand.nextInt(amountOfSquares);
            destination = rand.nextInt(amountOfSquares);
        }
    }
    public int distance(int widthOfMaze) {
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
