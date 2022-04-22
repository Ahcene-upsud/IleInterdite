package modele;


import java.util.ArrayList;

enum role {normal , ingenieur , plongeur , messager};
public class Joueur {
    private  int x;
    private int y;
    role r ;

    public ArrayList<artefact> artefactList;
    public ArrayList<element>


    public Joueur(int x, int y,role r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void assigneRole() {
        if (Grade == "pilote") {
        } else if (Grade == "Navigateur") {
        } else if (Grade == "Plongeur") {
        } else if (Grade == "Explorateur") {
        } else if (Grade == "Ingenieur") {
        } else if (Grade == "Messager") {
            {
            }
        }
    }
}