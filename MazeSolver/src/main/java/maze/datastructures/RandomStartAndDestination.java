package maze.datastructures;

import java.util.Random;

public class RandomStartAndDestination {

    private int start;
    private int destination;

    public RandomStartAndDestination(int amountOfSquares) {
        Random rand = new Random();
        start = rand.nextInt(amountOfSquares);
        destination = rand.nextInt(amountOfSquares);
        while (start == destination) {
            start = rand.nextInt(amountOfSquares);
            destination = rand.nextInt(amountOfSquares);
        }
    }

    public int getStart() {
        return start;
    }

    public int getDestination() {
        return destination;
    }

}
