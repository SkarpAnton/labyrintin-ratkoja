package maze.userinterface;

import java.awt.*;
import maze.controller.AlgorithmRunnerAndEvaluator;
import maze.datastructures.MazeSize;
import maze.datastructures.Room;
import maze.datastructures.TypesOfSides;

/**
 * Used to draw the maze
 */
public class Drawer {

    private final MazeSize sizes;
    private final Room[] maze;
    private final int start;
    private final int destination;

    /**

     * @param start index of the room where the searches were started
     * @param destination index of the room that the algorithms looked for
     */
    public Drawer(MazeSize sizes, int start, int destination) {
        this.sizes = sizes;
        this.start = start;
        this.destination = destination;
        AlgorithmRunnerAndEvaluator runnerAndEvaluator = new AlgorithmRunnerAndEvaluator(sizes,
                start, destination);
        maze = runnerAndEvaluator.runAndEvaluateAlgorithms();

    }

    /**
     * Draws walls of the maze. Walls are white lines at the edge of the room. 
     * Walls are drawn based on the rooms sides type.
     */
    public void drawWalls(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        int indexOfRoom = 0;
        for (int j = 0; j < sizes.getMazeWidth(); j++) {
            for (int i = 0; i < sizes.getMazeWidth(); i++, indexOfRoom++) {
                drawUpperWall(graphics, i, j, indexOfRoom);
                drawLowerWall(graphics, i, j, indexOfRoom);
                drawLeftWall(graphics, i, j, indexOfRoom);
                drawRightWall(graphics, i, j, indexOfRoom);
            }
        }
    }
    
  
    private void drawLowerWall(Graphics graphics, int x, int y, int indexOfRoom) {
        if (maze[indexOfRoom].getLeftSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine(x * sizes.getRoomWidth(), y * sizes.getRoomWidth(),
                    x * sizes.getRoomWidth(), (y + 1) * sizes.getRoomWidth());
        }
    }

    private void drawUpperWall(Graphics graphics, int x, int y, int indexOfRoom) {
        if (maze[indexOfRoom].getUpperSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine(x * sizes.getRoomWidth(), y * sizes.getRoomWidth(),
                    (x + 1) * sizes.getRoomWidth(), y * sizes.getRoomWidth());
        }
    }

    private void drawLeftWall(Graphics graphics, int x, int y, int indexOfRoom) {
        if (maze[indexOfRoom].getLowerSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine(x * sizes.getRoomWidth(), (y + 1) * sizes.getRoomWidth(),
                    (x + 1) * sizes.getRoomWidth(), (y + 1) * sizes.getRoomWidth());
        }
    }

    private void drawRightWall(Graphics graphics, int x, int y, int indexOfRoom) {
        if (maze[indexOfRoom].getRightSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine((x + 1) * sizes.getRoomWidth(), y * sizes.getRoomWidth(),
                    (x + 1) * sizes.getRoomWidth(), (y + 1) * sizes.getRoomWidth());
        }
    }

    /**
     * Adds marks to rooms that are part of the path from start to destination that A* and BFS found. 
     * Path is drawn with color green. Starting
     * room is colored with color blue and destination with color red.
     */
    public void drawPaths(Graphics graphics) {
        drawPath(graphics, true);
        drawPath(graphics, false);
        graphics.setColor(Color.BLUE);
        addMarkPath(graphics, start);
        graphics.setColor(Color.RED);
        addMarkPath(graphics, destination);
    }

    private void drawPath(Graphics graphics, Boolean isBfs) {
        graphics.setColor(Color.GREEN);
        int next = destination;
        while (next != start) {
            addMarkPath(graphics, next);
            Room room = maze[next];
            if (isBfs) {
                next = room.getBfsPrevious();
            } else {
                next = room.getAStarPrevious();
            }
            
        }
    }


    private void addMarkPath(Graphics graphics, int index) {
        graphics.fillRect(index % sizes.getMazeWidth() * sizes.getRoomWidth() + sizes.getRoomWidth() / 4,
                index / sizes.getMazeWidth() * sizes.getRoomWidth() + sizes.getRoomWidth() / 4,
                sizes.getWidthOfPathMark(), sizes.getWidthOfPathMark());
    }

    /**
     * Adds colored marks to rooms that A* and BFS visited. 
     * Rooms that A* only visited is colored cyan,
     * rooms that BFS only visited is colored magenta and if both algorithms
     * visited a room it is colored orange.
     */
    public void drawVisited(Graphics graphics) {
        int notVisited = -1;
        for (int i = 0; i < sizes.getAmountOfRooms(); i++) {
            graphics.setColor(Color.CYAN);
            if (maze[i].getAStarPrevious() != notVisited) {
                addMarkVisited(graphics, i);
            }
            graphics.setColor(Color.MAGENTA);
            if (maze[i].getBfsPrevious() != notVisited) {
                addMarkVisited(graphics, i);
            }
            graphics.setColor(Color.ORANGE);
            if (maze[i].getAStarPrevious() != notVisited
                    && maze[i].getBfsPrevious() != notVisited) {
                addMarkVisited(graphics, i);
            }
        }
    }

    private void addMarkVisited(Graphics graphics, int index) {
        graphics.fillRect(index % sizes.getMazeWidth() * sizes.getRoomWidth() + sizes.getRoomWidth() / 2,
                index / sizes.getMazeWidth() * sizes.getRoomWidth() + sizes.getRoomWidth() / 2,
                sizes.getRoomWidth() / 10 + 1, sizes.getRoomWidth() / 10 + 1);
    }

}
