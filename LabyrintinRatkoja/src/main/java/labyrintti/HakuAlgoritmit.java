
package labyrintti;

import java.util.ArrayDeque;

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
}
