package glaces;

import geometrie.Point;

import java.util.Random;


public class Ocean {
    int vitesseMorse = 5;
    Random g = new Random();
    int nbMorse;
    double[][] courrant;
    private int hauteur;
    private int largeur;
    private Iceberg2D[] tab;
    private Pingouin ping;
    private Morse[] tabmors;

    public Ocean() {
        this.hauteur = 1000;
        this.largeur = 1000;
        this.tab = new Iceberg2D[2];
        this.courrant = new double[tab.length][2];
        ping = new Pingouin();
        this.tabmors = new Morse[nbMorse];
        for (int i = 0; i < tab.length; i++) {
            int abs = g.nextInt(largeur);
            int absH;
            int ord = g.nextInt(hauteur);
            int ordH;
            absH = g.nextInt(largeur - abs) + abs;
            ordH = g.nextInt(ord);
            tab[i] = new Iceberg2D(new Point(abs, ord), new Point(absH, ordH));
            courrant[i][0] = g.nextFloat();
            courrant[i][1] = g.nextFloat();
        }
        for (int i = 0; i < tabmors.length; i++) {
            tabmors[i] = new Morse();
        }
    }

    public Ocean(int h, int l, int n, int nbMorse) {
        Random g = new Random();
        ping = new Pingouin();
        largeur = l;
        hauteur = h;
        tab = new Iceberg2D[n];
        this.courrant = new double[tab.length][2];
        this.tabmors = new Morse[nbMorse];
        for (int i = 0; i < tab.length; i++) {
            int abs = g.nextInt(largeur);
            int absH;
            int ord = g.nextInt(hauteur);
            int ordH;
            absH = g.nextInt(largeur - abs) + abs;
            ordH = g.nextInt(ord);
            tab[i] = new Iceberg2D(new Point(abs, ord), new Point(absH, ordH));
            courrant[i][0] = g.nextFloat();
            courrant[i][1] = g.nextFloat();
        }
        for (int i = 0; i < tabmors.length; i++) {
            boolean dansleau = false;
            while (!dansleau) {
                tabmors[i] = new Morse();
                dansleau = true;
                for (int j = 0; j < tab.length; j++) {
                    if (tabmors[i].getMors().collision(tab[j])) {
                        dansleau = false;
                    }

                }


            }
        }


    }

    public int getWidth() {
        return largeur;
    }

    public int getHeight() {
        return hauteur;
    }

    public int getCount() {
        return tab.length;
    }

    public int getCountMorse() {
        return tabmors.length;
    }

    public Iceberg2D getTab(int i) {
        return tab[i];
    }


    public Morse getTabMors(int i) {
        return tabmors[i];
    }


    public Pingouin getPing() {
        return ping;
    }


