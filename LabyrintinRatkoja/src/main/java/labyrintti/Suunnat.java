
package labyrintti;

public class Suunnat {
    private static final int KAYTAVA = -2;
    
    private Suunnat(){};
    
    public static int getSuunta(int sivu, Ruutu ruutu) {
        switch(sivu){
            case 0: return ruutu.getYlos();
            case 1: return ruutu.getAlas();
            case 2: return ruutu.getVasen();
        }
        return ruutu.getOikea();
    }
    public static void setKaytava(int sivu, Ruutu ruutu, Boolean toisinPain) {
        if(!toisinPain) {
            switch(sivu){
                case 0: 
                    ruutu.setYlos(KAYTAVA);
                    return;
                case 1: 
                    ruutu.setAlas(KAYTAVA);
                    return;
                case 2: 
                    ruutu.setVasen(KAYTAVA);
                    return;
            }
            ruutu.setOikea(KAYTAVA);
        } else {
            switch(sivu){
                case 0: 
                    ruutu.setAlas(KAYTAVA);
                    return;
                case 1: 
                    ruutu.setYlos(KAYTAVA);
                    return;
                case 2: 
                    ruutu.setOikea(KAYTAVA);
                    return;
            }
            ruutu.setVasen(KAYTAVA);
        }
    }
}
