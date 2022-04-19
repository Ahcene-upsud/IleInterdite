package controler;

import modele.Joueur;
import modele.carteIle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jeu implements ActionListener {
    carteIle a;
    JButton carte1;

public void inondeAleatoire(){
    if(a.setEtat() == 1){ //ile normale
        carte1.setBackground(Color.CYAN);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    }
}
