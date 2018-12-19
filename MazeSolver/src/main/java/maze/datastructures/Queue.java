package maze.datastructures;

public class Queue {

    private final int[] queue;
    private int head = 0;
    private int tail = 0;
    private final int size;

    /**
     * 
     * @param sizeOfQueue Size of the array used in this heap implementation.  
     *   The size is the maximum size of the heap.
     */
    public Queue(int sizeOfQueue) {
        this.queue = new int[sizeOfQueue];
        size = sizeOfQueue;
    }

    /**
     *
     * @param value value to be added to a queue
     */
    public void add(int value) {
        queue[tail] = value;
        tail++;
        if (tail == size) {
            tail = 0;
        }
    }
    
    /**
     *
     * @return first value in queue
     */
    public int poll() {
        int first = queue[head];
        head++;
        if (head == size) {
            head = 0;
        }
        return first;
    }

}
