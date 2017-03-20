package bib.iterateurs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Gauthier on 20/03/2017.
 */
public class IterateurLexique implements Iterator<String> {
    protected String[] lexique;
    protected int curseur;
    protected int nbMots;

    public IterateurLexique(String[] lexique, int taille){
        this.lexique=lexique;
        this.nbMots=taille;
        this.curseur=0;
    }

    public boolean hasNext(){
        return curseur<nbMots;
    }

    public String next(){
        if(!hasNext())throw new NoSuchElementException();
        return lexique[curseur++];
    }

}
