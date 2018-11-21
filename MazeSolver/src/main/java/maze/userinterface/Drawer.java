package maze.userinterface;

import java.awt.*;
import maze.datastructures.MazeSize;
import maze.algorithms.RandomKruskal;
import maze.algorithms.SearchAlgorithms;
import maze.datastructures.Square;
import maze.datastructures.TypesOfSquares;

public class Drawer {

    private final MazeSize sizes;
    private final Square[] maze;

    public Drawer(MazeSize sizes, int start, int destination) {
        this.sizes = sizes;
        maze = RandomKruskal.createMaze(sizes.getMazeWidth());
        SearchAlgorithms.aStar(start, destination, maze, sizes.getMazeWidth());
        SearchAlgorithms.breadthFirstSearch(start, destination, maze, sizes.getMazeWidth());
    }

    public void piirraLabyrintti(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        int indexOfSquare = 0;
        for (int j = 0; j < sizes.getMazeWidth(); j++) {
            for (int i = 0; i < sizes.getMazeWidth(); i++, indexOfSquare++) {
                drawUpperBorder(graphics, i, j, indexOfSquare);
                drawLowerBorder(graphics, i, j, indexOfSquare);
                drawLeftBorder(graphics, i, j, indexOfSquare);
                drawRightBorder(graphics, i, j, indexOfSquare);
            }
        }
    }

    private void drawLowerBorder(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getLeft() != TypesOfSquares.getHALLWAY()) {
            graphics.drawLine(x * sizes.getSquareWidth(), y * sizes.getSquareWidth(),
                    x * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth());
        }
    }

    private void drawUpperBorder(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getUpper() != TypesOfSquares.getHALLWAY()) {
            graphics.drawLine(x * sizes.getSquareWidth(), y * sizes.getSquareWidth(),
                    (x + 1) * sizes.getSquareWidth(), y * sizes.getSquareWidth());
        }
    }

    private void drawLeftBorder(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getLower() != TypesOfSquares.getHALLWAY()) {
            graphics.drawLine(x * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth(),
                    (x + 1) * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth());
        }
    }

    private void drawRightBorder(Graphics graphics, int x, int y, int indexOfSquare) {
        if (maze[indexOfSquare].getRight() != TypesOfSquares.getHALLWAY()) {
            graphics.drawLine((x + 1) * sizes.getSquareWidth(), y * sizes.getSquareWidth(),
                    (x + 1) * sizes.getSquareWidth(), (y + 1) * sizes.getSquareWidth());
        }
    }

    public void drawPaths(Graphics graphics, int start, int destination) {
        drawAstarsPath(graphics, start, destination);
        drawBfsPath(graphics, start, destination);
        graphics.setColor(Color.RED);
        addMarkPath(graphics, start);
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

    private void addMarkVisited(Graphics graphics, int index) {
        graphics.fillRect(index % sizes.getMazeWidth() * sizes.getSquareWidth() + sizes.getSquareWidth() / 2,
                index / sizes.getMazeWidth() * sizes.getSquareWidth() + sizes.getSquareWidth() / 2,
                sizes.getSquareWidth() / 10 + 1, sizes.getSquareWidth() / 10 + 1);
    }

    public void drawVisited(Graphics graphics) {
        int indexOfSquare = 0;
        for (int j = 0; j < sizes.getMazeWidth(); j++) {
            for (int i = 0; i < sizes.getMazeWidth(); i++, indexOfSquare++) {
                graphics.setColor(Color.CYAN);
                if (maze[indexOfSquare].getAStarPrevious() != -1) {
                    addMarkVisited(graphics, indexOfSquare);
                }
                graphics.setColor(Color.MAGENTA);
                if (maze[indexOfSquare].getBfsPrevious() != -1) {
                    addMarkVisited(graphics, indexOfSquare);
                }
                graphics.setColor(Color.ORANGE);
                if (maze[indexOfSquare].getAStarPrevious() != -1
                        && maze[indexOfSquare].getBfsPrevious() != -1) {
                    addMarkVisited(graphics, indexOfSquare);
                }
            }
        }
    }

}
