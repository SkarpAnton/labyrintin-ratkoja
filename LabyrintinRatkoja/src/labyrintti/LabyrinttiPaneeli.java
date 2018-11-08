package labyrintti;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class LabyrinttiPaneeli extends JPanel {

    private LabyrintinPiirto labyrintti;

    public LabyrinttiPaneeli(LabyrintinPiirto labyrintti) {
        this.labyrintti = labyrintti;
    }

    public void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);
        setBackground(Color.BLACK); 
        labyrintti.piirraLabyrintti(grafiikka);
    }
}
