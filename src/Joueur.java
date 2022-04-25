
import java.util.ArrayList;
import java.util.Random;

/** Role qu'un joueur peut prendre */
enum role {pilote, explorateur, navigateur, ingenieur, plongeur, messager};

public class Joueur {
    /** coordonnees et role du joueur */
    private int x;
    private int y;
     private role r;
    /** Cles que possede le joueur */
    public ArrayList<cle> cleList;
    public ArrayList<element> artfactElementList;

    /** Constructeur : on initialise un joueur avec ses coordonnes et un role, et aucune cle */
    public Joueur(int x, int y, role r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.cleList = new ArrayList<>();
        this.artfactElementList = new ArrayList<>();
    }

    /**
     * Methode qui permet d'ajouter une cle au joueur
     * @param k la cle qu'on ajoute
     */
    public void addCle(cle k) {
        cleList.add(k);
        artfactElementList.add(k.getElement());
    }

    /**
     * Methode qui permet de savoir si un joueur possede une cle passee en parametre
     * @param k la cle dont on veut savoir si le joueur la possede
     * @return true si le joueur possede la cle k, false sinon
     */
    public boolean getArtefact(cle k){
        return cleList.contains(k);
    }

    /**
     * Methode qui permet d'obtenir le nombre de cles d'un element qu'un joueur possede
     * @param e L'element dont on veut connaitre la quantite de cles de cet element que le joueur possede
     * @return res un entier representant le nombre de cles de l'element e que le joueur possede
     */
    public int nbCleOfArtefact(element e) {
        int res = 0;
        for (cle k : cleList) {
            if (k.getElement() == e) {
                res += 1;
            }
        }
        return res;
    }


    /** Methode qui permet d'afficher les cles qu'un joueur possede dans le terminal */
    public void afficheCleofArtefact(){
            if(cleList.isEmpty()) {
                System.out.println("Le joueur ne possede pas d'artefact");
            }else{
                System.out.println("Il possede les artefact suivants");
                for(element e : element.values()){
                    int nbArtefact =nbCleOfArtefact(e);
                    System.out.println(nbArtefact  +" "+ e + " ");
                }

            }

    }

        /** Getter et Setter qui permettent de modifier ou recupérer une donné du joueur */
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