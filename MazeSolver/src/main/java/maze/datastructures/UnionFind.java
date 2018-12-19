package maze.datastructures;

/**
 * Basic implementation oof the union-find data structure, more information on
 * <a href="https://en.wikipedia.org/wiki/Disjoint-set_data_structure">wikipedia union-find</a>
 */
public class UnionFind {

    private final int[] trees;
    private int amountOfTrees;

    /**
     *
     * @param amountOfRooms amount of rooms or alternatively amount of vertices
     */
    public UnionFind(int amountOfRooms) {
        this.amountOfTrees = amountOfRooms;
        trees = new int[amountOfRooms];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = -1;
        }
    }

    /**
     * Combines the two trees.
     * Assumes that roots are not equal.
     * @param firstRoot root of the first tree to be combined
     * @param secondRoot root of the second tree to be combined
     */
    public void union(int firstRoot, int secondRoot) {
        if (trees[secondRoot] < trees[firstRoot]) {
            trees[firstRoot] = secondRoot;
        } else {
            if (trees[firstRoot] == trees[secondRoot]) {
                trees[firstRoot]--;
            }
            trees[secondRoot] = firstRoot;
        }
        amountOfTrees--;
    }

    /**
     * finds the root of the tree
     * @return the root of the tree
     */
    public int find(int indexOfRoom) {
        if (trees[indexOfRoom] < 0) {
            return indexOfRoom;
        } else {
            return find(trees[indexOfRoom]);
        }
    }

    /**
     *  
     * @return true if tree is connected otherwise false
     */
    public boolean connectedTree() {
        return 1 >= amountOfTrees;
    }
}
