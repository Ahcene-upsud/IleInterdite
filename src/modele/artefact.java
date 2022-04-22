package modele;

enum element{air,eau,feu,terre}
public class artefact {
    private element e;
public artefact(element e){
    this.e= e ;
}
public artefact(typeZone t){
    if(t == typeZone.air) this.e = element.air;
    if(t == typeZone.eau) this.e = element.eau;
    if(t == typeZone.terre) this.e = element.terre;
    if(t == typeZone.feu) this.e = element.feu;
}
public element getElement(){
    return e ;
}
}
