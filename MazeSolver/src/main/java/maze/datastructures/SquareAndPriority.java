package maze.datastructures;

public class SquareAndPriority {

    private final int indexOfSquare;
    private final int distance;
    private final int previous;

    public SquareAndPriority(int indexOfSquare, int distance, int previous) {
        this.indexOfSquare = indexOfSquare;
        this.distance = distance;
        this.previous = previous;
    }

    public int getPrevious() {
        return previous;
    }

    public int getIndexOfSquare() {
        return indexOfSquare;
    }

    public int getDistance() {
        return distance;
    }

    public boolean compareTo(SquareAndPriority other) {
        return distance > other.getDistance();
    }
}
