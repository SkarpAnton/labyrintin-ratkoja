package labyrintti;

import java.util.Random;


public class Muokkaus {
    /*
    Poistaa labyrintistä muutaman seinän, jotta labyrintissä olisi hiukan enemmän erilaisia polkuja
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

                    switch(sivu) {
                        case Suunnat.ylos: 
                            labyrintti[viereinenRuutu].sivut[Suunnat.alas] = kaytava;
                            break;
                        case Suunnat.alas:
                            labyrintti[viereinenRuutu].sivut[Suunnat.ylos] = kaytava;
                            break;
                        case Suunnat.vasen:
                            labyrintti[viereinenRuutu].sivut[Suunnat.oikea] = kaytava;
                            break;
                        case Suunnat.oikea:
                            labyrintti[viereinenRuutu].sivut[Suunnat.vasen] = kaytava;
                            break;
                    }
                    break;

                }
            }
        }
        return labyrintti;
    }
}