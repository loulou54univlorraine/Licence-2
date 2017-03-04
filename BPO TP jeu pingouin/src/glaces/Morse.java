package glaces;

import geometrie.Point;

import java.util.Random;


public class Morse {
    private Iceberg2D morse;


    public Morse() {
        Random g = new Random();
        int x = g.nextInt(800) + 100;
        int y = g.nextInt(800) + 100;
        Point p1 = new Point(x, y);
        Point p2 = new Point(x + 30, y - 80);
        morse = new Iceberg2D(p1, p2);

    }

    public Morse(Point p1, Point p2) {
        morse = new Iceberg2D(p1, p2);
    }

    public Iceberg2D getMors() {
        return morse;
    }

    public void deplacerMors(int xDeplacement, int yDeplacement) {
        morse.deplacer(xDeplacement, yDeplacement);
    }

    public Point basGauchepin() {
        return morse.coinEnBasAGauche();
    }

    public Point hautDroitepin() {
        return morse.coinEnHautADroite();

    }


    @Override
    public String toString() {
        return "Morse{" +
                "morse=" + morse +
                '}';
    }
}


