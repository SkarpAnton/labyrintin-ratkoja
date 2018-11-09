package labyrintti;

import java.util.Random;


public class Muokkaus {
    /*
    Poistaa labyrintistä muutaman seinän, jotta labyrintissä olisi hiukan enemmän erilaisia polkuja
    */
    public static Ruutu[] kaytavienLisays(Ruutu[] labyrintti, int koko) {
        Random satunnais = new Random();
        int reuna = -1;
        int kaytava = -2;
        for (int i = 0; i < koko / 2; i++) {
            while (true) {
                int satunnainenRivi = satunnais.nextInt(koko - 2) + 1;
                int satunnainenSarake = satunnais.nextInt(koko - 2) + 1;
                int satunnainenRuutu = satunnainenRivi * koko + satunnainenSarake;
                int sivu = satunnais.nextInt(4);
                int viereinenRuutu = Suunnat.getSuunta(sivu, labyrintti[satunnainenRuutu]);
                if (viereinenRuutu != reuna && viereinenRuutu != kaytava) { 
                    Suunnat.setKaytava(sivu, labyrintti[satunnainenRuutu], false);
                    Suunnat.setKaytava(sivu, labyrintti[viereinenRuutu], true);
                    break;
                }
            }
        }
        return labyrintti;
    }
}