package modele;
import java.lang.Math;
import java.util.Random;
import java.util.*;

public class Modele extends Observable {
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
    protected role randomRole(){
        int pick = new Random().nextInt(role.values().length);
        return role.values()[pick];
    }
    private Joueur j1 = new Joueur((nbcarte+1)/2, 1, randomRole());
    private Joueur j2 = new Joueur(nbcarte, (nbcarte+1)/2, randomRole());
    private Joueur j3 = new Joueur(1, (nbcarte+1)/2, randomRole());

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
        choixRole();
    }
    public void choixRole() {
        final ArrayList<role> roles = new ArrayList<role>();
        roles.add(role.ingenieur);
        roles.add(role.messager);
        roles.add(role.plongeur);
        Random rand = new Random();
        int randomInt = rand.nextInt(roles.size());

        for (int i = 0; i < 2; i++) {
            tabJoueurs[i].setRole(roles.get(randomInt));
            roles.remove(randomInt);
            randomInt = rand.nextInt(roles.size());
        }
    }
    protected Zone[][] evalue() {
        int k = 0;
        while(k < 3) {
            // a=1 et b=1 pour éviter que les cases aléatoires soient celles des bordures hors cadre
            int a = new Random().nextInt(nbcarte+1); if (a == 0) a = 1;
            int b = new Random().nextInt(nbcarte+1); if (b == 0) b = 1;
            if(Zones[a][b].getZone() == typeZone.submerge) k+= 0;
            else {
                if(Zones[a][b].getZone() == typeZone.normal) Zones[a][b].setZone(typeZone.innonde);
                else if(Zones[a][b].isJoueur() || Zones[a][b].getZone() == typeZone.joueur) Zones[a][b].setZone(typeZone.innonde);
                else if(Zones[a][b].getZone() == typeZone.air) Zones[a][b].setZone(typeZone.innonde);
                else if(Zones[a][b].getZone() == typeZone.eau) Zones[a][b].setZone(typeZone.innonde);
                else if(Zones[a][b].getZone() == typeZone.feu) Zones[a][b].setZone(typeZone.innonde);
                else if(Zones[a][b].getZone() == typeZone.terre) Zones[a][b].setZone(typeZone.innonde);
                else if(Zones[a][b].getZone() == typeZone.heliport) Zones[a][b].setZone(typeZone.innonde);
                else if(Zones[a][b].getZone() == typeZone.innonde) Zones[a][b].setZone(typeZone.submerge);
                else Zones[a][b].setZone(typeZone.submerge);
                k++;
            }
        }
        return Zones;
    }
    public void avance() {
        evalue();
        addKey(j);
        tour+=1;


        notifyObservers();
    }

    public element getRandomElement() {
        Random random = new Random();
        element randomElement = element.values()[random.nextInt(element.values().length)];
        System.out.println("Le joueur " + ((this.tour)%3 + 1) + " recoit la cle " + randomElement + " !");
        return randomElement;
    }

    public void addKey(Joueur j) {
        if(Math.random() <= 0.35 && partiePerdue == false) {
            cle k = new cle(getRandomElement());
            j.addArtefact(k);
        }
    }


}
