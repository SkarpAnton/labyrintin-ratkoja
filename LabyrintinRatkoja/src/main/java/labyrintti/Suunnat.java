
package labyrintti;

public class Suunnat {
    private static int kaytava = -2;
    
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
                    ruutu.setYlos(kaytava);
                    return;
                case 1: 
                    ruutu.setAlas(kaytava);
                    return;
                case 2: 
                    ruutu.setVasen(kaytava);
                    return;
            }
            ruutu.setOikea(kaytava);
        } else {
            switch(sivu){
                case 0: 
                    ruutu.setAlas(kaytava);
                    return;
                case 1: 
                    ruutu.setYlos(kaytava);
                    return;
                case 2: 
                    ruutu.setOikea(kaytava);
                    return;
            }
            ruutu.setVasen(kaytava);
        }
    }
}
