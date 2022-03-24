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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        JPanel contener = new JPanel();
        JButton carte1 = new JButton("carte1");

        contener.setLayout(new BoxLayout(carte1 ,BoxLayout.Y_AXIS));
        this.add(carte1);
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