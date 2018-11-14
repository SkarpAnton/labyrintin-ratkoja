/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labyrintti.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class MuokkausTest {
    
    Ruutu[] labyrintti;
    private final int ruutujenMaaraSivulla = 1000;
    private final int ruutujenMaara = ruutujenMaaraSivulla * ruutujenMaaraSivulla;
    private final int kaytava = -2;
    public MuokkausTest() {
        labyrintti = SatunnainenKruskal.luoLabyrintti(ruutujenMaaraSivulla, 1, 50);
    }
    
    @Test
    public void kaytavienLisaysTest() {
        int alkuperainenKaytavieMaara = 0;
        for(Ruutu ruutu : labyrintti) {
            if (ruutu.getVasen() == kaytava) {
                alkuperainenKaytavieMaara ++;
            }

            if (ruutu.getYlos() == kaytava) {
                alkuperainenKaytavieMaara ++;
            }

            if (ruutu.getAlas() == kaytava) {
                alkuperainenKaytavieMaara ++;
            }

            if (ruutu.getOikea() == kaytava) {
                alkuperainenKaytavieMaara ++;
            }
        }
        labyrintti = Muokkaus.kaytavienLisays(labyrintti, ruutujenMaaraSivulla);
        int kaytavienMaaraMuokkauksenJalkeen = 0;
        for(Ruutu ruutu : labyrintti) {
            if (ruutu.getVasen() == kaytava) {
                kaytavienMaaraMuokkauksenJalkeen ++;
            }

            if (ruutu.getYlos() == kaytava) {
                kaytavienMaaraMuokkauksenJalkeen ++;
            }

            if (ruutu.getAlas() == kaytava) {
                kaytavienMaaraMuokkauksenJalkeen ++;
            }

            if (ruutu.getOikea() == kaytava) {
                kaytavienMaaraMuokkauksenJalkeen ++;
            }
        }
        assertTrue(kaytavienMaaraMuokkauksenJalkeen >
                alkuperainenKaytavieMaara + ruutujenMaara / 25);
    }
}
