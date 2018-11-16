
package labyrintti;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class HakuAlgoritmit {
    
    private static final int KAYTAVA = -2;
    
    public static void Leveyshaku(int alku, int maaranpaa, Ruutu[] labyrintti, int ruutujenMaaraSivulla) {
        ArrayDeque<Integer> jono = new ArrayDeque<>();
        jono.add(alku);
        while(true) {
            int nykyinen = jono.pollFirst();
            if(nykyinen == maaranpaa) {
                break;
            }
            Ruutu nykyinenRuutu = labyrintti[nykyinen];
            if(nykyinenRuutu.getAlas() == KAYTAVA) {
                int alas = nykyinen + ruutujenMaaraSivulla;
                Ruutu alempiRuutu = labyrintti[alas];            
                if(alempiRuutu.getLeveyshakuEdellinen() == -1){
                    alempiRuutu.setLeveyshakuEdellinen(nykyinen);
                    jono.add(alas);
                }  
            }
            if(nykyinenRuutu.getYlos() == KAYTAVA) {
                int ylos = nykyinen - ruutujenMaaraSivulla;
                Ruutu ylempiRuutu = labyrintti[ylos]; 
                if(ylempiRuutu.getLeveyshakuEdellinen() == -1){
                    ylempiRuutu.setLeveyshakuEdellinen(nykyinen);
                    jono.add(ylos);
                }
            }
            if(nykyinenRuutu.getOikea() == KAYTAVA) {
                int oikea = nykyinen + 1;
                Ruutu oikeaRuutu = labyrintti[oikea];
                if(oikeaRuutu.getLeveyshakuEdellinen() == -1){
                    oikeaRuutu.setLeveyshakuEdellinen(nykyinen);
                    jono.add(oikea);
                }
            }
            if(nykyinenRuutu.getVasen() == KAYTAVA) {
                int vasen = nykyinen - 1;
                Ruutu vasenRuutu = labyrintti[vasen]; 
                if(vasenRuutu.getLeveyshakuEdellinen() == -1){
                    vasenRuutu.setLeveyshakuEdellinen(nykyinen);
                    jono.add(vasen);
                }
            }  
        }
    }
    
    public static void AStar(int alku, int maaranpaa, Ruutu[] labyrintti, int ruutujenMaaraSivulla) {
        PriorityQueue<RuutuJaPrioriteetti> keko = new PriorityQueue<>();
        int prioriteetti = relaksointi(alku, maaranpaa, ruutujenMaaraSivulla);
        RuutuJaPrioriteetti alkuJaPrioriteetti = new RuutuJaPrioriteetti(alku, prioriteetti, alku);
        keko.add(alkuJaPrioriteetti);
        while(true) {
            RuutuJaPrioriteetti nykyinen = keko.poll();
            Ruutu nykyinenRuutu = labyrintti[nykyinen.getRuudunIndeksi()];
            nykyinenRuutu.setAStarEdellinen(nykyinen.getEdellinen());
            if(nykyinen.getRuudunIndeksi() == maaranpaa) {
                break;
            }
            if(nykyinenRuutu.getAlas() == KAYTAVA) {
                int alas = nykyinen.getRuudunIndeksi() + ruutujenMaaraSivulla;
                Ruutu alempiRuutu = labyrintti[alas];            
                if(alempiRuutu.getAStarEdellinen() == -1){
                    relaksointi(alas, maaranpaa, ruutujenMaaraSivulla);
                    RuutuJaPrioriteetti alempiRuutuJaPrioriteetti 
                            = new RuutuJaPrioriteetti(alas, prioriteetti, nykyinen.getRuudunIndeksi());
                    keko.add(alempiRuutuJaPrioriteetti);
                }  
            }
            if(nykyinenRuutu.getYlos() == KAYTAVA) {
                int ylos = nykyinen.getRuudunIndeksi() - ruutujenMaaraSivulla;
                Ruutu ylempiRuutu = labyrintti[ylos]; 
                if(ylempiRuutu.getAStarEdellinen() == -1){
                    relaksointi(ylos, maaranpaa, ruutujenMaaraSivulla);
                    RuutuJaPrioriteetti ylempiRuutuJaPrioriteetti 
                            = new RuutuJaPrioriteetti(ylos, prioriteetti, nykyinen.getRuudunIndeksi());
                    keko.add(ylempiRuutuJaPrioriteetti);
                }
            }
            if(nykyinenRuutu.getOikea() == KAYTAVA) {
                int oikea = nykyinen.getRuudunIndeksi() + 1;
                Ruutu oikeaRuutu = labyrintti[oikea];
                if(oikeaRuutu.getAStarEdellinen() == -1){
                    relaksointi(oikea, maaranpaa, ruutujenMaaraSivulla);
                    RuutuJaPrioriteetti oikeaRuutuJaPrioriteetti 
                            = new RuutuJaPrioriteetti(oikea, prioriteetti, nykyinen.getRuudunIndeksi());
                    keko.add(oikeaRuutuJaPrioriteetti);
                }
            }
            if(nykyinenRuutu.getVasen() == KAYTAVA) {
                int vasen = nykyinen.getRuudunIndeksi() - 1;
                Ruutu vasenRuutu = labyrintti[vasen]; 
                if(vasenRuutu.getAStarEdellinen() == -1){
                    relaksointi(vasen, maaranpaa, ruutujenMaaraSivulla);
                    RuutuJaPrioriteetti alempiRuutuJaPrioriteetti 
                            = new RuutuJaPrioriteetti(vasen, prioriteetti, nykyinen.getRuudunIndeksi());
                    keko.add(alempiRuutuJaPrioriteetti);
                }
            }  
        }
    }
    public static int relaksointi(int nykyinen, int maaranpaa, int ruutujenMaaraSivulla) {
        int xDiff = maaranpaa % ruutujenMaaraSivulla - nykyinen % ruutujenMaaraSivulla;
        int yDiff = maaranpaa / ruutujenMaaraSivulla - nykyinen / ruutujenMaaraSivulla;
        return (int)Math.sqrt(xDiff * xDiff + yDiff * yDiff) + 1;
    }
}
