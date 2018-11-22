package tests;

import maze.datastructures.UnionFind;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class UnionFindTest {
    private UnionFind tree;
    private final int size = 100;
    
    @Before
    public void setUp() {
        tree = new UnionFind(size);
    }
    
    @Test
    public void connectedTreeTest() {
        for(int i = 1; i < size; i++) {
            assertTrue(!tree.connectedTree());
            tree.union(tree.find(i-1), i);
        }
        assertTrue(tree.connectedTree());
    }
    
    @Test
    public void unionAndFindTest() {
       for(int i = 1; i < size; i++) {
            tree.union(tree.find(i-1), i);
            assertEquals(0, tree.find(i));
        } 
    }
    
    
}
