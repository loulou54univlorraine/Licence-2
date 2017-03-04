package calc;
public class Maximum extends Naire {
    public Maximum (Expression...exps) {
        super(exps) ;
    }
    public int valeur() {
        int k=expressions[1].valeur();
        for(int i=0;i<expressions.length;i++){
            if(expressions[i].valeur()>k){
                k=expressions[i].valeur();
            }
        }
        return k;
    }
    public String getOperateur() {
        return "max" ;
    }
}