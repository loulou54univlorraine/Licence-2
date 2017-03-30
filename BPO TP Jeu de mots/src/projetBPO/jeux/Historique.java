package projetBPO.jeux;

import java.util.ArrayList;

/**
 * Created by Gauthier on 30/03/2017.
 */
public class Historique {
    private ArrayList<Etat> historique;

    public Historique(){
        historique= new ArrayList<>();
    }

    public void ajouter(Etat e){
        historique.add(e);
    }

    public boolean contient(Etat e){

        boolean res=false;
        int i =0;
        while (!res && i<historique.size()){
            res = historique.get(i).equals(e);
            i=i+1;
        }
        return res;
    }

}



