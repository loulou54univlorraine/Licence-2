package projetBPO.jeux.algos;

import projetBPO.jeux.Etat;

import java.util.Iterator;

/**
 * Created by Gauthier on 30/03/2017.
 */
public class ProfondeurDAbord implements  IRecherche {

    public ProfondeurDAbord() {

    }


    private boolean existeChemin(Etat etat, Historique h) {
        if (etat.estFinal()) {
            return true;
        }
        boolean trouve = false;
        Iterator<Etat> ite = etat.iterator();
        while (!trouve && ite.hasNext()) {
            Etat e = ite.next();
            if (!h.contient(e)) {
                h.ajouter(e);
                trouve = existeChemin(e, h);
            }
        }
        return trouve;
    }

    public boolean existeChemin(Etat etat) {

        Historique historique = new Historique();
        historique.ajouter(etat);
        return existeChemin(etat, historique);

    }

}
