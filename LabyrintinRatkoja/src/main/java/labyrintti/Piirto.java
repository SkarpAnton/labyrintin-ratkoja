
package labyrintti;


import java.awt.*;

public class Piirto {

    private final int ruudunKoko;
    private final int kaytava = -2;
    private final int merkinKoko;
    private final int ruutujenMaaraSivulla;
    private Ruutu[] labyrintti;
    

    public Piirto(int ruutujenMaaraSivulla, int ruudunKoko, int alku, int maaranpaa) {
        this.ruutujenMaaraSivulla = ruutujenMaaraSivulla;
        this.ruudunKoko = ruudunKoko;
        merkinKoko = ruudunKoko / 4 + 1;
        labyrintti = SatunnainenKruskal.luoLabyrintti(ruutujenMaaraSivulla);
        HakuAlgoritmit.AStar(alku, maaranpaa, labyrintti, ruutujenMaaraSivulla);
    }
    

    public void piirraLabyrintti(Graphics grafiikka) {
        grafiikka.setColor(Color.WHITE);
        int ruudunIndeksi = 0;
        for (int j = 0; j < ruutujenMaaraSivulla; j++) {
            for (int i = 0; i < ruutujenMaaraSivulla; i++, ruudunIndeksi ++) {
                if (labyrintti[ruudunIndeksi].getVasen() != kaytava) {
                    grafiikka.drawLine(i * ruudunKoko, j * ruudunKoko, 
                            i * ruudunKoko, (j + 1) * ruudunKoko);
                }
                
                if (labyrintti[ruudunIndeksi].getYlos() != kaytava) {
                    grafiikka.drawLine(i * ruudunKoko, j * ruudunKoko,
                            (i + 1) * ruudunKoko, j * ruudunKoko);
                }

                if (labyrintti[ruudunIndeksi].getAlas() != kaytava) {
                    grafiikka.drawLine(i * ruudunKoko, (j + 1) * ruudunKoko,
                            (i + 1) * ruudunKoko, (j + 1) * ruudunKoko);
                }

                if (labyrintti[ruudunIndeksi].getOikea() != kaytava) {
                    grafiikka.drawLine((i + 1) * ruudunKoko, j * ruudunKoko,
                            (i + 1) * ruudunKoko, (j + 1) * ruudunKoko);
                }              
            }
        }
    }
    public void piirraPolut(Graphics grafiikka, int alku, int maaranpaa) {
        grafiikka.setColor(Color.ORANGE);
        int seuraava = maaranpaa;
        while(seuraava != alku){
            grafiikka.fillRect(seuraava % ruutujenMaaraSivulla * ruudunKoko + ruudunKoko / 2
                    , seuraava / ruutujenMaaraSivulla * ruudunKoko  + ruudunKoko / 2, merkinKoko, merkinKoko);
            Ruutu ruutu = labyrintti[seuraava];
            seuraava = ruutu.getAStarEdellinen();
            
        }
        grafiikka.setColor(Color.GREEN);
        grafiikka.fillRect(alku % ruutujenMaaraSivulla * ruudunKoko + ruudunKoko / 2
                    , alku / ruutujenMaaraSivulla * ruudunKoko  + ruudunKoko / 2, merkinKoko, merkinKoko);
        grafiikka.fillRect(maaranpaa % ruutujenMaaraSivulla * ruudunKoko + ruudunKoko / 2
                    , maaranpaa/ ruutujenMaaraSivulla * ruudunKoko  + ruudunKoko / 2, merkinKoko, merkinKoko);
   
    }

}
