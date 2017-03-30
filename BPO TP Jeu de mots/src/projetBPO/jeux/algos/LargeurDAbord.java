package projetBPO.jeux.algos;

import projetBPO.jeux.Etat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gauthier on 30/03/2017.
 */
public class LargeurDAbord implements IRecherche {

    @Override
    public boolean existeChemin(Etat etat) {
        Historique historique= new Historique();
        historique.ajouter(etat);
        return existeChemin(etat,historique);
    }

    public boolean existeChemin(Etat etat, Historique h){
        if (etat.estFinal()) {
            return true;
        }
        Queue<Etat> queue = new LinkedList();
        queue.add(etat);
        boolean trouve = false;
        while (!queue.isEmpty()&& !trouve){
            queue.poll();
            Iterator<Etat> ite= etat.iterator();
            while (ite.hasNext()&& !trouve){
                Etat e=ite.next();
                if(!h.contient(e)){
                    h.ajouter(e);
                    trouve=existeChemin(e,h);
                }

            }
        }
        return trouve;
    }


}
