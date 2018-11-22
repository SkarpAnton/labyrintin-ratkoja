package maze.algorithms;

import maze.datastructures.TypesOfSides;
import maze.datastructures.Square;
import maze.datastructures.ObjectForHeap;
import maze.datastructures.Queue;
import maze.datastructures.Heap;
import maze.datastructures.Sides;

public class SearchAlgorithms {

    private static Queue queue;
    private static Heap minHeap;

    public static void breadthFirstSearch(int start, int destination,
            Square[] maze, int widthOfMaze) {
        queue = new Queue(widthOfMaze * widthOfMaze);
        queue.add(start);
        while (true) {
            int current = queue.poll();
            if (current == destination) {
                break;
            }
            Square currentSquare = maze[current];
            for (int i = 0; i < 4; i++) {
                bfsCheckSide(currentSquare, maze, i);
            }
        }
    }

    private static void bfsCheckSide(Square currentSquare, Square[] maze, int side) {

        if (Sides.getTypeOfSide(side, currentSquare) == TypesOfSides.getHALLWAY()) {
            int next = Sides.getIndexOfSide(side, currentSquare);
            Square nextSquare = maze[next];
            if (nextSquare.getBfsPrevious() == -1) {
                nextSquare.setBfsPrevious(currentSquare.getIndex());
                queue.add(next);
            }
        }
    }

    public static void aStar(int start, int destination, Square[] maze, int widthOfMaze) {
        minHeap = new Heap(widthOfMaze * widthOfMaze);
        int priority = relax(start, destination, widthOfMaze, 0);
        ObjectForHeap startingObject = new ObjectForHeap(start, priority, start, 0);
        minHeap.add(startingObject);

        while (true) {
            ObjectForHeap current = minHeap.poll();
            Square currentSquare = maze[current.getIndexOfSquare()];
            if (current.getPriority() > currentSquare.getBestPriority()) {
                continue;
            }
            currentSquare.setAStarPrevious(current.getPrevious());
            if (current.getIndexOfSquare() == destination) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                aStarCheckSide(current, currentSquare, widthOfMaze, maze, destination, i);
            }
        }
    }

    private static void aStarCheckSide(ObjectForHeap current, Square currentSquare,
            int widthOfMaze, Square[] maze, int destination, int side) {
        if (Sides.getTypeOfSide(side, currentSquare) == TypesOfSides.getHALLWAY()) {
            int next = Sides.getIndexOfSide(side, currentSquare);
            Square nextSquare = maze[next];
            int priority = relax(next, destination, widthOfMaze, current.getDistance() + 1);
            if (nextSquare.getBestPriority() > priority) {
                nextSquare.setBestPriority(priority);
                ObjectForHeap nextObject = new ObjectForHeap(next, priority,
                        current.getIndexOfSquare(), current.getDistance() + 1);
                minHeap.add(nextObject);
            }
        }
    }

    public static int relax(int current, int destination, int widthOfMaze, int distance) {
        int xDiff = Math.abs(destination % widthOfMaze - current % widthOfMaze);
        int yDiff = Math.abs(destination / widthOfMaze - current / widthOfMaze);
        return xDiff + yDiff + distance;
    }
}
