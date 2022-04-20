package modele;

import vue.grille;
import java.awt.*;

public class plateauIle extends grille {
    static int nbcarte;

    public carteIle[][]  plateau;

    public plateauIle(){
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
    public void inondeAleatoire() {
    int nbcartinonde =0 ;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                while(nbcartinonde<3){
                if (plateau[i][j].setEtat() == 1) { //ile normale
                    this.setBackground(Color.CYAN);
                    nbcartinonde++;
                }else if (plateau[i][j].setEtat() == 2) { //ile sbmergee
                    this.setBackground(Color.BLUE);
                    nbcartinonde++;
                }else{}  }
            }
        }
    }
}
