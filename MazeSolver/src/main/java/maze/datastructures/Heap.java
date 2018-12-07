package maze.datastructures;

public class Heap {

    private final ObjectForHeap[] heap;
    private int size = -1;
    
    
    public Heap(int sizeOfHeap) {
        this.heap = new ObjectForHeap[sizeOfHeap / 2];
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
