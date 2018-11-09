package labyrintti;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int koko;
        while(true) {
            try {
                System.out.print("Syötä lukua viisi suurempi kokonaisluku: ");
                koko = in.nextInt();
                if(koko < 6) {
                    throw new InputMismatchException();
                }
                break;
            } catch(InputMismatchException e) {
                System.out.println("Syötettu luku ei ole positiivinen kokonaisluku.");
            }
            
        }       
        Tulostus.tulostaLabyrintti(koko);
    }
}
