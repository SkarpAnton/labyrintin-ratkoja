package maze.userinterface;

import java.awt.*;
import maze.controller.AlgorithmRunnerEvaluator;
import maze.datastructures.MazeSize;
import maze.datastructures.Square;
import maze.datastructures.TypesOfSides;

public class Drawer {

    private final MazeSize sizes;
    private final Square[] maze;

    public Drawer(MazeSize sizes, int start, int destination) {
        this.sizes = sizes;
        AlgorithmRunnerEvaluator runnerAndEvaluator = new AlgorithmRunnerEvaluator(sizes,
                start, destination);
        maze = runnerAndEvaluator.runAndEvaluateAlgorithms();

    }

    public void drawWalls(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        int indexOfSquare = 0;
        for (int j = 0; j < sizes.getMazeWidth(); j++) {
            for (int i = 0; i < sizes.getMazeWidth(); i++, indexOfSquare++) {
                drawUpperWall(graphics, i, j, indexOfSquare);
                drawLowerWall(graphics, i, j, indexOfSquare);
                drawLeftWall(graphics, i, j, indexOfSquare);
                drawRightWall(graphics, i, j, indexOfSquare);
            }
        }
    }

    private void drawLowerWall(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getLeftSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine(x * sizes.getSquareWidth(), y * sizes.getSquareWidth(),
                    x * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth());
        }
    }

    private void drawUpperWall(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getUpperSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine(x * sizes.getSquareWidth(), y * sizes.getSquareWidth(),
                    (x + 1) * sizes.getSquareWidth(), y * sizes.getSquareWidth());
        }
    }

    private void drawLeftWall(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getLowerSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine(x * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth(),
                    (x + 1) * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth());
        }
    }

    private void drawRightWall(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getRightSide() != TypesOfSides.getHALLWAY()) {
            graphics.drawLine((x + 1) * sizes.getSquareWidth(), y * sizes.getSquareWidth(),
                    (x + 1) * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth());
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
        graphics.setColor(Color.RED);
        int next = destination;
        while (next != start) {
            addMarkPath(graphics, next);
            Square square = maze[next];
            next = square.getAStarPrevious();
        }
    }

    private void drawBfsPath(Graphics graphics, int start, int destination) {
        graphics.setColor(Color.GREEN);
        int next = destination;
        while (next != start) {
            addMarkPath(graphics, next);
            Square square = maze[next];
            next = square.getBfsPrevious();
        }
    }

    private void addMarkPath(Graphics graphics, int index) {
        graphics.fillRect(index % sizes.getMazeWidth() * sizes.getSquareWidth() + sizes.getSquareWidth() / 4,
                index / sizes.getMazeWidth() * sizes.getSquareWidth() + sizes.getSquareWidth() / 4,
                sizes.getWidthOfPathMark(), sizes.getWidthOfPathMark());
    }

    public void drawVisited(Graphics graphics) {
        
        int notVisited = -1;
        for (int j = 0, indexOfSquare = 0; j < sizes.getMazeWidth(); j++) {
            for (int i = 0; i < sizes.getMazeWidth(); i++, indexOfSquare++) {
                graphics.setColor(Color.CYAN);
                if (maze[indexOfSquare].getAStarPrevious() != notVisited) {
                    addMarkVisited(graphics, indexOfSquare);
                }
                graphics.setColor(Color.MAGENTA);
                if (maze[indexOfSquare].getBfsPrevious() != notVisited) {
                    addMarkVisited(graphics, indexOfSquare);
                }
                graphics.setColor(Color.ORANGE);
                if (maze[indexOfSquare].getAStarPrevious() != notVisited
                        && maze[indexOfSquare].getBfsPrevious() != notVisited) {
                    addMarkVisited(graphics, indexOfSquare);
                }
            }
        }
    }

    private void addMarkVisited(Graphics graphics, int index) {
        graphics.fillRect(index % sizes.getMazeWidth() * sizes.getSquareWidth() + sizes.getSquareWidth() / 2,
                index / sizes.getMazeWidth() * sizes.getSquareWidth() + sizes.getSquareWidth() / 2,
                sizes.getSquareWidth() / 10 + 1, sizes.getSquareWidth() / 10 + 1);
    }

}
