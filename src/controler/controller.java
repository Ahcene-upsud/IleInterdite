package controler;

import modele.Modele;
import vue.VueCommande;

import javax.swing.*;
import java.awt.event.ActionListener;

class controller implements ActionListener {
Modele modele ;
JButton bouton ;
VueCommande vue;

public controller( Modele modele , JButton bouton , VueCommande vue){
    this.modele = modele ;
    this.vue = vue;
    this.bouton = bouton;
}
public void actionPerformed(ActionListener e ){

}
}
