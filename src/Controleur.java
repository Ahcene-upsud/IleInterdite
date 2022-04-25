

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JButton;

public class Controleur implements ActionListener {
Modele modele ;
JButton bouton ;
VueCommandes vue;

public Controleur( Modele modele , JButton bouton , VueCommandes vue){
    this.modele = modele ;
    this.vue = vue;
    this.bouton = bouton;
}
    /**
     * Action effectuee a reception d'un evenement : appeler la
     * methode [avance] du modele.
     */
    public void actionPerformed(ActionEvent e) {

        /** Si le joueur appuie sur le bouton fin de tour, 3 zones s'innondent et le joueur dont c'est le
         * tour possede a present 3 actions possibles
         */
        if(bouton == vue.boutonAvance) {
            modele.setNbActions(0);
            modele.avance();
            if((modele.getTour()+1)%3 == 0)
                System.out.println("\n" + "\n" + "Tour du joueur 3");
            else
                System.out.println("\n" + "\n" + "Tour du joueur " + ((modele.getTour()+1)%3));
            modele.tabJoueurs[(modele.getTour())%3].afficheCleofArtefact();


            /** Si le joueur appuie sur le bouton asseche, soit il est ingenieur et il peut assecher
             * 2 zones, soit il ne l'est pas et il peut en assecher une
             */
        } else if(bouton == vue.boutonAsseche)
            if(modele.getJ().getRole() == role.ingenieur) {
                System.out.println("Vous etes ingenieur, vous assechez une ou meme deux zones comme bon vous semble !");
                modele.setNbActions(modele.getNbActions()-1);
                modele.asseche();
                modele.asseche();
            }
            else
                modele.asseche();


        /** On affecte a chaque bouton son utilite, ce qu'il fait dans le jeu */
        else if(bouton == vue.boutonGauche)
            modele.gauche();
        else if(bouton == vue.boutonDroite)
            modele.droite();
        else if(bouton == vue.boutonHaut)
            modele.haut();
        else if(bouton == vue.boutonArtefact)
            modele.recupArtefact();
        else if(bouton == vue.boutonRecupKey)
            modele.recupCle();
        else if(bouton == vue.boutonGiveKey)
            modele.giveCle();
        else
            modele.bas();


        /** Maximum 3 actions par tour */
        if(modele.getNbActions() > 2) {
            vue.boutonGauche.setEnabled(false);
            vue.boutonDroite.setEnabled(false);
            vue.boutonHaut.setEnabled(false);
            vue.boutonBas.setEnabled(false);
            vue.boutonAsseche.setEnabled(false);
            vue.boutonArtefact.setEnabled(false);
            vue.boutonRecupKey.setEnabled(false);
            vue.boutonGiveKey.setEnabled(false);
            vue.boutonAvance.setEnabled(true);
        }


        /** A chaque debut de tour, toutes les cases sont a nouveau disponibles */
        if(modele.getNbActions() == 0) {
            vue.boutonGauche.setEnabled(true);
            vue.boutonDroite.setEnabled(true);
            vue.boutonHaut.setEnabled(true);
            vue.boutonBas.setEnabled(true);
            vue.boutonAsseche.setEnabled(true);
            vue.boutonAvance.setEnabled(true);
            vue.boutonArtefact.setEnabled(true);
            vue.boutonRecupKey.setEnabled(true);
            vue.boutonGiveKey.setEnabled(true);
        }


        /** Fin de partie gagnante */
        if(modele.isGagnee()) {
            System.out.println("\n" + "Vous avez gagne la partie");
            vue.boutonGauche.setVisible(false);
            vue.boutonDroite.setVisible(false);
            vue.boutonHaut.setVisible(false);
            vue.boutonBas.setVisible(false);
            vue.boutonAsseche.setVisible(false);
            vue.boutonAvance.setVisible(false);
            vue.boutonArtefact.setVisible(false);
            vue.boutonRecupKey.setVisible(false);
            vue.boutonGiveKey.setVisible(false);
        }


        /** Fin de partie perdante */
        if(modele.isPerdue()) {
            System.out.println("\n" + "Vous avez perdu la partie");
            vue.boutonGauche.setVisible(false);
            vue.boutonDroite.setVisible(false);
            vue.boutonHaut.setVisible(false);
            vue.boutonBas.setVisible(false);
            vue.boutonAsseche.setVisible(false);
            vue.boutonAvance.setVisible(false);
            vue.boutonArtefact.setVisible(false);
            vue.boutonRecupKey.setVisible(false);
            vue.boutonGiveKey.setVisible(false);
        }


        /** Les tours alternent, 3 joueurs donc modulo 3 */
        if( (modele.getTour())%3 == 0) modele.setJ(modele.getJ1());
        else if( (modele.getTour())%3 == 1) modele.setJ(modele.getJ2());
        else modele.setJ(modele.getJ3());


        /**
         Deux tableaux pour pouvoir acceder a notre guise aux typeZone et aux zones
         selon nos besoins et selon les types des parametres des fonctions utilisees
         Ceux ci sont volontairement disposes dans le meme ordre
         **/
        Zone[] zoneSpeciale = {modele.getHeliport(), modele.getAir(), modele.getEau(), modele.getFeu(), modele.getTerre()};
        typeZone[] typeZoneSpeciale = {typeZone.heliport, typeZone.air, typeZone.eau, typeZone.feu, typeZone.terre};


        /** Prevenir qu'une zone speciale est inondee ou submergee et faire terminer la partie
         * si une zone speciale est submergee
         */
        for(int i = 0; i < zoneSpeciale.length; i++) {

            if(modele.isPerdue() == false) {
                if(zoneSpeciale[i].getZone() == typeZone.innonde && bouton == vue.boutonAvance)
                    System.out.println("\n" + "Cette zone speciale est innondee faites attention : " + typeZoneSpeciale[i]);

                if(zoneSpeciale[i].getZone() == typeZone.submerge && bouton == vue.boutonAvance)
                    System.out.println("\n" + "Cette zone speciale est submergee c'est perdu : " + typeZoneSpeciale[i]);

                if(zoneSpeciale[i].getZone() == typeZone.submerge)
                    modele.setPartiePerdue(true);
            }
        }


        /** Si le joueur est sur le contour visible des bordures du jeu
         * Cette partie sert a verifier quand est ce que le joueur s'est noye et donc a mettre fin au jeu
         */
        if(modele.getJ().getX() == 1 || modele.getJ().getX() == modele.nbZones || modele.getJ().getY() == 1 || modele.getJ().getY() == modele.nbZones) {


            /** Si le joueur est sur un des 4 recoins du jeu */
            if(modele.getJ().getX() == modele.getJ().getY() || (modele.getJ().getX() == 1 && modele.getJ().getY() == modele.nbZones) || (modele.getJ().getX() == modele.nbZones && modele.getJ().getY() == 1)) {
                if(modele.compteZoneSubmerge(modele.getJ().getX(), modele.getJ().getY()) == 2) {
                    System.out.println("Le joueur " + ((modele.getTour())%3 + 1) + " s'est noye");
                    modele.setPartiePerdue(true);
                }
            }

            /** Si le joueur est sur un des 4 cotes du jeu */
            if(modele.compteZoneSubmerge(modele.getJ().getX(), modele.getJ().getY()) == 3) {
                System.out.println("Le joueur " + ((modele.getTour())%3 + 1) + " s'est noye");
                modele.setPartiePerdue(true);
            }
        }


        /** Si le joueur est n'importe ou sauf sur les bordures */
        else if(modele.compteZoneSubmerge(modele.getJ().getX(), modele.getJ().getY()) == 4) {
            System.out.println("Le joueur " + ((modele.getTour())%3 + 1) + " s'est noye");
            modele.setPartiePerdue(true);
        }


        /** Si tous les artefacts sont en la possession des joueurs
         * Et si tous les joueurs sont sur la zone de l'heliport :
         * la partie est gagnee
         */
        if(modele.getNbArtefacts() == 4) {
            if(modele.compteJoueurSurZone(modele.getHeliport().getX(), modele.getHeliport().getY()) == 3)
                modele.setPartieGagnee(true);
        }


        /** Pour l'affichage console, pour epurer on rajoute une ligne */
        if(!modele.isPerdue() && bouton == vue.boutonAvance) {
            System.out.println("");
        }
    }
}
