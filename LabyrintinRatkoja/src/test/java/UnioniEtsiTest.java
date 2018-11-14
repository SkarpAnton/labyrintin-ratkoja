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
public class UnioniEtsiTest {
    private UnioniEtsi puu;
    private final int koko = 100;
    
    @Before
    public void setUp() {
        puu = new UnioniEtsi(koko);
    }
    
    @Test
    public void yhtenainenPuuTest() {
        for(int i = 1; i < koko; i++) {
            assertTrue(!puu.yhtenäinenPuu());
            puu.unioni(puu.etsi(i-1), i);
        }
        assertTrue(puu.yhtenäinenPuu());
    }
    
    @Test
    public void etsiJaUnioniTest() {
       for(int i = 1; i < koko; i++) {
            puu.unioni(puu.etsi(i-1), i);
            assertEquals(0, puu.etsi(i));
        } 
    }
    
    
}
