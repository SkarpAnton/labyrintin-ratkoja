package maze.datastructures;

public class UnionFind {

    private final int[] trees;
    private int amountOfTrees;

    public UnionFind(int amountOfSquares) {
        this.amountOfTrees = amountOfSquares;
        trees = new int[amountOfSquares];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = -1;
        }
    }

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

    public int find(int x) {
        if (trees[x] < 0) {
            return x;
        } else {
            return find(trees[x]);
        }
    }

    public boolean connectedTree() {
        return 1 >= amountOfTrees;
    }
}
