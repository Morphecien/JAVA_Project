package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fen {
    private JFrame fen = new JFrame();// instance de la fenêtre
    private JLabel[] tab = new JLabel[10];// instance du tableau
    private JPanel pan = new JPanel();// instance du panneau
 
    /**
     * Construteur de la classe
     */
    public Fen(){
        fen.setSize(500,100);// definition de la taille
        fen.setLayout(null);// layout a null pour position à la main
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit
 
        pan.setLayout(null); // layout a null pour position à la main
        pan.setBounds(0,0,500,100);// on definit l'emplacement et la taille
        fen.add(pan);// on ajoute
 
        for(int i = 0; i<10;i++){
 
            tab[i]= createJLabel();// on crée les JLabel et on met dans tab
            tab[i].setText(""+i);// on ajoute un numéro au passage
        }
 
        for(int i = 0; i<10;i++){
 
            /**
             * Ici on va positionner à mano les label pour bien voir l'effet
             * On leur met une largeur de 50, on en a 10 et la fenêtre fait 50
             * il doivent donc chacun à leur tour être espacé de 50px
             * donc i*50
             */
 
            tab[i].setBounds((i*50), 0, 50, 50);
            pan.add(tab[i]);
        }
 
        fen.setVisible(true);
 
 
    }
    public JLabel createJLabel(){
        JLabel jl = new JLabel();
 
        return jl;
    }
}
