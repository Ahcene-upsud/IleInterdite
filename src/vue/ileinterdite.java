package vue;
import controler.jeu;
import modele.plateauIle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ileinterdite extends JFrame {


    public static void main(String[] args) {



        ileinterdite mafenetre = new ileinterdite();//ileinterdite.setSize(600, 600);




    }

    public ileinterdite() {
        super("ile intedite");
        plateauIle plateau = new plateauIle();
        JPanel contenaire = new JPanel();
        JButton carte1 = new JButton("fin de tour");
        jeu jeu1 = new jeu(plateau , carte1);
        contenaire.setLayout(new BoxLayout(contenaire, BoxLayout.PAGE_AXIS));
        contenaire.add(carte1);
        contenaire.add(plateau);


        this.add(contenaire);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }


}