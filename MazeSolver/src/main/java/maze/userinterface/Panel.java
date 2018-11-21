package maze.userinterface;

import maze.userinterface.Drawer;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Panel extends JPanel {

    private final Drawer drawer;
    private final int start;
    private final int destination;

    public Panel(Drawer drawer, int start, int destination) {
        this.drawer = drawer;
        this.start = start;
        this.destination = destination;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setBackground(Color.BLACK);
        drawer.piirraLabyrintti(graphics);
        drawer.drawPaths(graphics, start, destination);
        drawer.drawVisited(graphics);
    }
}
