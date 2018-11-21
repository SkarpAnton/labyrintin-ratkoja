package maze.userinterface;

import maze.datastructures.MazeSize;


public class Main {

    public static void main(String[] args) {
        int mazeWidth = Input.getWidthOfMaze();
        MazeSize sizes = new MazeSize(mazeWidth);
        Printer.printMaze(sizes);
    }
}
