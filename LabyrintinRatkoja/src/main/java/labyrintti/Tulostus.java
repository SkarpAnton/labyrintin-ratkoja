
package labyrintti;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Tulostus {
    
    private Tulostus() {}
    
    public static void tulostaLabyrintti(int ruutujenMaaraSivulla,
            int ruudunLeveys, int sivunLeveys) {

        Piirto labyrintti = new Piirto(ruutujenMaaraSivulla, ruudunLeveys, 5, 50);
        JFrame frame = new JFrame("Labyrintti");
        frame.setSize(sivunLeveys + 20, sivunLeveys + 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(new Paneeli(labyrintti, 5 , 50));
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
