package modele;

import vue.grille;
import java.awt.*;

public class plateauIle extends grille {
    static int nbcarte;
    public carteIle[][]  plateau;

    public plateauIle(int nbcarte){
        super(6,4);
        this.nbcarte= nbcarte;
        this.plateau = new carteIle[nbcarte][nbcarte];
        for(int i=0; i<4 ; i++){
            for(int j=0 ;j<6 ;j++){
                carteIle a = new carteIle(this);
                plateau[i][j] = a;
                this.ajouteElement(a);
            }
        }
    }

}
