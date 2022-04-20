package modele;
import vue.color;

import javax.swing.*;
import java.awt.*;

public class carteIle extends JComponent {
    int etat ; //normal:1 , submerge:2, inondée:3
    //plateauIle plateau ;
    int x,y;
    plateauIle plateau;


    public carteIle (plateauIle plateau){
    this.etat= 1;
    this.x=1;
    this.y=1;
    this.setBackground();

}

    private void setBackground() {
        this.setBackground(Color.GREEN);
    }
    public void paint(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, 60, 60);
    }

    public void monEtat(int etat){
        switch(etat){
            case 1 :
                System.out.println("ile normale");

            case 2 :
                System.out.println("ile submerge");

            case 3 :
                System.out.println("ile inondée");

            default :
                System.out.println("erreur");

        }
    }
    public int setEtat(){
        return this.etat ;
    }

    }


