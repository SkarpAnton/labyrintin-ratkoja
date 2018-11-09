
package labyrintti;

import java.util.Random;


public class RandomiKruskal {
    
    private static Ruutu[] labyrintti;
    private static int ruutujenMaara;
    private static int kaytava = -2;
    private static int reuna = -1;
    
    public static Ruutu[] luoLabyrintti(int koko) {
        alustus(koko);
        virittavanPuunLuominen();
        return labyrintti;
    }
    
    private static void alustus(int koko) {
        ruutujenMaara = koko * koko;
        
        labyrintti = new Ruutu[ruutujenMaara];
        for (int i = 0; i < ruutujenMaara; i++) {
           labyrintti[i] = new Ruutu();

        }
        
        //sivut osoittaa viereisiin ruutuihin
        for (int i = 0; i < ruutujenMaara; i++) {
            labyrintti[i].ylos = i - koko;
            labyrintti[i].alas = i + koko;
            labyrintti[i].oikea = i + 1;
            labyrintti[i].vasen = i - 1;
        }
        //Seinien lisäys reunoille
        for (int i = 0; i < koko; i++) {
            labyrintti[i].ylos = reuna;
            labyrintti[ruutujenMaara - i - 1].alas = reuna;
            labyrintti[i * koko].vasen = reuna;
            labyrintti[ruutujenMaara - i * koko - 1].oikea = reuna;
        }
        
    }

    /*
    Kaikkien labyrintien siirtymien paino on sama, joten kaaria ei taritse järjestää 
    ja voidaan vain valita ruutuja satunnaisestti. Metodi näyttäisi olevan 
    tarpeeksi nopea käyttötarkoitukseen vaikka se valitsee ruudut satunnaisesti,
    sillä labrintin, jonka sivun pituus on suurempi kuin 1000 alkaa olla hankala 
    kuvata. 
    */
    private static void virittavanPuunLuominen() {

        UnioniEtsi puu = new UnioniEtsi(ruutujenMaara);
        Random satunnais = new Random();
        while (!puu.yhtenäinenPuu()) {
            int satunnainenRuutu = satunnais.nextInt(ruutujenMaara);
            int sivu = satunnais.nextInt(4);
            int viereinenRuutu = Suunnat.getSuunta(sivu, labyrintti[satunnainenRuutu]);
            if (viereinenRuutu != reuna && viereinenRuutu != kaytava) {
                if (puu.etsi(satunnainenRuutu) != puu.etsi(viereinenRuutu)) {
                    Suunnat.setKaytava(sivu, labyrintti[satunnainenRuutu], false);
                    Suunnat.setKaytava(sivu, labyrintti[viereinenRuutu], true);
                    puu.unioni(puu.etsi(satunnainenRuutu), puu.etsi(viereinenRuutu));
                }
            }
        }
    }
}
