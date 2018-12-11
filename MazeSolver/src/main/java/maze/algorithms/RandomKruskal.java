package maze.algorithms;

import maze.datastructures.TypesOfSides;
import maze.datastructures.Sides;
import maze.datastructures.Room;
import maze.datastructures.UnionFind;
import java.util.Random;

public class RandomKruskal {

    private static Room[] maze;
    private static int amountOfRooms;

    private RandomKruskal() {
    }

   
    /**
     * <p>Creates maze based on random Kruskal algorithm. Every new room has all 
     * its sides as walls. Kruskal is used to create hallways that connect 
     * every room by removing walls or equivalently adding hallways between rooms. 
     * After Kruskal creates a spanning tree of hallways some hallways are added to 
     * create more than one valid shortest path between rooms.
     * <a href="https://en.wikipedia.org/wiki/Maze_generation_algorithm"> 
     * Randomized Kruskal wikipedia
     * </a>
     * <p>
     * @param widthOfMaze
     * @return Room[]
     */
    public static Room[] createMaze(int widthOfMaze) {
        initialization(widthOfMaze);
        createSpanningTree();
        createMoreHallways();
        return maze;
    }

    private static void initialization(int widthOfMaze) {
        amountOfRooms = widthOfMaze * widthOfMaze;

        maze = new Room[amountOfRooms];
        for (int i = 0; i < amountOfRooms; i++) {
            maze[i] = new Room(i, widthOfMaze);

        }
        for (int i = 0; i < widthOfMaze; i++) {
            maze[i].setUpperSide(TypesOfSides.getBORDER());
            maze[amountOfRooms - i - 1].setLowerSide(TypesOfSides.getBORDER());
            maze[i * widthOfMaze].setLeftSide(TypesOfSides.getBORDER());
            maze[amountOfRooms - i * widthOfMaze - 1].setRightSide(TypesOfSides.getBORDER());
        }

    }

    private static void createMoreHallways() {
        Random rand = new Random();
        for (int i = 0; i < amountOfRooms / 5;) {
            int randomRoom = rand.nextInt(amountOfRooms);
            int side = rand.nextInt(4);
            int sideToTheNextRoom = Sides.getTypeOfSide(side, maze[randomRoom]);
            int indexOfNextRoom = Sides.getIndexOfNextRoom(side, maze[randomRoom]);
            if (sideToTheNextRoom == TypesOfSides.getWALL()) {
                Sides.setAsHallway(side, maze[randomRoom], maze[indexOfNextRoom]);
                i++;
            }
        }
    }

    private static void createSpanningTree() {

        UnionFind tree = new UnionFind(amountOfRooms);
        Random rand = new Random();
        while (!tree.connectedTree()) {

            int randomRoom = rand.nextInt(amountOfRooms);
            int side = rand.nextInt(4);
            int sideToTheNextRoom = Sides.getTypeOfSide(side, maze[randomRoom]);
            int indexOfNextRoom = Sides.getIndexOfNextRoom(side, maze[randomRoom]);
            if (sideToTheNextRoom == TypesOfSides.getWALL()
                    && tree.find(randomRoom) != tree.find(indexOfNextRoom)) {
                Sides.setAsHallway(side, maze[randomRoom], maze[indexOfNextRoom]);
                tree.union(tree.find(randomRoom), tree.find(indexOfNextRoom));
            }
        }
    }
}
