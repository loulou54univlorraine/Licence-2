package projetBPO.jeux;

/**
 * Created by Gauthier on 03/04/2017.
 */
public class Domino{

    protected int extremite1;
    protected int extremite2;

    public Domino(int x, int y){
        this.extremite1=x;
        this.extremite2=y;
    }


    public int getExtremite1() {
        return extremite1;
    }

    public int getExtremite2() {
        return extremite2;
    }

    public boolean equals(Domino d) {

        return  ((d.extremite1==extremite1&&d.extremite2==extremite2)||(d.extremite2==extremite1&&d.extremite1==extremite2));
    }



    public String toString() {
        return "Domino{" +
                extremite1
                +" - "+ extremite2 +
                "}";
    }
}
