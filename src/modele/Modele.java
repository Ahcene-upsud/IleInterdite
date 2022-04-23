package modele;
import java.lang.Math;
import java.util.Random;

public class Modele {
    private int nbActions =0 ;
    private int nbArtefacts = 0;
    private int tour = 0;

    private boolean partieGagnee  = false ;
    private boolean partiePerdue = false;

    static final int nbcarte = 24 ;

    private Zone[][] Zones ;


    private int xAir = 1+new Random().nextInt(((nbcarte+1)/2)-1);
    private int yAir = 1+new Random().nextInt(((nbcarte+1)/2)-1);
    private int xTerre = ((nbcarte+1)/2)+1 + new Random().nextInt(nbcarte+1)/2;
    private int yTerre = 1+new Random().nextInt(((nbcarte+1)/2)-2);
    private int xEau = 1+new Random().nextInt(((nbcarte+1)/2)-2);
    private int yEau = ((nbcarte+1)/2)+1 + new Random().nextInt(((nbcarte+1)/2)-2);
    private int xFeu = ((nbcarte+1)/2)+1 + new Random().nextInt(((nbcarte+1)/2)-2);
    private int yFeu =  ((nbcarte+1)/2)+1 + new Random().nextInt(((nbcarte+1)/2)-2);

    private Zone air = new Zone(this , false , false , );




}
