package vue;
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
        JPanel contenaire = new JPanel();
        JButton carte1 = new JButton("la porte d'argent");
        JButton carte2 = new JButton("la porte d'or");
        JButton carte3 = new JButton("l'heliport");
        contenaire.setLayout(new BoxLayout(contenaire, BoxLayout.PAGE_AXIS));
        contenaire.add(carte1);
        contenaire.add(carte2);
        contenaire.add(carte3);
        this.add(contenaire);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    /*class button extends Container {
        public button(){
            JButton carte1 = new JButton("carte1");
            JButton carte2 = new JButton("carte2");
            JButton carte3 = new JButton("carte3");


            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            add(carte1);
            add(carte2);
            add(carte3);

        }
        public void getButton(){

        }*/
        //Jpanel listecarte = new JPanel()
        //JPanel conteneur = new JPanel();
        /*String url = "Capture.png";
        ImageIcon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon ,JLabel.CENTER);
        this.add(label);*/


        //setLayout(new BoxLayout("carte1"));
        /*JButton carte1 = new JButton(icon);
        carte1.setBounds(10,10, 15,15);
        conteneur.add(carte1);*/
                //Jpanel listecarte = new JPanel()
                //JPanel conteneur = new JPanel()
                // String url = "Capture.png";
        /*ImageIcon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon ,JLabel.CENTER);
        this.add(label);*/
    }


}