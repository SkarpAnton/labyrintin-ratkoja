
package labyrintti;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GUI {

    public static void tulostaLabyrintti(int koko) {

        LabyrintinPiirto labyrintti = new LabyrintinPiirto(koko);
        JFrame frame = new JFrame("Labyrintti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(koko * 15, koko * 15);
        JScrollPane scrollPane = new JScrollPane(new LabyrinttiPaneeli(labyrintti));
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
