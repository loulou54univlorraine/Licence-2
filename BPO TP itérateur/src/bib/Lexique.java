package bib;


import bib.iterateurs.IterateurLexique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * Created by Gauthier on 20/03/2017.
 */
public class Lexique implements Iterable<String> {
    private int nbMots;
    private String[] lexique;

    public Lexique(int capacite){
        lexique= new String[capacite];
        nbMots = 0;
    }

    public void ajouter(String mot){
        lexique[nbMots]=new String(mot);
        nbMots++;
    }

    public int nbMots(){
        return nbMots;
    }

    public int getCapacite(){
        return lexique.length;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Le lexique contient les mots :");
        for (int i = 0; i < nbMots; i++) {
            s.append("\n"+lexique[i] );
        }
        return s.toString();
    }


    public Iterator<String> iterator() {
        ArrayList<String> listemot =  new ArrayList<>(nbMots);
        for (int i = 0; i < nbMots; i++) {
            listemot.add(lexique[i]);
        }
        return listemot.iterator();
    }

    public IterateurLexique iterator2() {

        return new IterateurLexique(lexique,nbMots);
    }
}
