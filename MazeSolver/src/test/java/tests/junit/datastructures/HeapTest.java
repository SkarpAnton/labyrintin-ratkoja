
package tests.junit.datastructures;

import java.util.Random;
import maze.datastructures.Heap;
import maze.datastructures.ObjectForHeap;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {

    public HeapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void heapAddPollRandomTest() {
        Heap heap = new Heap(10000000);
        Random rand = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            ObjectForHeap s1 = new ObjectForHeap(0, rand.nextInt(1000000), 0, 0);
            heap.add(s1);
        }
        int max = 0;
        for (int i = 0; i < 10000; i++) {
            int current = heap.poll().getPriority();
            assertTrue(current >= max);
            max = current;
        }
    }
    
    @Test
    public void heapAddPollAddPollRandomTest() {
        Heap heap = new Heap(10000000);
        Random rand = new Random(2278);
        for (int i = 0; i < 10000; i++) {
            ObjectForHeap s1 = new ObjectForHeap(0, rand.nextInt(1000000), 0, 0);
            heap.add(s1);
        }
        for (int i = 0; i < 5000; i++) {
            heap.poll().getPriority();
        }
        for (int i = 0; i < 10000; i++) {
            ObjectForHeap s1 = new ObjectForHeap(0, rand.nextInt(1000000), 0, 0);
            heap.add(s1);
        }
        int max = 0;
        for (int i = 0; i < 10000; i++) {
            int current = heap.poll().getPriority();
            assertTrue(current >= max);
            max = current;
        }
    }
    
    @Test
    public void heapAddAndPollTest() {
        ObjectForHeap s1 = new ObjectForHeap(0, 6, 0, 0);
        ObjectForHeap s2 = new ObjectForHeap(0, 2, 0, 0);
        Heap heap = new Heap(1000);
        heap.add(s1);
        heap.add(s2);
        int priority = heap.poll().getPriority();
        assertEquals(2, priority);
    }
    
    
}
