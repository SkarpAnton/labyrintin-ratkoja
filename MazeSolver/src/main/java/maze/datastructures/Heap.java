package maze.datastructures;

public class Heap {

    private SquareAndPriority[] heap;
    private int size = -1;

    public Heap(int amountOfSquares) {
        this.heap = new SquareAndPriority[amountOfSquares];
    }

    public void add(SquareAndPriority squareAndPriority) {
        size++;
        int index = size;
        while (index > 0 && squareAndPriority.compareTo(heap[parent(index)])) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = squareAndPriority;
    }

    public SquareAndPriority poll() {
        SquareAndPriority min = heap[0];
        heap[0] = heap[size];
        size--;
        heapify(0);
        return min;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int left(int index) {
        return 2 * index;
    }

    private int right(int index) {
        return 2 * index + 1;
    }

    private void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int largest = right;
        if (right <= size) {
            if (heap[left].compareTo(heap[right])) {
                largest = left;
            }
            if (heap[largest].compareTo(heap[index])) {
                swap(heap[largest], heap[index]);
                heapify(largest);
            }
        } else if (left == size && heap[left].compareTo(heap[index])) {
            swap(heap[left], heap[index]);
        }
    }

    private void swap(SquareAndPriority first, SquareAndPriority second) {
        SquareAndPriority copyOfFirst = new SquareAndPriority(first.getIndexOfSquare(),
                first.getDistance(), first.getPrevious());
        first = second;
        second = copyOfFirst;
    }
}
