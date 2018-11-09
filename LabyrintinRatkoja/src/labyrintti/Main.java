package labyrintti;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int koko;
        while(true) {
            try {
                System.out.print("Syötä lukua viisi suurempi kokonaisluku: ");
                koko = Integer.parseInt(in.next());
                if(koko < 6) {
                    throw new NumberFormatException();
                }
                break;
            } catch(NumberFormatException e) {
                System.out.println("Syötettu luku ei ole viittä suurempi kokonaisluku.");
            }
            
        }       
        Tulostus.tulostaLabyrintti(koko);
    }
}
