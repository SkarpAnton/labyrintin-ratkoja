
package labyrintti;


import java.awt.*;

public class LabyrintinPiirto {

    private int ruudunKoko;
    private int kaytava = -2;
    private int koko;
    
    private Ruutu[] ruudut;
    

    public LabyrintinPiirto(int koko) {
        this.koko = koko;
        ruudunKoko = 20 / (koko / 10) + 4;
        ruudut = RandomizedKruskal.luoLabyrintti(koko);
        ruudut = LabyrintinMuokkaus.kaytavienLisays(ruudut, koko);
    }
    

    public void piirraLabyrintti(Graphics grafiikka) {
        grafiikka.setColor(Color.WHITE);
        for (int j = 0; j < koko; j++) {
            int ruudunIndeksi = j * koko;
            for (int i = 0; i < koko; i++) {
                
                if (ruudut[ruudunIndeksi].sivut[Suunnat.vasen] != kaytava) {
                    grafiikka.drawLine(i * ruudunKoko, j * ruudunKoko, 
                            i * ruudunKoko, (j + 1) * ruudunKoko);
                }
                
                if (ruudut[ruudunIndeksi].sivut[Suunnat.ylos] != kaytava) {
                    grafiikka.drawLine(i * ruudunKoko, j * ruudunKoko,
                            (i + 1) * ruudunKoko, j * ruudunKoko);
                }

                if (ruudut[ruudunIndeksi].sivut[Suunnat.alas] != kaytava) {
                    grafiikka.drawLine(i * ruudunKoko, (j + 1) * ruudunKoko,
                            (i + 1) * ruudunKoko, (j + 1) * ruudunKoko);
                }

                if (ruudut[ruudunIndeksi].sivut[Suunnat.oikea] != kaytava) {
                    grafiikka.drawLine((i + 1) * ruudunKoko, j * ruudunKoko,
                            (i + 1) * ruudunKoko, (j + 1) * ruudunKoko);
                }

                
                ruudunIndeksi++;
            }
        }
    }

}
