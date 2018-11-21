package maze.userinterface;

import java.util.Scanner;

public class Input {

    private Input() {
    }

    public static int getWidthOfMaze() {
        Scanner in = new Scanner(System.in);
        int widthOfMaze;
        while (true) {
            try {
                System.out.println("Labyrintin leveys täytyy olla viittä suurempi kokonaisluku.");
                System.out.print("Kuinka leveä labyrintti on: ");
                widthOfMaze = Integer.parseInt(in.next());
                if (widthOfMaze < 6) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Syötettu luku ei ole viittä suurempi kokonaisluku.");
            }

        }
        return widthOfMaze;
    }

}
