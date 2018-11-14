package labyrintti;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int sivunLeveys = 1000;
        int ruutujenMaaraSivulla = Syote.getRuutujenMaaraSivulla();
        int ruudunLeveys = sivunLeveys / ruutujenMaaraSivulla;
        if(ruudunLeveys < 2) {
            ruudunLeveys = 2;
        }
        Tulostus.tulostaLabyrintti(ruutujenMaaraSivulla, ruudunLeveys, sivunLeveys);
    }
}
