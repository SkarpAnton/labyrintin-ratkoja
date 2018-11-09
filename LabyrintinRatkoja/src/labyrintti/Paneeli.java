package labyrintti;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Paneeli extends JPanel {

    private Piirto piirto;

    public Paneeli(Piirto piirto) {
        this.piirto = piirto;
    }

    public void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);
        setBackground(Color.BLACK); 
        piirto.piirraLabyrintti(grafiikka);
    }
}
