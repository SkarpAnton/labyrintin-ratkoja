
package labyrintti;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Tulostus {

    public static void tulostaLabyrintti(int koko) {

        Piirto labyrintti = new Piirto(koko);
        JFrame frame = new JFrame("Labyrintti");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(new Paneeli(labyrintti));
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
