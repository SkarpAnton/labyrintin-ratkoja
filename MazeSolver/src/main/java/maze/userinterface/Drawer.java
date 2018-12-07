package maze.userinterface;

import java.awt.*;
import maze.controller.AlgorithmRunnerAndEvaluator;
import maze.datastructures.MazeSize;
import maze.datastructures.Room;
import maze.datastructures.TypesOfSides;

public class Drawer {

    private final MazeSize sizes;
    private final Room[] maze;

    public Drawer(MazeSize sizes, int start, int destination) {
        this.sizes = sizes;
        AlgorithmRunnerAndEvaluator runnerAndEvaluator = new AlgorithmRunnerAndEvaluator(sizes,
                start, destination);
        maze = runnerAndEvaluator.runAndEvaluateAlgorithms();

    }

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
    
    /*
    TODO
    There is a lot of repetition here, should think of a better way to write this 
    */
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

    public void drawPaths(Graphics graphics, int start, int destination) {
        drawAstarsPath(graphics, start, destination);
        drawBfsPath(graphics, start, destination);
        graphics.setColor(Color.BLUE);
        addMarkPath(graphics, start);
        graphics.setColor(Color.RED);
        addMarkPath(graphics, destination);
    }

    private void drawAstarsPath(Graphics graphics, int start, int destination) {
        graphics.setColor(Color.GREEN);
        int next = destination;
        while (next != start) {
            addMarkPath(graphics, next);
            Room room = maze[next];
            next = room.getAStarPrevious();
        }
    }

    private void drawBfsPath(Graphics graphics, int start, int destination) {
        graphics.setColor(Color.GREEN);
        int next = destination;
        while (next != start) {
            addMarkPath(graphics, next);
            Room room = maze[next];
            next = room.getBfsPrevious();
        }
    }

    private void addMarkPath(Graphics graphics, int index) {
        graphics.fillRect(index % sizes.getMazeWidth() * sizes.getRoomWidth() + sizes.getRoomWidth() / 4,
                index / sizes.getMazeWidth() * sizes.getRoomWidth() + sizes.getRoomWidth() / 4,
                sizes.getWidthOfPathMark(), sizes.getWidthOfPathMark());
    }

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
