package labyrintti;

public class UnioniEtsi {

    private int[] puut;
    private int puidenMaara;
    
    public UnioniEtsi(int ruutujenMaara) {
        this.puidenMaara = ruutujenMaara;
        puut = new int[ruutujenMaara];
        for (int i = 0; i < puut.length; i++) {
            puut[i] = -1;
        }
    }

    
    public void unioni(int ekaJuuri, int tokaJuuri) {
        if (puut[tokaJuuri] < puut[ekaJuuri]) {
            puut[ekaJuuri] = tokaJuuri;        
        } else {
            if (puut[ekaJuuri] == puut[tokaJuuri]) {
                puut[ekaJuuri]--;          
            }
            puut[tokaJuuri] = ekaJuuri;        
        }
        puidenMaara --;
    }

    
    public int etsi(int x) {
        if (puut[x] < 0) {
            return x;
        } else {
            return etsi(puut[x]);
        }
    }
    
    public boolean yhtenäinenPuu() {
        return 1 >= puidenMaara;
    }
}
