package maze.userinterface;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import maze.datastructures.MazeSize;
import maze.datastructures.RandomStartAndDestination;

public class Printer {

    private Printer() {
    }

    public static void printMaze(MazeSize sizes) {
        
        RandomStartAndDestination startAndDestination
                = new RandomStartAndDestination(sizes.getMazeWidth());
        Drawer drawer = new Drawer(sizes, startAndDestination.getStart(),
                startAndDestination.getDestination());
        JFrame frame = new JFrame("maze");
        frame.setSize(sizes.getFrameWidth() + 20, sizes.getFrameWidth() + 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel maze = new Panel(drawer, startAndDestination.getStart(),
                startAndDestination.getDestination());
        JScrollPane scrollPane = new JScrollPane(maze);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setVisible(true);
    } 
}
