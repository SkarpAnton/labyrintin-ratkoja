
package labyrintti;

import java.util.Scanner;

public class Syote {
    private static Scanner in;
    
    private Syote() {}
    
    public static int getRuutujenMaaraSivulla() {
        in = new Scanner(System.in);
        int ruutujenMaaraSivulla;
        while(true) {
            try {
                System.out.print("Syötä monta ruutua labytintin sivulla on, mikä on  lukua viisi suurempi kokonaisluku: ");
                ruutujenMaaraSivulla = Integer.parseInt(in.next());
                if(ruutujenMaaraSivulla < 6) {
                    throw new NumberFormatException();
                }
                break;
            } catch(NumberFormatException e) {
                System.out.println("Syötettu luku ei ole viittä suurempi kokonaisluku.");
            }
            
        }
        return ruutujenMaaraSivulla;
    }
    
}
