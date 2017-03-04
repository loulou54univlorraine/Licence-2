package glaces;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ArcticImage extends JFrame {
    protected static int OCEAN = 1007296;
    protected static int GLACE = 16777215;
    protected static int PINGU2 = 13731860;
    protected static int PINGU3 = 7029777;
    protected static int NEANT = 0;
    protected static int NOIR = 0;
    protected static int BRUN = 8738856;
    protected static int ROUGE = 16711680;
    protected static int GRIS = 11776947;
    private JLabel jlabel;

    public ArcticImage(int largeur, int hauteur) {
        super("ArcticGame");
        //System.out.println("largeur " + largeur);
        //System.out.println("hauteur : " + hauteur);
        this.jlabel = new JLabel();
        this.jlabel.setPreferredSize(new Dimension(largeur, hauteur));
        this.add(this.jlabel, "Center");
        this.pack();
        this.setLocationRelativeTo((Component) null);
        this.setVisible(true);
    }

    public void setColors(int[][] tab) {
        int largeur = tab.length;
        int hauteur = tab[0].length;
        BufferedImage image = new BufferedImage(largeur, hauteur, 1);

        for (int x = 0; x < largeur; ++x) {
            for (int y = 0; y < hauteur; ++y) {
                int couleur;
                switch (tab[x][y]) {
                    case 0:
                        couleur = OCEAN;
                        break;
                    case 1:
                        couleur = GLACE;
                        break;
                    case 2:
                        couleur = PINGU2;
                        break;
                    case 3:
                        couleur = PINGU3;
                        break;
                    case 4:
                        couleur = NOIR;
                        break;
                    case 5:
                        couleur = BRUN;
                        break;
                    case 6:
                        couleur = ROUGE;
                        break;
                    case 7:
                        couleur = GRIS;
                        break;
                    default:
                        couleur = NEANT;
                }

                image.setRGB(x, y, couleur);
            }
        }

        this.jlabel.setIcon(new ImageIcon(image));
    }

    public void fermer() {
        this.dispose();
    }
}