    int[][] getColors() {
        int[][] image = new int[largeur][hauteur];
        for (Iceberg2D ice : tab) {
            Point basGauche = ice.coinEnBasAGauche();
            Point hautDroite = ice.coinEnHautADroite();
            for (int i = (int) basGauche.getAbscisse(); i < (int) hautDroite.getAbscisse(); i++) {
                for (int j = (int) hautDroite.getOrdonnee(); j < (int) basGauche.getOrdonnee(); j++) {
                    image[i][j] = 1;
                }
            }
        }

        int iping = (int) ping.basGauchepin().getAbscisse();
        int jping = (int) ping.basGauchepin().getOrdonnee();
        for (int k = 0; k < 10; k++) {
            for (int k2 = 0; k2 < 10; k2++) {
                image[iping + k][jping - k2] = 2;

                image[iping + k + 20][jping - k2] = 2;
                image[iping + k][jping - k2 - 10] = 4;
                image[iping + k + 10][jping - k2 - 10] = 4;
                image[iping + k + 20][jping - k2 - 10] = 4;
                image[iping + k][jping - k2 - 20] = 4;
                image[iping + k + 10][jping - k2 - 20] = 4;
                image[iping + k + 20][jping - k2 - 20] = 4;
                image[iping + k][jping - k2 - 30] = 4;
                image[iping + k + 10][jping - k2 - 30] = 4;
                image[iping + k + 20][jping - k2 - 30] = 4;
                image[iping + k][jping - k2 - 40] = 4;
                image[iping + k + 10][jping - k2 - 40] = 4;
                image[iping + k + 20][jping - k2 - 40] = 4;
                image[iping + k][jping - k2 - 50] = 2;
                image[iping + k + 10][jping - k2 - 50] = 2;
                image[iping + k + 20][jping - k2 - 50] = 2;
                image[iping + k][jping - k2 - 60] = 6;
                image[iping + k + 10][jping - k2 - 60] = 4;
                image[iping + k + 20][jping - k2 - 60] = 6;
                image[iping + k][jping - k2 - 70] = 4;
                image[iping + k + 10][jping - k2 - 70] = 4;
                image[iping + k + 20][jping - k2 - 70] = 4;
            }
        }

        for (Morse mors : tabmors) {
            int i = (int) mors.basGauchepin().getAbscisse();
            int j = (int) mors.basGauchepin().getOrdonnee();
            for (int k1 = 0; k1 < 10; k1++) {
                for (int k2 = 0; k2 < 10; k2++) {
                    image[i + k1][j - k2] = 4;

                    image[i + k1 + 20][j - k2] = 4;
                    image[i + k1][j - k2 - 10] = 5;
                    image[i + k1 + 10][j - k2 - 10] = 5;
                    image[i + k1 + 20][j - k2 - 10] = 5;
                    image[i + k1][j - k2 - 20] = 5;
                    image[i + k1 + 10][j - k2 - 20] = 5;
                    image[i + k1 + 20][j - k2 - 20] = 5;
                    image[i + k1][j - k2 - 30] = 5;
                    image[i + k1 + 10][j - k2 - 30] = 5;
                    image[i + k1 + 20][j - k2 - 30] = 5;
                    image[i + k1][j - k2 - 40] = 7;
                    image[i + k1 + 10][j - k2 - 40] = 5;
                    image[i + k1 + 20][j - k2 - 40] = 7;
                    image[i + k1][j - k2 - 50] = 7;
                    image[i + k1 + 10][j - k2 - 50] = 5;
                    image[i + k1 + 20][j - k2 - 50] = 7;
                    image[i + k1][j - k2 - 60] = 6;
                    image[i + k1 + 10][j - k2 - 60] = 5;
                    image[i + k1 + 20][j - k2 - 60] = 6;
                    image[i + k1][j - k2 - 70] = 5;
                    image[i + k1 + 10][j - k2 - 70] = 5;
                    image[i + k1 + 20][j - k2 - 70] = 5;
                }
            }
        }


        return image;
    }


    public String toString() {
        String s = new String();
        s = "Ocean : \nlargeur :" + largeur + "\nhauteur :" + hauteur;
        for (int i = 0; i < tab.length; i++) {
            s = s + "\n" + tab[i];
        }
        return s;
    }

    public void deplacerIce() {
        for (int i = 0; i < tab.length; i++) {
            if (((int) tab[i].coinEnBasAGauche().getAbscisse() + courrant[i][1] <= 1) || (tab[i].coinEnHautADroite().getAbscisse() + courrant[i][1] >= (largeur - 1))) {
                courrant[i][0] = courrant[i][0] * (-1);
            }
            if ((tab[i].coinEnBasAGauche().getOrdonnee() + courrant[i][0] >= hauteur - 1) || (tab[i].coinEnHautADroite().getOrdonnee() + courrant[i][0] <= 1)) {
                courrant[i][1] = courrant[i][1] * (-1);
            }
            tab[i].deplacer(courrant[i][0], courrant[i][1]);

        }

    }


    public void deplacerMors() {
        for (int i = 0; i < tabmors.length; i++) {
            if (tabmors[i].getMors().centre().getAbscisse() < ping.getPingouin().centre().getAbscisse()) {
                tabmors[i].deplacerMors(vitesseMorse, 0);
                for (int j = 0; j < tab.length; j++) {
                    if (tabmors[i].getMors().collision(tab[j])) {
                        tabmors[i].deplacerMors(-vitesseMorse, 0);
                    }
                }
            } else {
                tabmors[i].deplacerMors(-vitesseMorse, 0);
                for (int j = 0; j < tab.length; j++) {
                    if (tabmors[i].getMors().collision(tab[j])) {
                        tabmors[i].deplacerMors(vitesseMorse, 0);
                    }
                }
            }
            if (tabmors[i].getMors().centre().getOrdonnee() < ping.getPingouin().centre().getOrdonnee()) {
                tabmors[i].deplacerMors(0, vitesseMorse);
                for (int j = 0; j < tab.length; j++) {
                    if (tabmors[i].getMors().collision(tab[j])) {
                        tabmors[i].deplacerMors(0, -vitesseMorse);
                    }
                }
            } else {
                tabmors[i].deplacerMors(0, -vitesseMorse);
                for (int j = 0; j < tab.length; j++) {
                    if (tabmors[i].getMors().collision(tab[j])) {
                        tabmors[i].deplacerMors(0, vitesseMorse);
                    }
                }
            }
        }
    }
}
