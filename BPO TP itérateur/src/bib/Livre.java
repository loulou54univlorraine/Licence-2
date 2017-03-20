package bib;

import bib.iterateurs.IterateurLivre;

/**
 * Created by Gauthier on 20/03/2017.
 */
public class Livre implements Iterable<String> {
    protected String titre;
    protected Lexique lexiqueFran;
    protected Lexique lexiqueAngl;

    public Livre(String titre, Lexique lexiqueFran,Lexique lexiqueAngl){
        this.titre=titre;
        this.lexiqueFran=lexiqueFran;
        this.lexiqueAngl=lexiqueAngl;
    }


    public String toString() {
        StringBuilder s=new StringBuilder();
        s.append("\n");
        s.append(titre);
        s.append("\nLexique français : \n");
        s.append(lexiqueFran);
        s.append("\n\nLexique Anglais :\n");
        s.append(lexiqueAngl);
        return s.toString();
    }

    public IterateurLivre iterator(){
        return new IterateurLivre(titre,lexiqueFran,lexiqueAngl);
    }

}
