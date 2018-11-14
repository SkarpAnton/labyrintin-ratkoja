
package labyrintti;

public class Ruutu {
    private int vasen;
    private int oikea;
    private int ylos;
    private int alas;  
    private int leveyshakuEdellinen = -1;
    private int AStarEdellinen = -1;
    
    public void setLeveyshakuEdellinen(int leveyshakuEdellinen) {
        this.leveyshakuEdellinen = leveyshakuEdellinen;
    }
    

    public int getLeveyshakuEdellinen() {
        return leveyshakuEdellinen;
    }

    public int getAStarEdellinen() {
        return AStarEdellinen;
    }

    public void setAStarEdellinen(int AStarEdellinen) {
        this.AStarEdellinen = AStarEdellinen;
    }

    public void setVasen(int vasen) {
        this.vasen = vasen;
    }

    public void setOikea(int oikea) {
        this.oikea = oikea;
    }

    public void setYlos(int ylos) {
        this.ylos = ylos;
    }

    public void setAlas(int alas) {
        this.alas = alas;
    }

    public int getVasen() {
        return vasen;
    }

    public int getOikea() {
        return oikea;
    }

    public int getYlos() {
        return ylos;
    }

    public int getAlas() {
        return alas;
    }
}
