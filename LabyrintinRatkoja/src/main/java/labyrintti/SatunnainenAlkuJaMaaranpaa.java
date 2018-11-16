
package labyrintti;

import java.util.Random;

public class SatunnainenAlkuJaMaaranpaa {
    private int alku;
    private int maaranpaa;

    public SatunnainenAlkuJaMaaranpaa(int ruutujenMaara) {
        Random satunnainen = new Random();
        alku = satunnainen.nextInt(ruutujenMaara);
        maaranpaa = satunnainen.nextInt(ruutujenMaara);
        while(alku == maaranpaa) {
            alku = satunnainen.nextInt(ruutujenMaara);
            maaranpaa = satunnainen.nextInt(ruutujenMaara);
        }
    }

    public int getAlku() {
        return alku;
    }

    public int getMaaranpaa() {
        return maaranpaa;
    }
    
}
