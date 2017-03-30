package projetBPO;


import projetBPO.jeux.Dictionnaire;
import projetBPO.jeux.Etat;
import projetBPO.jeux.JeuDeMots;
import projetBPO.jeux.algos.ProfondeurDAbord;

import java.io.IOException;

/**
 * Created by Gauthier on 30/03/2017.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Dictionnaire dico = Dictionnaire.getInstance();
        dico.setMots("Dictionnaires/dico4.txt");
        ProfondeurDAbord profD= new ProfondeurDAbord();
        Etat jdm = new JeuDeMots("lion");
        jdm.setFinal(new JeuDeMots("peur"));
        if(profD.existeChemin(jdm)){
            System.out.println("il existe un chemin");
        }else{
            System.out.println("Pas de chemin");
        }

    }
}
