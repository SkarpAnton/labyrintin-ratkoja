package maze.datastructures;


public class ObjectForHeap {

    private int indexOfRoom;
    private int priority;
    private int previous;
    private int distance;

    /**
     *
     * @param priority used to sort the object in heap
     * @param previous index the of room that found this room with given priority
     * @param distance amount of steps taken to get to this room
     */
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
    
    /**
     * Compares objects based on priority (distance + heuristic)
     */
    public boolean compareTo(ObjectForHeap other) {
        return priority < other.getPriority();
    }

}
