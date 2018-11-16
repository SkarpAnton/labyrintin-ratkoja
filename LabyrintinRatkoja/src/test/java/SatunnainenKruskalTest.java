/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labyrintti.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class SatunnainenKruskalTest {
    private final Ruutu[] labyrintti;
    private final int ruutujenMaaraSivulla = 1000;
    private final int ruutujenMaara = ruutujenMaaraSivulla * ruutujenMaaraSivulla;
    private final int reuna = -1;
    private final int kaytava = -2;
    public SatunnainenKruskalTest() {
        labyrintti = SatunnainenKruskal.luoLabyrintti(ruutujenMaaraSivulla);
    }
    
    @Test
    public void reunatTest() {
        for (int i = 0; i < ruutujenMaaraSivulla; i++) {
            
            assertEquals(reuna, labyrintti[i].getYlos());
            assertEquals(reuna, labyrintti[ruutujenMaara - i - 1].getAlas());
            assertEquals(reuna, labyrintti[i * ruutujenMaaraSivulla].getVasen());
            assertEquals(reuna, labyrintti[ruutujenMaara - i * ruutujenMaaraSivulla - 1].getOikea());
            
        }
    }
    
    @Test
    public void kaikiinRuutuihinOnKaytava() {
        for(int i = 0; i < ruutujenMaara; i++) {
            Boolean onKaytava = false;
            if (labyrintti[i].getVasen() == kaytava || labyrintti[i].getYlos() == kaytava ||
                    labyrintti[i].getAlas() == kaytava || labyrintti[i].getOikea() == kaytava) {
                onKaytava = true;
            } else {
                fail(labyrintti[i].getVasen() + "," + labyrintti[i].getAlas() + "," + labyrintti[i].getOikea() + "," + labyrintti[i].getYlos());
            }
            assertTrue(onKaytava);
        }
    }
    
}
