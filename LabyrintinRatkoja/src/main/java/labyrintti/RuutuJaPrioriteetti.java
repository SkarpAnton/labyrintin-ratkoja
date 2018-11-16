
package labyrintti;

public class RuutuJaPrioriteetti implements Comparable<RuutuJaPrioriteetti>{
    private final int ruudunIndeksi;
    private final int matka;
    private int edellinen;

    public RuutuJaPrioriteetti(int ruutu, int matka, int edellinen) {
        this.ruudunIndeksi = ruutu;
        this.matka = matka;
        this.edellinen = edellinen;
    }

    public void setEdellinen(int edellinen) {
        this.edellinen = edellinen;
    }

    public int getEdellinen() {
        return edellinen;
    }
    
    public int getRuudunIndeksi() {
        return ruudunIndeksi;
    }

    public int getMatka() {
        return matka;
    }
    
    @Override
    public int compareTo(RuutuJaPrioriteetti t) {
        return matka - t.getMatka();
    }
}
