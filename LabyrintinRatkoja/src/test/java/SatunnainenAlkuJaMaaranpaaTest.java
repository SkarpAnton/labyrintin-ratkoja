/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import labyrintti.SatunnainenAlkuJaMaaranpaa;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skarp
 */
public class SatunnainenAlkuJaMaaranpaaTest {
    SatunnainenAlkuJaMaaranpaa alkuJaMaaranpaa = new SatunnainenAlkuJaMaaranpaa(1000);

    @Test
    public void alkuJaMaaranpaaEri() {
        assertTrue(alkuJaMaaranpaa.getAlku() != alkuJaMaaranpaa.getMaaranpaa());
    }
    
    
}
