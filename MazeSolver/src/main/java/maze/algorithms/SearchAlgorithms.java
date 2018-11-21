package maze.algorithms;

import maze.datastructures.TypesOfSquares;
import maze.datastructures.Square;
import maze.datastructures.SquareAndPriority;
import maze.datastructures.Queue;
import maze.datastructures.Heap;


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
            bfsCheckLower(current, currentSquare, maze, widthOfMaze);
            bfsCheckUpper(current, currentSquare, maze, widthOfMaze);
            bfsCheckLeft(current, currentSquare, maze);
            bfsCheckRight(current, currentSquare, maze);            
        }
    }
    
    private static void bfsCheckLower(int current, Square currentSquare, Square[] maze,
            int widthOfMaze) {
        if (currentSquare.getLower() == TypesOfSquares.getHALLWAY()) {
            int down = current + widthOfMaze;
            Square lowerSquare = maze[down];
            if (lowerSquare.getBfsPrevious() == -1) {
                lowerSquare.setBfsPrevious(current);
                queue.add(down);
            }
        }
    }
    private static void bfsCheckUpper(int current, Square currentSquare, Square[] maze,
            int widthOfMaze) {
        if (currentSquare.getUpper() == TypesOfSquares.getHALLWAY()) {
            int up = current - widthOfMaze;
            Square upperSquare = maze[up];
            if (upperSquare.getBfsPrevious() == -1) {
                upperSquare.setBfsPrevious(current);
                queue.add(up);
            }
        }
    }

    private static void bfsCheckLeft(int current, Square currentSquare, Square[] maze) {
        if (currentSquare.getLeft() == TypesOfSquares.getHALLWAY()) {
            int left = current - 1;
            Square leftSquare = maze[left];
            if (leftSquare.getBfsPrevious() == -1) {
                leftSquare.setBfsPrevious(current);
                queue.add(left);
            }
        }
    }
    
    private static void bfsCheckRight(int current, Square currentSquare, Square[] maze) {
        if (currentSquare.getRight() == TypesOfSquares.getHALLWAY()) {
            int right = current + 1;
            Square rightSquare = maze[right];
            if (rightSquare.getBfsPrevious() == -1) {
                rightSquare.setBfsPrevious(current);
                queue.add(right);
            }
        }
    }

    public static void aStar(int start, int destination, Square[] maze, int widthOfMaze) {
        minHeap = new Heap(widthOfMaze * widthOfMaze);
        int priority = relax(start, destination, widthOfMaze);
        SquareAndPriority startAndPriority = new SquareAndPriority(start, priority, start);
        minHeap.add(startAndPriority);
        while (true) {
            SquareAndPriority current = minHeap.poll();
            Square currentSquare = maze[current.getIndexOfSquare()];
            currentSquare.setAStarPrevious(current.getPrevious());
            if (current.getIndexOfSquare() == destination) {
                break;
            }
            aStarCheckUpper(current, currentSquare, widthOfMaze, maze, destination);
            aStarCheckLeft(current, currentSquare, widthOfMaze, maze, destination);
            aStarCheckLower(current, currentSquare, widthOfMaze, maze, destination);
            aStarCheckRight(current, currentSquare, widthOfMaze, maze, destination);
        }
    }

    private static void aStarCheckLower(SquareAndPriority current, Square currentSquare,
            int widthOfMaze, Square[] maze, int destination) {
        if (currentSquare.getLower() == TypesOfSquares.getHALLWAY()) {
            int down = current.getIndexOfSquare() + widthOfMaze;
            Square lowerSquare = maze[down];
            if (lowerSquare.getAStarPrevious() == -1) {
                int priority = relax(down, destination, widthOfMaze);
                SquareAndPriority lowerSquareAndPiority
                        = new SquareAndPriority(down, priority,
                                current.getIndexOfSquare());
                minHeap.add(lowerSquareAndPiority);
            }
        }
    }
    private static void aStarCheckUpper(SquareAndPriority current, Square currentSquare,
            int widthOfMaze, Square[] maze, int destination) {
        if (currentSquare.getUpper() == TypesOfSquares.getHALLWAY()) {
            int up = current.getIndexOfSquare() - widthOfMaze;
            Square upperSquare = maze[up];
            if (upperSquare.getAStarPrevious() == -1) {
                int priority = relax(up, destination, widthOfMaze);
                SquareAndPriority upperSquareAndPriority
                        = new SquareAndPriority(up, priority,
                                current.getIndexOfSquare());
                minHeap.add(upperSquareAndPriority);
            }
        }
    }
    private static void aStarCheckLeft(SquareAndPriority current, Square currentSquare,
            int widthOfMaze, Square[] maze, int destination) {
        if (currentSquare.getLeft() == TypesOfSquares.getHALLWAY()) {
            int left = current.getIndexOfSquare() - 1;
            Square leftSquare = maze[left];
            if (leftSquare.getAStarPrevious() == -1) {
                int priority = relax(left, destination, widthOfMaze);
                SquareAndPriority leftSquareAndPriority
                        = new SquareAndPriority(left, priority, current.getIndexOfSquare());
                minHeap.add(leftSquareAndPriority);
            }
        }
    }
    private static void aStarCheckRight(SquareAndPriority current, Square currentSquare,
            int widthOfMaze, Square[] maze, int destination) {

        if (currentSquare.getRight() == TypesOfSquares.getHALLWAY()) {
            int right = current.getIndexOfSquare() + 1;
            Square rightSquare = maze[right];
            if (rightSquare.getAStarPrevious() == -1) {
                int priority = relax(right, destination, widthOfMaze);
                SquareAndPriority rightSquareAndPriority
                        = new SquareAndPriority(right, priority, current.getIndexOfSquare());
                minHeap.add(rightSquareAndPriority);
            }
        }
    }

    public static int relax(int current, int destination, int widthOfMaze) {
        int xDiff = destination % widthOfMaze - current % widthOfMaze;
        int yDiff = destination / widthOfMaze - current / widthOfMaze;
        return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff) + 1;
    }
}
