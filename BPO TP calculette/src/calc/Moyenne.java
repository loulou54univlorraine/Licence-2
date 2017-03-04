package calc;
public class Moyenne extends Naire {
    public Moyenne (Expression...exps) {
        super(exps) ;
    }
    public int valeur() {
        int somme=0;
        for(int i=0;i<expressions.length;i++){
            somme+=expressions[i].valeur();
        }
        return somme/expressions.length;
    }
    public String getOperateur() {
        return "moyenne" ;
    }
}