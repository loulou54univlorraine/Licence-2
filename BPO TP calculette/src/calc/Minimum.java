package calc;
public class Minimum extends Naire {
    public Minimum (Expression...exps) {
        super(exps) ;
    }
    public int valeur() {
        int k=expressions[1].valeur();
        for(int i=0;i<expressions.length;i++){
            if(expressions[i].valeur()<k){
                k=expressions[i].valeur();
            }
        }
        return k;
    }
    public String getOperateur() {
        return "max" ;
    }
}