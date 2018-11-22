
package tests;

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
    public void heapAddPollTest() {
        Heap heap = new Heap(10000000);
        Random rand = new Random();
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
}
