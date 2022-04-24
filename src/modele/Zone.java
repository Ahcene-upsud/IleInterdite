package modele;

enum typeZone{ joueur , heliport , air , eau , feu ,terre , normal, innonde ,submerge }
public class Zone {
    private Modele modele;
     private boolean estJoueur ;
     private boolean estInonde ;
     private boolean getCle;
     private typeZone zone ;

     private final int x,y ;

     public Zone(int x,int y , Modele modele , typeZone zone ,boolean estJoueur ,boolean getCle ){

         this.x=x;
         this.y=y;
         this.modele= modele;
         this.zone = zone;
         this.estJoueur= estJoueur;
         this.getCle= getCle;

     }

     public int getX(){ return x;}

    public int getY(){return y;}

    public boolean isJoueur() {return estJoueur;}

    public boolean isInonde(){ return estInonde;}


    public boolean isGetCle() {
        return getCle;
    }

    public typeZone getZone() {
        return zone;
    }

    public void setEstJoueur(boolean estJoueur) {
        this.estJoueur = estJoueur;
    }

    public void setCle(boolean getCle) {
        this.getCle = getCle;
    }

    public void setZone(typeZone zone) {
        this.zone = zone;
    }

    public boolean estNormale(){return zone == typeZone.normal;}

    public boolean estInnonde(){return zone == typeZone.innonde;}
}
