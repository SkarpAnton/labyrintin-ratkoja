package maze.datastructures;

public class ObjectForHeap {

    private int indexOfRoom;
    private int priority;
    private int previous;
    private int distance;

    public ObjectForHeap(int indexOfRoom, int priority, int previous, int distance) {
        this.indexOfRoom = indexOfRoom;
        this.priority = priority;
        this.previous = previous;
        this.distance = distance;
        
    }

    public int getPrevious() {
        return previous;
    }

    public int getIndexOfRoom() {
        return indexOfRoom;
    }

    public int getPriority() {
        return priority;
    }

    public int getDistance() {
        return distance;
    }

    public void setIndexOfRoom(int indexOfRoom) {
        this.indexOfRoom = indexOfRoom;
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
