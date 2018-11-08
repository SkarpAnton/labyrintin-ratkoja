
package labyrintti;

import java.util.Random;


public class LabyrintinMuokkaus {
    /*
    Kruskalin algoritmista tulisi vain yksi polku alusta maaliin, tämän luokan tarkoituksena on  
    poistaa muutama seinä labyrintistä, jotta olisi useampia mahdollisia polkuja
    */
    public static Ruutu[] kaytavienLisays(Ruutu[] labyrintti, int koko) {
        Random satunnais = new Random();
        int kaytava = -2;
        for (int i = 0; i < koko / 2; i++) {
            while (true) {
                int satunnainenRivi = satunnais.nextInt(koko - 1) + 1;
                int satunnainenSarake = satunnais.nextInt(koko - 1) + 1;
                int sivu = satunnais.nextInt(4);
                int viereinenRuutu = labyrintti[satunnainenRivi * koko + satunnainenSarake].sivut[sivu];
                if (viereinenRuutu != -1 && viereinenRuutu != kaytava) { 
                    labyrintti[satunnainenRivi * koko + satunnainenSarake].sivut[sivu] = kaytava;

                    if (sivu == Suunnat.ylos || sivu == Suunnat.oikea) {
                        labyrintti[viereinenRuutu].sivut[sivu + 1] = kaytava;
                    }
                    if (sivu == Suunnat.alas || sivu == Suunnat.vasen) {
                        labyrintti[viereinenRuutu].sivut[sivu - 1] = kaytava;
                    }
                    break;

                }
            }
        }
        return labyrintti;
    }
}
