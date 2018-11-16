
package labyrintti;

import java.util.Random;


public class SatunnainenKruskal {
    
    private static Ruutu[] labyrintti;
    private static int ruutujenMaara;
    private static final int KAYTAVA = -2;
    private static final int REUNA = -1;
    
    private SatunnainenKruskal(){};
    
    public static Ruutu[] luoLabyrintti(int ruutujenMaaraSivulla) {
        alustus(ruutujenMaaraSivulla);
        virittavanPuunLuominen();
        return labyrintti;
    }
    
    private static void alustus(int ruutujenMaaraSivulla) {
        ruutujenMaara = ruutujenMaaraSivulla * ruutujenMaaraSivulla;
        
        labyrintti = new Ruutu[ruutujenMaara];
        for (int i = 0; i < ruutujenMaara; i++) {
           labyrintti[i] = new Ruutu();

        }
        
        //sivut osoittaa viereisiin ruutuihin
        for (int i = 0; i < ruutujenMaara; i++) {
            labyrintti[i].setYlos(i - ruutujenMaaraSivulla);
            labyrintti[i].setAlas(i + ruutujenMaaraSivulla);
            labyrintti[i].setOikea(i + 1);
            labyrintti[i].setVasen(i - 1);
        }
        //Seinien lisäys reunoille
        for (int i = 0; i < ruutujenMaaraSivulla; i++) {
            labyrintti[i].setYlos(REUNA);
            labyrintti[ruutujenMaara - i - 1].setAlas(REUNA);
            labyrintti[i * ruutujenMaaraSivulla].setVasen(REUNA);
            labyrintti[ruutujenMaara - i * ruutujenMaaraSivulla - 1].setOikea(REUNA);
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
            if (viereinenRuutu != REUNA && viereinenRuutu != KAYTAVA) {
                if (puu.etsi(satunnainenRuutu) != puu.etsi(viereinenRuutu)) {
                    Suunnat.setKaytava(sivu, labyrintti[satunnainenRuutu], false);
                    Suunnat.setKaytava(sivu, labyrintti[viereinenRuutu], true);
                    puu.unioni(puu.etsi(satunnainenRuutu), puu.etsi(viereinenRuutu));
                }
            }
        }
    }
}
