
package maze.controller;

import maze.algorithms.RandomKruskal;
import maze.algorithms.SearchAlgorithms;
import maze.datastructures.MazeSize;
import maze.datastructures.Room;

public class AlgorithmRunnerAndEvaluator {
    
    private Room[] maze;
    private final MazeSize sizes;
    private final int start;
    private final int destination;

    /**
     *
     * @param start index of the room where the searches are started
     * @param destination index of the room that the algorithms are looking for
     */
    public AlgorithmRunnerAndEvaluator(MazeSize sizes, int start, int destination) {
        this.sizes = sizes;
        this.start = start;
        this.destination = destination;
    }

    /**
     * Runs and times the maze creation by randomized Kruskal, also runs and times
     * shortest path finding by BFS and A*.
     * @return the created maze
     */
    public Room[] runAndEvaluateAlgorithms() {
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
