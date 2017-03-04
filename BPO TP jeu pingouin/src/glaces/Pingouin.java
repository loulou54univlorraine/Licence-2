package glaces;

import geometrie.Point;

import java.util.Random;


public class Pingouin {
    private Iceberg2D pingouin;


    public Pingouin() {
        Random g = new Random();
        int x = g.nextInt(800) + 100;
        int xh = x + 30;
        int y = g.nextInt(800) + 100;
        int yh = y - 80;
        Point p1 = new Point(x, y);
        Point p2 = new Point(xh, yh);
        pingouin = new Iceberg2D(p1, p2);
    }

    public Pingouin(Point p1, Point p2) {
        pingouin = new Iceberg2D(p1, p2);
    }

    public void deplacerPing(int xDeplacement, int yDeplacement) {
        pingouin.deplacer(xDeplacement, yDeplacement);
    }

    public Point basGauchepin() {
        return pingouin.coinEnBasAGauche();
    }

    public Point hautDroitepin() {
        return pingouin.coinEnHautADroite();

    }

    public boolean collisionIce(Iceberg2D ice1) {
        return pingouin.collision(ice1);
    }

    public Iceberg2D getPingouin() {
        return pingouin;
    }

    @Override
    public String toString() {
        return "Pingouin{" +
                "pingouin=" + pingouin +
                '}';
    }
}
