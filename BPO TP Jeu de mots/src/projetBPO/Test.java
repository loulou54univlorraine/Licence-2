package projetBPO;


import projetBPO.jeux.Dictionnaire;
import projetBPO.jeux.Etat;
import projetBPO.jeux.JeuDeMots;
import projetBPO.algos.Historique;
import projetBPO.algos.LargeurDAbord;
import projetBPO.algos.ProfondeurDAbord;
import projetBPO.jeux.*;

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

        Etat jeuDom1 = new Dominos(4, 2, new Domino[]{new Domino(1, 4), new Domino(1, 2), new Domino(2, 2), new Domino(5, 2)});
        Etat jeuDom2 = new Dominos(5, 1, new Domino[]{new Domino(1, 2), new Domino(3, 3)});
        assert(!profD.existeChemin(jeuDom2)):"Erreur avec le code";


        Historique h = new Historique();
        JeuDeMots j1 = new JeuDeMots("a");
        JeuDeMots j2= new JeuDeMots("a");
        h.ajouter(j1);
        assert h.contient(j2):"histo faux";

        Etat[] tabEtats = new Etat[]{jeuDom1,jdm};

        for (int i = 0; i < tabEtats.length; i++) {

            switch (i){
                case 0:
                    System.out.println("Jeu de Domino");
                    break;
                case 1:
                    System.out.println("Jeu de mot");
                    break;
            }

            long startTimeProfD = System.nanoTime();
            if (profD.existeChemin(tabEtats[i])) {
                System.out.println("profD :Il existe un chemin");
            } else {
                System.out.println("profD :Pas de chemin");
            }
            long estimatedTimeprofD = System.nanoTime() - startTimeProfD;
            System.out.println("\nTemps avec profD :" + estimatedTimeprofD + "\n");
            System.out.println("---------------------------------------------");
            long startTimeLarD = System.nanoTime();
            if (larD.existeChemin(tabEtats[i])) {
                System.out.println("larD :Il existe un chemin");
            } else {
                System.out.println("larD :Pas de chemin");
            }
            long estimatedTimeLarD = System.nanoTime() - startTimeLarD;
            System.out.println("\nTemps avec larD :" + estimatedTimeLarD + "\n");
            System.out.println("---------------------------------------------");

            if (estimatedTimeprofD < estimatedTimeLarD) {
                System.out.println("Le plus rapide est le ProfD");
            } else {
                System.out.println("Le plus rapide est le LarD");
            }
            System.out.println("---------------------------------------------");

        }

    }
}
