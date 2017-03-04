package calc;



abstract class Naire implements Expression {
    protected Expression[] expressions ;


    public Naire (Expression...exps) {
        expressions=new Expression[exps.length];

        for(int j=0;j<expressions.length;j++) {
            expressions[j] = exps[j];
        }
    }

    public String toString() {
        StringBuilder s1= new StringBuilder();
        s1.append(getOperateur());
        s1.append("(");
        for(int j=0;j<expressions.length;j++) {
            s1.append(expressions[j]);
            if(expressions.length-1!=j){
                s1.append(",");
            }

        }
        s1.append(")");
        return s1.toString();
        }

    public abstract String getOperateur() ;
}
