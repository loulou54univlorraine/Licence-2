package bib.test;

import bib.Lexique;
import bib.Livre;

/**
 * Created by Gauthier on 20/03/2017.
 */
public class TestLivre {
    public static void main(String[] args) {


        Lexique lexfr = new Lexique(5);
        lexfr.ajouter("Baguette");
        lexfr.ajouter("Beret");
        lexfr.ajouter("Omelette du Fromage");
        lexfr.ajouter("Vin");

        Lexique lexang=new Lexique(5);
        lexang.ajouter("Pudding");
        lexang.ajouter("Fish & Chips");
        lexang.ajouter("Thé");


        Livre livre=new Livre("Le petit Robert des Clichés",lexfr,lexang);
        System.out.println(livre);

        System.out.println("\nAffichage avec IterateurLivre :");
        for(String s:livre){
            System.out.println(s);
        }

    }
}
