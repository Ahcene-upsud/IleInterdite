import java.awt.EventQueue;
import java.awt.*;


public class Conway {
    public static void main(String[] args) {
        /**
         * Pour les besoins du jour on considère la ligne EvenQueue... comme une
         * incantation qu'on pourra expliquer plus tard.
         */
        EventQueue.invokeLater(() -> {
            /** Voici le contenu qui nous intéresse. */
            Modele modele = new Modele();
            CVue vue = new CVue(modele);
        });
    }
}
