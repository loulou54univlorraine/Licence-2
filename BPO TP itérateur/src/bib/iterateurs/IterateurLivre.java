package bib.iterateurs;

import bib.Lexique;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Gauthier on 20/03/2017.
 */
public class IterateurLivre implements Iterator<String> {
    protected String titre;
    protected boolean titrelu;
    protected IterateurLexique iterateurFr;
    protected IterateurLexique iterateurAng;

    public IterateurLivre(String t,Lexique itfr, Lexique itang){
        titre=t;
        iterateurFr=itfr.iterator2();
        iterateurAng=itang.iterator2();
        titrelu=false;
    }

    public boolean hasNext(){
        return iterateurFr.hasNext() || iterateurAng.hasNext();
    }

    public String next() {
        String res;
        if (!hasNext()) throw new NoSuchElementException();

        if (!titrelu) {
            res = titre;
            titrelu=true;
        } else {
            if (iterateurFr.hasNext()) {
                res = iterateurFr.next();
            } else {
                res = iterateurAng.next();
            }

        }
        return res;
    }

}
