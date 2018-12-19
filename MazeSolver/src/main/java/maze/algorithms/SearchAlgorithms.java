package maze.algorithms;

import maze.datastructures.TypesOfSides;
import maze.datastructures.Room;
import maze.datastructures.ObjectForHeap;
import maze.datastructures.Queue;
import maze.datastructures.Heap;
import maze.datastructures.Sides;

public class SearchAlgorithms {
    

    private static Queue queue;
    private static Heap minHeap;
    
    private SearchAlgorithms() {};
    
    /**
     * Uses breadth-first search to find the shortest path between starting
     * room and the destination room. 
     * <a href="https://en.wikipedia.org/wiki/Breadth-first_search">
     * BFS wikipedia
     * </a>
     * 
     * @param start index of the room where the search is started
     * @param destination index of the room that the algorithm is looking for
     * @param maze
     *          array of rooms
     * @param widthOfMaze 
     *          Labyrinth has mazeWidth x mazeWidth rooms, thus mazeWidth is the
     *          amount of rooms that this maze has on a row or column
     */
    public static void breadthFirstSearch(int start, int destination,
            Room[] maze, int widthOfMaze) {
        queue = new Queue(widthOfMaze * widthOfMaze);
        queue.add(start);
        while (true) {
            int current = queue.poll();
            if (current == destination) {
                break;
            }
            Room currentRoom = maze[current];
            for (int i = 0; i < 4; i++) {
                bfsCheckSide(currentRoom, maze, i);
            }
        }
    }
    
    
    
    private static void bfsCheckSide(Room currentRoom, Room[] maze, int side) {

        if (Sides.getTypeOfSide(side, currentRoom) == TypesOfSides.getHALLWAY()) {
            int next = Sides.getIndexOfNextRoom(side, currentRoom);
            Room nextRoom = maze[next];
            if (nextRoom.getBfsPrevious() == -1) {
                nextRoom.setBfsPrevious(currentRoom.getIndex());
                queue.add(next);
            }
        }
    }

    /**
     * <p> Uses A* algorithm to find the shortest path between starting
     * room and the destination room. ALgorithm uses as heuristic
     * the sum of the current distance and the
     * sum of differences between measured x and y from destinations x 
     * and y; for example, being measured: distance = 3, 
     * (x=1, y=3), destination: (x=5, y=1) ->  
     * heuristic 3 + (|5-1| + |1-3|) = 9. The heuristic never overestimates the 
     * distance and as such the algorithm always finds the shortest path. 
     * <a href="https://en.wikipedia.org/wiki/A*_search_algorithm">
     * A* wikipedia
     * </a>
     * </p>
     * @param start index of the room where the search is started
     * @param destination index of the room that the algorithm is looking for
     * @param maze
     *          array of rooms
     * @param widthOfMaze 
     *          Labyrinth has mazeWidth x mazeWidth rooms, thus mazeWidth is the
     *          amount of rooms that this maze has on a row or column
     */
    public static void aStar(int start, int destination, Room[] maze, int widthOfMaze) {
        minHeap = new Heap(widthOfMaze * widthOfMaze);
        int priority = relax(start, destination, widthOfMaze, 0);
        ObjectForHeap startingObject = new ObjectForHeap(start, priority, start, 0);
        minHeap.add(startingObject);

        while (true) {
            ObjectForHeap current = minHeap.poll();
            Room currentRoom = maze[current.getIndexOfRoom()];
            if (current.getPriority() > currentRoom.getBestPriority()) {
                continue;
            }
            currentRoom.setAStarPrevious(current.getPrevious());
            if (current.getIndexOfRoom() == destination) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                aStarCheckSide(current, currentRoom, widthOfMaze, maze, destination, i);
            }
        }
    }

    private static void aStarCheckSide(ObjectForHeap current, Room currentRoom,
            int widthOfMaze, Room[] maze, int destination, int side) {
        if (Sides.getTypeOfSide(side, currentRoom) == TypesOfSides.getHALLWAY()) {
            int next = Sides.getIndexOfNextRoom(side, currentRoom);
            Room nextRoom = maze[next];
            int priority = relax(next, destination, widthOfMaze, current.getDistance() + 1);
            if (nextRoom.getBestPriority() > priority) {
                nextRoom.setBestPriority(priority);
                ObjectForHeap nextObject = new ObjectForHeap(next, priority,
                        current.getIndexOfRoom(), current.getDistance() + 1);
                minHeap.add(nextObject);
            }
        }
    }

    private static int relax(int current, int destination, int widthOfMaze, int distance) {
        int xDiff = Math.abs(destination % widthOfMaze - current % widthOfMaze);
        int yDiff = Math.abs(destination / widthOfMaze - current / widthOfMaze);
        return xDiff + yDiff + distance;
    }
}
