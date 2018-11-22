package maze.datastructures;

public class Heap {

    private ObjectForHeap[] heap;
    private int size = -1;
    
    /*
    * Constructs heap, parameter is the maximum size of the heap;
    */
    public Heap(int amountOfSquares) {
        this.heap = new ObjectForHeap[amountOfSquares / 2];
    }

    public void add(ObjectForHeap object) {
        size++;    
        int index = size;
        while (index > 0 && object.compareTo(heap[parent(index)])) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = object;
    }

    public ObjectForHeap poll() {
        ObjectForHeap min = heap[0];
        heap[0] = heap[size];
        heapify(0);
        size--;
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
        if (right >= size && left >= size) {
            return;
        }
        int smallest = right;
        if (heap[left].compareTo(heap[right])) {
            smallest = left;
        }
        if (heap[index].compareTo(heap[smallest])) {
            smallest = index;
        }
        if (smallest != index) {
            swap(heap[index], heap[smallest], index, smallest);
            heapify(smallest);
        }
    }

    private void swap(ObjectForHeap first, ObjectForHeap second,
            int firstIndex, int secondIndex) {
        ObjectForHeap copyOfFirst = new ObjectForHeap(first.getIndexOfSquare(),
                first.getPriority(), first.getPrevious(), first.getDistance());
        heap[firstIndex] = second;
        heap[secondIndex] = copyOfFirst;
    }
}
