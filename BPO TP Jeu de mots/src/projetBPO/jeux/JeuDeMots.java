package projetBPO.jeux;

import java.util.ArrayList;
import java.util.Iterator;


public class JeuDeMots extends Etat{
    private String mot;

    public JeuDeMots(String mot){
        this.mot = mot;
    }

    public boolean equals(Object obj){
        boolean res=false;
        if(obj instanceof JeuDeMots){
             res=mot.equals(((JeuDeMots) obj).mot);
        }
        return res;
    }

    public String toString() {
        return "Etat du jeu de mots :" +mot;
    }

    public Iterator<Etat> iterator(){
        ArrayList<Etat> mots= new ArrayList<>();
        Dictionnaire dico = Dictionnaire.getInstance();
        for (int i = 0; i < mot.length(); i++) {
            for (char j = 'a'; j <='z'; j++) {
                StringBuffer s = new StringBuffer(mot);
                s.setCharAt(i,  j);
                if(dico.contient(s.toString())&& !(s.toString().equals(mot))){
                    mots.add(new JeuDeMots(s.toString()));

                }
            }

        }
        return mots.iterator();
    }


    public static void main(String[] args) {
        Etat etat = new JeuDeMots("lion");
        etat.setFinal(new JeuDeMots("peur"));

        assert (!etat.estFinal()):"L'etat est final";
        //----------------------------------------
        Dictionnaire dico=Dictionnaire.getInstance();
        dico.setMots("lion","pion");
        for (Etat e:etat){
            System.out.println(e.toString());
            assert(e.toString().equals("Etat du jeu de mots :pion")):"Erreur avec Iterator";

        }

    }

}

