package maze.algorithms;

import maze.datastructures.TypesOfSides;
import maze.datastructures.Sides;
import maze.datastructures.Square;
import maze.datastructures.UnionFind;
import java.util.Random;

public class RandomKruskal {

    private static Square[] maze;
    private static int amountOfSquares;

    private RandomKruskal() {
    }

    /*
    * Creates maze based on random kruskal algorithm. Every new square has all 
    * its sides as walls. Kruskal is used to create hallways that connect 
    * every square by removing walls or equivalently adding hallways between squares. 
    * After kruskal creates a spanning tree of hallways some hallways are added to 
    * create more than one valid shortest path between squares.
    * https://en.wikipedia.org/wiki/Maze_generation_algorithm
    */
    public static Square[] createMaze(int widthOfMaze) {
        initialization(widthOfMaze);
        createSpanningTree();
        createMoreHallways();
        return maze;
    }

    private static void initialization(int widthOfMaze) {
        amountOfSquares = widthOfMaze * widthOfMaze;

        maze = new Square[amountOfSquares];
        for (int i = 0; i < amountOfSquares; i++) {
            maze[i] = new Square(i, widthOfMaze);

        }
        //adds borders
        for (int i = 0; i < widthOfMaze; i++) {
            maze[i].setUpperSide(TypesOfSides.getBORDER());
            maze[amountOfSquares - i - 1].setLowerSide(TypesOfSides.getBORDER());
            maze[i * widthOfMaze].setLeftSide(TypesOfSides.getBORDER());
            maze[amountOfSquares - i * widthOfMaze - 1].setRightSide(TypesOfSides.getBORDER());
        }

    }

    private static void createMoreHallways() {
        Random rand = new Random();
        for (int i = 0; i < amountOfSquares / 3;) {
            int randomSquare = rand.nextInt(amountOfSquares);
            int side = rand.nextInt(4);
            int sideToTheNextSquare = Sides.getTypeOfSide(side, maze[randomSquare]);
            int indexOfNextSquare = Sides.getIndexOfNextSquare(side, maze[randomSquare]);
            if (sideToTheNextSquare == TypesOfSides.getWALL()) {
                Sides.setAsHallway(side, maze[randomSquare], maze[indexOfNextSquare]);
                i++;
            }
        }
    }

    private static void createSpanningTree() {

        UnionFind tree = new UnionFind(amountOfSquares);
        Random rand = new Random();
        while (!tree.connectedTree()) {

            int randomSquare = rand.nextInt(amountOfSquares);
            int side = rand.nextInt(4);
            int sideToTheNextSquare = Sides.getTypeOfSide(side, maze[randomSquare]);
            int indexOfNextSquare = Sides.getIndexOfNextSquare(side, maze[randomSquare]);
            if (sideToTheNextSquare == TypesOfSides.getWALL()
                    && tree.find(randomSquare) != tree.find(indexOfNextSquare)) {
                Sides.setAsHallway(side, maze[randomSquare], maze[indexOfNextSquare]);
                tree.union(tree.find(randomSquare), tree.find(indexOfNextSquare));
            }
        }
    }
}
