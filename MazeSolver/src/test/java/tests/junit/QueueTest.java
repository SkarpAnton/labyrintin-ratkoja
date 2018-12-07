
package tests.junit;

import maze.datastructures.Queue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    private Queue queue;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        queue = new Queue(1000000);
    }
    
    @Test
    public void addAndPoll() {
        queue.add(6);
        queue.add(4);
        assertEquals(6, queue.poll());
    }
    
    @Test
    public void addAddPollAddPoll() {
        queue.add(2);
        queue.add(8);
        queue.poll();
        queue.add(10);
        assertEquals(8, queue.poll());
    }
    
    @Test
    public void AddsAndPolled() {
        for(int i = 0; i < 100000; i++) {
            queue.add(i);
        }
        for(int i = 0; i < 100000; i++) {
            assertEquals(i, queue.poll());
        }
    }
    @Test
    public void tailWrapsAround() {
        for(int i = 0; i < 1000000; i++) {
            queue.add(i);
        }
        queue.poll();
        queue.add(6);
        assertEquals(1, queue.poll());
    }
    @Test
    public void headWrapsAround() {
        for(int i = 0; i < 1000005; i++) {
            queue.add(i);
        }
        for(int i = 0; i < 1000004; i++) {
            queue.poll();
        }
        assertEquals(1000004, queue.poll());
    }
    
}
