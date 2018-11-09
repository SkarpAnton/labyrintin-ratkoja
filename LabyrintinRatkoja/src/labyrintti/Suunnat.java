
package labyrintti;

public class Suunnat {
    private static int kaytava = -2;
    public static int getSuunta(int sivu, Ruutu ruutu) {
        switch(sivu){
            case 0: return ruutu.ylos;
            case 1: return ruutu.alas;
            case 2: return ruutu.vasen;
        }
        return ruutu.oikea;
    }
    public static void setKaytava(int sivu, Ruutu ruutu, Boolean toisinPain) {
        if(!toisinPain) {
            switch(sivu){
                case 0: 
                    ruutu.ylos = kaytava;
                    return;
                case 1: 
                    ruutu.alas = kaytava;
                    return;
                case 2: 
                    ruutu.vasen = kaytava;
                    return;
            }
            ruutu.oikea = kaytava;
        } else {
            switch(sivu){
                case 0: 
                    ruutu.alas = kaytava;
                    return;
                case 1: 
                    ruutu.ylos = kaytava;
                    return;
                case 2: 
                    ruutu.oikea = kaytava;
                    return;
            }
            ruutu.vasen = kaytava;
        }
    }
}
