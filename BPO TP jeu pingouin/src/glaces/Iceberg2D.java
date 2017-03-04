package glaces;

import geometrie.*;
import geometrie.Point;

/**
 * Un iceberg rectangulaire
 *
 * @author Martine Gautier, Université de Lorraine
 * @version Février 2014
 */
public class Iceberg2D {

    private Point enBasAGauche;
    private Point enHautADroite;

    /**
     * @param g le coin en bas à gauche
     * @param d le coin en haut à droite
     *          uniquement en coordonnées positives
     */
    public Iceberg2D(Point g, Point d) {
        this.enBasAGauche = new Point(g);
        this.enHautADroite = new Point(d);
    }


    public Iceberg2D(Iceberg2D i1, Iceberg2D i2) {
        double abs1;
        double ord1;
        if (i1.enBasAGauche.getAbscisse() < i2.enBasAGauche.getAbscisse()) {
            abs1 = i1.enBasAGauche.getAbscisse();
        } else {
            abs1 = i2.enBasAGauche.getAbscisse();
        }

        if (i1.enBasAGauche.getOrdonnee() > i2.enBasAGauche.getOrdonnee()) {
            ord1 = i1.enBasAGauche.getOrdonnee();
        } else {
            ord1 = i2.enBasAGauche.getOrdonnee();
        }
        this.enBasAGauche = new Point(abs1, ord1);

        double abs2;
        double ord2;
        if (i1.enHautADroite.getAbscisse() > i2.enHautADroite.getAbscisse()) {
            abs2 = i1.enHautADroite.getAbscisse();
        } else {
            abs2 = i2.enHautADroite.getAbscisse();
        }

        if (i1.enHautADroite.getOrdonnee() < i2.enHautADroite.getOrdonnee()) {
            ord2 = i1.enHautADroite.getOrdonnee();
        } else {
            ord2 = i2.enHautADroite.getOrdonnee();
        }
        this.enHautADroite = new Point(abs2, ord2);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(4.0, 4.0);
        Iceberg2D ice1 = new Iceberg2D(p1, p2);
        Point p3 = new Point(0.0, 0.0);
        Point p4 = new Point(5.0, 5.0);
        Iceberg2D ice2 = new Iceberg2D(p3, p4);
        Iceberg2D ice3 = new Iceberg2D(ice1, ice2);
        System.out.println(ice1);
        System.out.println(ice2);
        System.out.println(ice1.collision(ice2));
        //System.out.println(ice3);
        //System.out.println("hauteur :"+ice1.hauteur()+ "\nlargeur :"+ice1.largeur() +  "\nsurface :"+ice1.surface());
        //ice1.fondre(1);
        //ice1.casserHaut(1);
        //ice1.casserGauche(2);
        //System.out.println(ice1);
        //System.out.println("hauteur :"+ice1.hauteur()+ "\nlargeur :"+ice1.largeur() +  "\nsurface :"+ice1.surface());
    }

    /**
     * @return le coin en bas à gauche
     */
    public Point coinEnBasAGauche() {
        Point p = new Point(this.enBasAGauche);
        return p;
    }

    /**
     * @return le coin en haut à droite
     */
    public Point coinEnHautADroite() {
        Point p = new Point(this.enHautADroite);
        return p;
    }

    /**
     * @return hauteur
     */
    public double hauteur() {
        return this.enHautADroite.getOrdonnee() - this.enBasAGauche.getOrdonnee();
    }

    /**
     * @return largeur
     */
    public double largeur() {
        return this.enHautADroite.getAbscisse() - this.enBasAGauche.getAbscisse();
    }

    /**
     * @return surface totale
     */
    public double surface() {
        return this.largeur() * this.hauteur();
    }

    /**
     * @param i
     * @return vrai si collision entre les deux icebergs
     */
    public boolean collision(Iceberg2D i) {
        boolean b1 = true;
        if (this.enHautADroite.getOrdonnee() > i.enBasAGauche.getOrdonnee() || this.enBasAGauche.getOrdonnee() < i.enHautADroite.getOrdonnee() || this.enBasAGauche.getAbscisse() > i.enHautADroite.getAbscisse() || this.enHautADroite.getAbscisse() < i.enBasAGauche.getAbscisse()) {

            b1 = false;

        }
        return b1;
    }

    /**
     * @param i
     * @return vrai si this est plus volumineux que i
     */
    public boolean estPlusGrosQue(Iceberg2D i) {
        if (this.surface() > i.surface()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String s1 = "Iceberg :\n P1 = " + enBasAGauche.toString() + " \n P2 = " + enHautADroite.toString();
        return s1;
    }

    /**
     * @return le point au centre de l'iceberg
     */
    public Point centre() {
        Segment seg1 = new Segment(this.enBasAGauche, this.enHautADroite);
        return seg1.milieu();
    }

    /**
     * Réduction dans les quatre directions ; le centre ne bouge pas
     *
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void fondre(double fr) {


        this.enBasAGauche.deplacer(fr, -fr);
        this.enHautADroite.deplacer(-fr, fr);

    }

    /**
     * Casser une partie à droite
     *
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserDroite(double fr) {
        this.enHautADroite.deplacer(-fr, 0);
    }

    /**
     * Casser une partie à gauche
     *
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserGauche(double fr) {
        this.enBasAGauche.deplacer(fr, 0);
    }

    /**
     * Casser une partie en haut
     *
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserHaut(double fr) {
        this.enHautADroite.deplacer(0, -fr);
    }

    /**
     * Casser une partie en bas
     *
     * @param fr dans ]0..1[ : définit le pourcentage supprimé
     */
    public void casserBas(double fr) {
        this.enBasAGauche.deplacer(0, fr);
    }

    public void deplacer(double x, double y) {
        this.enBasAGauche.deplacer(x, y);
        this.enHautADroite.deplacer(x, y);
    }

}
