/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labyrintti.HakuAlgoritmit;
import labyrintti.Ruutu;
import labyrintti.SatunnainenKruskal;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class HakualgoritmitTest {
    
    private Ruutu[] labyrintti;
    
    public HakualgoritmitTest() {
        labyrintti = SatunnainenKruskal.luoLabyrintti(100, 150, 200);
        HakuAlgoritmit.Leveyshaku(150, 750, labyrintti, 100);
        HakuAlgoritmit.AStar(150, 750, labyrintti, 100);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
}
