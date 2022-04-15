package modele;
import java.util.random.* ;

public class plateauile {
    static int nbcarte = 24;
    public ile[][]  plateau;

    public plateauile(){
        this.plateau = new ile[nbcarte][nbcarte];
        for(int i=0; i<nbcarte ; i++){
            for(int j=0 ;j<nbcarte ;j++){
                ile a = new ile((1 + (int)(Math.random() * ((3 - 1) + 1))));
                plateau[i][j] = a;
            }
        }
    }

}
