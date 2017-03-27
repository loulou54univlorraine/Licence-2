package projetBPO.jeux;
/**
 * Created by Gauthier on 27/03/2017.
 */
public abstract class Etat implements Iterable<Etat>{
    protected static Etat etatFinal;

    public boolean estFinal(){
        return this.equals(etatFinal);
    }

    public static void setFinal(Etat e){
        etatFinal = e;
    }

}
