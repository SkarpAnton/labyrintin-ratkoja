package maze.controller;

import maze.datastructures.MazeSize;
import maze.userinterface.Input;
import maze.userinterface.Printer;



public class Main {

    public static void main(String[] args) {
        MazeSize sizes = Input.getMazeSizes(args);
        Printer.printMaze(sizes);       
    }
}
