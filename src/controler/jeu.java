package controler;

import modele.Joueur;
import modele.carteIle;
import modele.plateauIle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jeu implements ActionListener {
    plateauIle a;
    JButton carte1;
public jeu(plateauIle a , JButton carte1){
    this.a = a ;
    this.carte1 = carte1;
}



    @Override
    public void actionPerformed(ActionEvent event ) {
            a.inondeAleatoire();
    }

}
