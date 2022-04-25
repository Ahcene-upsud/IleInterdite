
/** Tous les elements possibles d'une cle */
enum element{air,eau,feu,terre}

public class cle {
    private element e;

    /** Premier constructeur pour initialiser une cle avec un element
     * Deuxieme contructeur pour initialiser une cle avec un typeZone */
public cle(element e){
    this.e= e ;
}
public cle(typeZone t){
    if(t == typeZone.air) this.e = element.air;
    if(t == typeZone.eau) this.e = element.eau;
    if(t == typeZone.terre) this.e = element.terre;
    if(t == typeZone.feu) this.e = element.feu;
}
    /** Methode qui permet d'obtenir l'element de la cle */
public element getElement(){
    return e ;
}
}
