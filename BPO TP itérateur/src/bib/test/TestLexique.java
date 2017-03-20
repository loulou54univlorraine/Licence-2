package bib.test;

import bib.Lexique;
import bib.iterateurs.IterateurLexique;

/**
 * Created by Gauthier on 20/03/2017.
 */
public class TestLexique {
    public static void main(String[] args) {
        Lexique lex = new Lexique(5);
        lex.ajouter("mot");
        lex.ajouter("mots");
        lex.ajouter("maux");
        lex.ajouter("Meaux");

        System.out.println("Affichage avec itération");
        for(String s:lex){
            System.out.println(s);
        }

        System.out.println(lex);

        System.out.println("Affichage avec IterateurLexique :");
        IterateurLexique itLex = lex.iterator2();
        while (itLex.hasNext()){
            System.out.println(itLex.next());
        }


    }

}
