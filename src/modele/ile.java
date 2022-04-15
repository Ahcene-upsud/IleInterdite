package modele;

public class ile {
    int etat ; //normal:1 , submerge:2, inondée:3

    public ile (int etat){
    this.etat=etat;
}
    public int getEtat(int c){
        switch(c){
            case 1 :
                System.out.println("ile normale");

            case 2 :
                System.out.println("ile submerge");

            case 3 :
                System.out.println("ile inondée");

            default :
                System.out.println("erreur");

        }
        return c;
    }

}
