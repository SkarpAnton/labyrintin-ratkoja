package maze.userinterface;

import java.util.Scanner;
import maze.datastructures.MazeSize;

public class Input {
    
    private static int widthOfMaze;
    private static int widthOfFrame;
    private static Scanner in;
    private Input() {
    }
    
    /**
     * Gets maze sizes from user input. User inputs mazes width in rooms and 
     * the with of the picture in pixels
     * @param args parameters that were given in the command line to the program
     * @return sizes about the maze
     */
    public static MazeSize getMazeSizes(String[] args) {
        in = new Scanner(System.in);
        return new MazeSize(getWidthOfMaze(args), getWidthOfFrame(args));
    }
    
    

    private static int getWidthOfMaze(String[] args) {
        if (widthOfMazeFromCommandLine(args)) {
            return widthOfMaze;
        }
        widthOfMazeFromSTDInput();
        return widthOfMaze;
    }
    
    private static int getWidthOfFrame(String[] args) {
        if (widthOfFrameFromCommandLine(args)) {
            return widthOfFrame;
        }
        widthOfFrameFromSTDInput();
        return widthOfFrame;
        
    }
    
    private static Boolean widthOfMazeFromCommandLine(String[] args) {
        if (args.length >= 1) {
            try {
                widthOfMaze = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (widthOfMaze > 5) {
                return true;
            }
        }
        return false;
    }
    
    private static void widthOfMazeFromSTDInput() {
        
        while (true) {
            try {
                System.out.println("Labyrintin leveys täytyy olla viittä suurempi kokonaisluku.");
                System.out.print("Kuinka leveä labyrintti on: ");
                widthOfMaze = Integer.parseInt(in.next());
                if (widthOfMaze <= 5) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Syötettu luku ei ole viittä suurempi kokonaisluku.");
            }

        }
    }
    private static boolean widthOfFrameFromCommandLine(String[] args) {
        if (args.length == 2) {
            try {
                widthOfFrame = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (widthOfFrame > 100) {
                return true;
            }
        }
        return false;
    }

    private static void widthOfFrameFromSTDInput() {

        while (true) {
            try {
                System.out.println("Kuvan leveys täytyy olla sataa suurempi kokonaisluku.");
                System.out.print("Kuinka leveä kuva on: ");
                widthOfFrame = Integer.parseInt(in.next());
                if (widthOfFrame < 100) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Syötettu luku ei ole sataa suurempi kokonaisluku.");
            }

        }
    }
}


