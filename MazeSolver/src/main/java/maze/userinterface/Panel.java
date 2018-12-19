package maze.userinterface;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Panel extends JPanel {

    private final Drawer drawer;

    public Panel(Drawer drawer) {
        this.drawer = drawer;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setBackground(Color.BLACK);
        drawer.drawWalls(graphics);
        drawer.drawPaths(graphics);
        drawer.drawVisited(graphics);
    }
}
