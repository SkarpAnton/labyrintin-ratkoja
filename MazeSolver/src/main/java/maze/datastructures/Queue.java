package maze.datastructures;

public class Queue {

    private int[] queue;
    private int head = 0;
    private int tail = 0;
    private int size;

    public Queue(int amountOfSquares) {
        this.queue = new int[amountOfSquares];
        size = amountOfSquares;
    }

    public void add(int indexOfSquare) {
        queue[tail] = indexOfSquare;
        tail++;
        if (tail == size) {
            tail = 0;
        }
    }

    public int poll() {
        int first = queue[head];
        head++;
        if (head == size) {
            head = 0;
        }
        return first;
    }
}
