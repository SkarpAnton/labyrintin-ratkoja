package maze.controller;

import maze.datastructures.MazeSize;
import maze.userinterface.Input;
import maze.userinterface.Printer;



public class Main {

    public static void main(String[] args) {
        int mazeWidth = Input.getWidthOfMaze();
        MazeSize sizes = new MazeSize(mazeWidth);
        Printer.printMaze(sizes);
        
    }
}
