package modele;

enum element{air,eau,feu,terre}
public class cle {
    private element e;
public cle(element e){
    this.e= e ;
}
public cle(typeZone t){
    if(t == typeZone.air) this.e = element.air;
    if(t == typeZone.eau) this.e = element.eau;
    if(t == typeZone.terre) this.e = element.terre;
    if(t == typeZone.feu) this.e = element.feu;
}
public element getElement(){
    return e ;
}
}
