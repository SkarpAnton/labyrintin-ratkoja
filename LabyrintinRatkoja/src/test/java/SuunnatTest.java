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
public class SuunnatTest {
    
    private Ruutu ruutu = new Ruutu();
    @Before
    public void setup() {
        ruutu.setYlos(0);
        ruutu.setAlas(10);
        ruutu.setVasen(20);
        ruutu.setOikea(30);
    }
    @Test
    public void getSuuntaTest() {
        assertEquals(0, Suunnat.getSuunta(0, ruutu));
        assertEquals(10, Suunnat.getSuunta(1, ruutu));
        assertEquals(20, Suunnat.getSuunta(2, ruutu));
        assertEquals(30, Suunnat.getSuunta(3, ruutu));
    }
    @Test
    public void setKaytavaTest() {
        Suunnat.setKaytava(0, ruutu, false);
        Suunnat.setKaytava(0, ruutu, true);
        assertEquals(-2, ruutu.getYlos());
        assertEquals(-2, ruutu.getAlas());
    }
}
