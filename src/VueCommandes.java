
import javax.swing.*;

/**
 * Une classe pour representer la zone contenant le bouton.
 *
 * Cette zone n'aura pas à être mise à jour et ne sera donc pas un observateur.
 * En revanche, comme la zone precedente, celle-ci est un panneau [JPanel].
 */
public class VueCommandes extends JPanel {
    /**
     * Pour que le bouton puisse transmettre ses ordres, on garde une
     * reference au modele.
     */
    private Modele modele;

    /** Tous les boutons du jeu */
    public JButton boutonGiveKey, boutonRecupKey, boutonArtefact, boutonAvance, boutonAsseche, boutonGauche, boutonDroite, boutonHaut, boutonBas;

    /** Constructeur. */
    public VueCommandes(Modele modele) {
        this.modele = modele;


        /**
         * On cree des nouveaux boutons, de classe [JButton], en precisant les
         * textes qui doivent l'etiqueter.
         * Puis on ajoute ces boutons au panneau [this].
         */
        boutonAvance = new JButton("Fin de tour");
        boutonHaut = new JButton("⇑");
        boutonAsseche = new JButton("Assecher");
        boutonGauche = new JButton("⇐");
        boutonBas = new JButton("⇓ ");
        boutonDroite = new JButton("⇒");
        boutonArtefact = new JButton("Recuperer un artefact");
        boutonRecupKey = new JButton("Recuperer une cle");
        boutonGiveKey = new JButton("Donner une cle");

        this.add(boutonAvance);
        this.add(boutonAsseche);
        this.add(boutonArtefact);
        this.add(boutonRecupKey);
        this.add(boutonGiveKey);
        this.add(boutonGauche);
        this.add(boutonHaut);
        this.add(boutonBas);
        this.add(boutonDroite);



        /**
         * Le bouton, lorsqu'il est clique par l'utilisateur, produit un
         * evenement, de classe [ActionEvent].
         *
         * On a ici une variante du schema observateur/observe : un objet
         * implementant une interface [ActionListener] va s'inscrire pour
         * "ecouter" les evenements produits par le bouton, et recevoir
         * automatiquements des notifications.
         * D'autres variantes d'auditeurs pour des evenements particuliers :
         * [MouseListener], [KeyboardListener], [WindowListener].
         *
         * Cet observateur va enrichir notre schema Modele-Vue d'une couche
         * intermediaire Contrôleur, dont l'objectif est de recuperer les
         * evenements produits par la vue et de les traduire en instructions
         * pour le modele.
         * Cette strate intermediaire est potentiellement riche, et peut
         * notamment traduire les mêmes evenements de differentes façons en
         * fonction d'un etat de l'application.
         * Ici nous avons un seul bouton realisant une seule action, notre
         * contrôleur sera donc particulierement simple. Cela necessite
         * neanmoins la creation d'une classe dediee.
         */
        Controleur ctrl = new Controleur(modele, boutonAvance, this);

        Controleur Gauche = new Controleur(modele, boutonGauche, this);
        Controleur Droit = new Controleur(modele, boutonDroite, this);
        Controleur Bas = new Controleur(modele, boutonBas, this);
        Controleur Haut = new Controleur(modele, boutonHaut, this);
        Controleur Asseche = new Controleur(modele, boutonAsseche, this);
        Controleur Artefact = new Controleur(modele, boutonArtefact, this);
        Controleur RecupKey = new Controleur(modele, boutonRecupKey, this);
        Controleur GiveKey = new Controleur(modele, boutonGiveKey, this);


        /** Enregistrement du contrôleur comme auditeur du bouton. */
        boutonAvance.addActionListener(ctrl);
        boutonDroite.addActionListener(Droit);
        boutonGauche.addActionListener(Gauche);
        boutonBas.addActionListener(Bas);
        boutonHaut.addActionListener(Haut);
        boutonAsseche.addActionListener(Asseche);
        boutonArtefact.addActionListener(Artefact);
        boutonRecupKey.addActionListener(RecupKey);
        boutonGiveKey.addActionListener(GiveKey);
    }

    /** Methode permettant de recuperer le modele */
    public Modele getModele() {
        return modele;
    }
}
