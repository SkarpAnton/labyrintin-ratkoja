
package maze.controller;

import maze.algorithms.RandomKruskal;
import maze.algorithms.SearchAlgorithms;
import maze.datastructures.MazeSize;
import maze.datastructures.Square;

public class AlgorithmRunnerAndEvaluator {
    
    private Square[] maze;
    private final MazeSize sizes;
    private final int start;
    private final int destination;

    public AlgorithmRunnerAndEvaluator(MazeSize sizes, int start, int destination) {
        this.sizes = sizes;
        this.start = start;
        this.destination = destination;
    }

    
    public Square[] runAndEvaluateAlgorithms() {
        runAndEvaluateRandomKruskal();
        runAndEvaluateAStar();
        runAndEvaluateBfs();
        return maze;
    }
    
    private void runAndEvaluateRandomKruskal() {
        long startTime = System.nanoTime();
        maze = RandomKruskal.createMaze(sizes.getMazeWidth());
        long endTime = System.nanoTime();
        System.out.println("Labyrintin luominen vie : " + (endTime - startTime) / 1000000000.0 + "s");
    }
    
    private void runAndEvaluateAStar() {
        long startTime = System.nanoTime();
        SearchAlgorithms.aStar(start, destination, maze, sizes.getMazeWidth());
        long endTime = System.nanoTime();
        System.out.println("AStar vie : " + (endTime - startTime) / 1000000000.0 + "s");
    }
    
    private void runAndEvaluateBfs() {
        long startTime = System.nanoTime();
        SearchAlgorithms.breadthFirstSearch(start, destination, maze, sizes.getMazeWidth());
        long endTime = System.nanoTime();
        System.out.println("Leveyshaku vie : " + (endTime - startTime) / 1000000000.0 + "s");
    }
}
