package maze.controller;

import maze.datastructures.MazeSize;
import maze.userinterface.Input;
import maze.userinterface.Printer;

/**
 * The main class of the program
 */
public class Main {

    /**
     * the main method of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        MazeSize sizes = Input.getMazeSizes(args);
        Printer.printMaze(sizes);       
    }
}
