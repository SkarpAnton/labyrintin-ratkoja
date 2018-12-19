package maze.datastructures;

/**
 * Heap uses array for its heap implementation,
 * 
 * Heap uses specialized object called ObjectForHeap. Later user can generalize the heap if
 * need be, it should be rather easy.
 */
public class Heap {

    private final ObjectForHeap[] heap;
    private int size = -1;
    
    /**
     * 
     * @param sizeOfHeap Size of the array used in this heap implementation.  
     *   The size is the maximum size of the heap.
     */
    public Heap(int sizeOfHeap) {
        this.heap = new ObjectForHeap[sizeOfHeap / 2];
    }
    
    /**
     *
     * @param object object to be added to the heap
     */
    public void add(ObjectForHeap object) {
        size++;    
        int index = size;
        while (index > 0 && object.compareTo(heap[parent(index)])) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = object;
    }

    /**
     * Gets and removes the first object in heap
     * @return first object in heap. 
     */
    public ObjectForHeap poll() {
        ObjectForHeap min = heap[0];
        heap[0] = heap[size];
        size--;
        heapify(0);       
        return min;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void heapify(int index) {
        int left = left(index);
        int right = right(index);
        if (left > size) {
            return;
        }
        int smallest = left;
        if (right <= size && heap[right].compareTo(heap[left])) {
            smallest = right;
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
        ObjectForHeap copyOfFirst = first;
        heap[firstIndex] = second;
        heap[secondIndex] = copyOfFirst;
    }
}
