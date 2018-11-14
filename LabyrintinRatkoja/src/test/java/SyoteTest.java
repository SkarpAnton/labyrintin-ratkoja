/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import labyrintti.Syote;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class SyoteTest { 
    @Before
    public void setUp() {
        String syote = "2\n10";
        InputStream in = new ByteArrayInputStream(syote.getBytes());
        System.setIn(in);
    }
    
    @Test
    public void getRuutujenMaaraSivullaTest() {
        int koko = Syote.getRuutujenMaaraSivulla();
        assertEquals(10, koko);
    }
    
}
