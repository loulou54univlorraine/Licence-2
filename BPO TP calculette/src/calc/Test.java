package calc ;
public class Test {
    public static void main(String[] a) {
        Nombre n1 = new Nombre(10) ;
        //System.out.println(n1);
        Nombre n2 = new Nombre(88) ;
        //System.out.println(n2);
        Maximum max1=new Maximum(n1,n2);
        //System.out.println(max1);
        assert(max1.valeur()==Math.max(n1.valeur(),n2.valeur())):"Erreur avec maximum";
        Minimum min1=new Minimum(n1,n2);
        //System.out.println(min1);
        assert(min1.valeur()==Math.min(n1.valeur(),n2.valeur())):"Erreur avec minimum";
        Somme s1 = new Somme(n1, n2) ;
        //System.out.println(s1);
        assert(s1.valeur()==(n1.valeur()+n2.valeur())):"Erreur avec somme";
        Nombre n3 = new Nombre(543) ;
        Somme s2 = new Somme(s1, n3) ;
        Difference d1 = new Difference(s2,s1);
        assert(d1.valeur()==(s2.valeur()-s1.valeur())):"Erreur avec difference";
        //System.out.println(d1);
        Produit p1= new Produit(d1,s1);
        assert(p1.valeur()==(d1.valeur()*s1.valeur())):"Erreur avec produit";
        //System.out.println(p1);
        Quotient q1= new Quotient(p1,d1);
        assert(q1.valeur()==(p1.valeur()/d1.valeur())):"Erreur avec quotient";
        //System.out.println(q1);
        Moyenne moy1 = new Moyenne(n1,n2,n3);
        assert (moy1.valeur()==(n1.valeur()+n2.valeur()+n3.valeur())/3):"Erreur avec moyenne";
        //System.out.println(moy1);
    }
}