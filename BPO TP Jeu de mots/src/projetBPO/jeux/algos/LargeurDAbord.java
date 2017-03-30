package projetBPO.jeux.algos;

import projetBPO.jeux.Etat;

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
        return true;
    }


}
