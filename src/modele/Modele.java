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

    private Zone Air = new Zone(xAir , yAir , this , typeZone.air , false ,false);
    private Zone Terre = new Zone(xTerre , yTerre , this , typeZone.terre , false ,false);
    private Zone Eau = new Zone(xEau , yEau , this , typeZone.eau , false ,false);
    private Zone Feu = new Zone(xFeu , yFeu , this , typeZone.feu , false ,false);
    private Zone heliport = new Zone((nbcarte+1)/2 , nbcarte ,this ,typeZone.heliport, false ,false);

    private Joueur j1 = new Joueur((nbcarte+1)/2, 1, role.ingenieur);
    private Joueur j2 = new Joueur(nbcarte, (nbcarte+1)/2, role.ingenieur);
    private Joueur j3 = new Joueur(1, (nbcarte+1)/2, role.ingenieur);

    private Joueur j = j1;

    private typeZone ancienneZone, prochaineZone;
    Random getKey = new Random();
    Joueur[] tabJoueurs = {j1, j2, j3, j1, j2};

    public Modele() {


        Zones = new Zone[nbcarte+2][nbcarte+2];
        for(int i=0; i<nbcarte+2; i++) {
            for(int j=0; j<nbcarte+2; j++) {
                Zones[i][j] = new Zone(i ,j ,this , typeZone.normal ,false,false);
            }
        }
        Zones[j1.getX()][j1.getY()] = new Zone( j1.getX(), j1.getY(),this, typeZone.normal,true, getKey.nextBoolean());
        Zones[j2.getX()][j2.getY()] = new Zone( j2.getX(), j2.getY(),this, typeZone.normal,true,getKey.nextBoolean());
        Zones[j3.getX()][j3.getY()] = new Zone( j3.getX(), j3.getY(), this,typeZone.normal,true,getKey.nextBoolean());
        Zones[(nbcarte+1)/2][nbcarte] = heliport;
        Zones[xAir][yAir] = Air;
        Zones[xTerre][yTerre] = Terre;
        Zones[xEau][yEau] = Eau;
        Zones[xFeu][yFeu] = Feu;
        //choixRole();
    }




}
