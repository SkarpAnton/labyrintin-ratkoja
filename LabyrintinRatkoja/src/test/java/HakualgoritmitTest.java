/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labyrintti.HakuAlgoritmit;
import labyrintti.Ruutu;
import labyrintti.SatunnainenKruskal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class HakualgoritmitTest {
    private final int alku = 150;
    private final int maaranpaa = 750;
    private final int ruutujenMaaraSivulla = 100;
    private final int kaytava = -2;
    private final Ruutu[] labyrintti;
    
    public HakualgoritmitTest() {
        labyrintti = SatunnainenKruskal.luoLabyrintti(ruutujenMaaraSivulla);
        HakuAlgoritmit.Leveyshaku(alku, maaranpaa, labyrintti, ruutujenMaaraSivulla);
        HakuAlgoritmit.AStar(alku, maaranpaa, labyrintti, ruutujenMaaraSivulla);
    }
    
    @Test
    public void leveysHaunJaAstarinPolunPituusSama() {
        int seuraavaAStar = maaranpaa;
        int seuraavaLeveysHaku = maaranpaa;
        while(seuraavaAStar != alku && seuraavaLeveysHaku != alku){
            Ruutu ruutuLeveysHaku = labyrintti[seuraavaLeveysHaku];
            Ruutu ruutuAStar = labyrintti[seuraavaAStar];
            seuraavaAStar = ruutuAStar.getAStarEdellinen();
            seuraavaLeveysHaku = ruutuLeveysHaku.getLeveyshakuEdellinen();
        }
        assertEquals(seuraavaAStar, alku);
        assertEquals(seuraavaLeveysHaku, alku);
    }
    
    @Test
    public void leveysHakuEiMeneYliSeinien() {
        int nykyinen = maaranpaa;
        int vanha = maaranpaa;
        while(nykyinen != alku){
            Ruutu ruutu = labyrintti[nykyinen];
            vanha = nykyinen;
            nykyinen = ruutu.getLeveyshakuEdellinen();
            if(nykyinen - vanha == -ruutujenMaaraSivulla) {
                assertTrue(ruutu.getYlos() == kaytava);
            }
            if(nykyinen - vanha == ruutujenMaaraSivulla) {
                assertTrue(ruutu.getAlas() == kaytava);
            }
            if(nykyinen - vanha == 1) {
                assertTrue(ruutu.getOikea() == kaytava);
            }
            if(nykyinen - vanha == -1) {
                assertTrue(ruutu.getVasen() == kaytava);
            }
        }
    }
    
    @Test
    public void AStarEiMeneYliSeinien() {
        int nykyinen = maaranpaa;
        int vanha = maaranpaa;
        while(nykyinen != alku){
            Ruutu ruutu = labyrintti[nykyinen];
            vanha = nykyinen;
            nykyinen = ruutu.getAStarEdellinen();
            if(nykyinen - vanha == -ruutujenMaaraSivulla) {
                assertTrue(ruutu.getYlos() == kaytava);
            }
            if(nykyinen - vanha == ruutujenMaaraSivulla) {
                assertTrue(ruutu.getAlas() == kaytava);
            }
            if(nykyinen - vanha == 1) {
                assertTrue(ruutu.getOikea() == kaytava);
            }
            if(nykyinen - vanha == -1) {
                assertTrue(ruutu.getVasen() == kaytava);
            }
        }
    }
    
}
