package labyrintti;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Paneeli extends JPanel {

    private final Piirto piirto;
    private final int alku;
    private final int maaranPaa;

    public Paneeli(Piirto piirto, int alku, int maaranPaa) {
        this.piirto = piirto;
        this.alku = alku;
        this.maaranPaa = maaranPaa;
    }

    @Override
    public void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);
        setBackground(Color.BLACK); 
        piirto.piirraLabyrintti(grafiikka);
        piirto.piirraPolut(grafiikka, alku, maaranPaa);
    }
}
