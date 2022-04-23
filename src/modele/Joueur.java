package modele;


import java.util.ArrayList;

enum role {pilote, explorateur , navigateur , ingenieur , plongeur , messager};

public class Joueur {
    private int x;
    private int y;
     private role r;

    public ArrayList<cle> artefactList;
    public ArrayList<element> artfactElementList;


    public Joueur(int x, int y, role r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void addArtefact(cle k) {
        artefactList.add(k);
        artfactElementList.add(k.getElement());
    }
    public boolean getArtefact(cle k){
        return artefactList.contains(k);
    }
    public int nbOfArtefact(element e) {
        int res = 0;
        for (cle k : artefactList) {
            if (k.getElement() == e) {
                res += 1;
            }
        }
        return res;
    }
    public void afficheArtefact(){
            if(artefactList.isEmpty()) {
                System.out.println("Le joueur ne possede pas d'artefact");
            }else{
                System.out.println("Il possede les artefact suivants");
                for(element e : element.values()){
                    int nbArtefact =nbOfArtefact(e);
                    System.out.println(nbArtefact  +" "+ e + " ");
                }

            }

    }
        public int getX() {
            return x;
        }


        public int getY() {
            return y;
        }


        public role getRole() {
            return r;
        }


        public void setX(int x) {
            this.x = x;
        }


        public void setY(int y) {
            this.y = y;
        }

        public void setRole(role r) {
            this.r = r;
        }
}