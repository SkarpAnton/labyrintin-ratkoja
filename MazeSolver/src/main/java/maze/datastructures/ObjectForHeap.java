package maze.datastructures;

public class ObjectForHeap {

    private int indexOfSquare;
    private int priority;
    private int previous;
    private int distance;

    public ObjectForHeap(int indexOfSquare, int priority, int previous, int distance) {
        this.indexOfSquare = indexOfSquare;
        this.priority = priority;
        this.previous = previous;
        this.distance = distance;
        
    }

    public int getPrevious() {
        return previous;
    }

    public int getIndexOfSquare() {
        return indexOfSquare;
    }

    public int getPriority() {
        return priority;
    }

    public int getDistance() {
        return distance;
    }

    public void setIndexOfSquare(int indexOfSquare) {
        this.indexOfSquare = indexOfSquare;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    
    
    public boolean compareTo(ObjectForHeap other) {
        return priority < other.getPriority();
    }

}
