
package labyrintti;

import java.util.Random;


public class RandomizedKruskal {
    
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
            labyrintti[i].sivut[Suunnat.ylos] = i - koko;
            labyrintti[i].sivut[Suunnat.alas] = i + koko;
            labyrintti[i].sivut[Suunnat.oikea] = i + 1;
            labyrintti[i].sivut[Suunnat.vasen] = i - 1;
        }
        //Seinien lisäys reunoille
        for (int i = 0; i < koko; i++) {
            labyrintti[i].sivut[Suunnat.ylos] = reuna;
            labyrintti[ruutujenMaara - i - 1].sivut[Suunnat.alas] = reuna;
        }
        for (int i = 0; i < ruutujenMaara; i += koko) {
            labyrintti[i].sivut[Suunnat.vasen] = reuna;
            labyrintti[ruutujenMaara - i - 1].sivut[Suunnat.oikea] = reuna;
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
            int viereinenRuutu = labyrintti[satunnainenRuutu].sivut[sivu];
            if (viereinenRuutu != reuna && viereinenRuutu != kaytava) {
                if (puu.etsi(satunnainenRuutu) != puu.etsi(viereinenRuutu)) {
                    labyrintti[satunnainenRuutu].sivut[sivu] = kaytava;
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
                    
                    puu.unioni(puu.etsi(satunnainenRuutu), puu.etsi(viereinenRuutu));
                }
            }
        }
    }
}
