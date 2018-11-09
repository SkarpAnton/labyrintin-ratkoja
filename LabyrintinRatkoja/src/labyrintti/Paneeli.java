package labyrintti;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Paneeli extends JPanel {

    private Piirto labyrintti;

    public Paneeli(Piirto labyrintti) {
        this.labyrintti = labyrintti;
    }

    public void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);
        setBackground(Color.BLACK); 
        labyrintti.piirraLabyrintti(grafiikka);
    }
}
