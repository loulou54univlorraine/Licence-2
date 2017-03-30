package projetBPO;


import projetBPO.jeux.Dictionnaire;
import projetBPO.jeux.Etat;
import projetBPO.jeux.JeuDeMots;
import projetBPO.jeux.algos.Historique;
import projetBPO.jeux.algos.LargeurDAbord;
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
        LargeurDAbord larD= new LargeurDAbord();
        Etat jdm = new JeuDeMots("lion");
        jdm.setFinal(new JeuDeMots("peur"));


        Historique h = new Historique();
        JeuDeMots j1 = new JeuDeMots("a");
        JeuDeMots j2= new JeuDeMots("a");
        h.ajouter(j1);
        assert h.contient(j2):"histo faux";


        long startTimeProfD = System.nanoTime();
        if(profD.existeChemin(jdm)){
            System.out.println("profD :Il existe un chemin");
        }else{
            System.out.println("profD :Pas de chemin");
        }
        long estimatedTimeprofD = System.nanoTime() - startTimeProfD;
        System.out.println("\nTemps avec profD :"+estimatedTimeprofD+"\n");
        System.out.println("---------------------------------------------");
        long startTimeLarD = System.nanoTime();
        if(larD.existeChemin(jdm)){
            System.out.println("larD :Il existe un chemin");
        }else{
            System.out.println("larD :Pas de chemin");
        }
        long estimatedTimeLarD = System.nanoTime() - startTimeLarD;
        System.out.println("\nTemps avec larD :"+ estimatedTimeLarD+"\n");
        System.out.println("---------------------------------------------");

        if(estimatedTimeprofD<estimatedTimeLarD){
            System.out.println("Le plus rapide est le ProfD");
        }else{
            System.out.println("Le plus rapide est le LarD");
        }
    }
}
