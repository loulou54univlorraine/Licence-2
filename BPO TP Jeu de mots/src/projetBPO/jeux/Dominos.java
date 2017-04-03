package projetBPO.jeux;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Gauthier on 30/03/2017.
 */
public class Dominos extends Etat{

    protected int numeroTete;
    protected int numeroQueue;
    protected ArrayList<Domino> dominos;

    public Dominos(int x,int y,Domino ... tab){
        numeroTete=x;
        numeroQueue=y;
        dominos= new ArrayList<Domino>();
        for(Domino d:tab){
            dominos.add(d);
        }
    }


    public Iterator<Etat> iterator() {
        ArrayList<Etat>jeuDomino = new ArrayList<>();
        for (Domino d: dominos) {
            Domino[] tabDominos= new Domino[dominos.size()-1];
            ArrayList<Domino> copyDominos= new ArrayList<>(dominos);
            copyDominos.remove(d);
            for (int i=0;i<tabDominos.length;i++){
                tabDominos[i]= copyDominos.get(i);
            }
            int extremite1= d.getExtremite1();
            int extremite2= d.getExtremite2();
            if(numeroTete==extremite1){
                jeuDomino.add(new Dominos(extremite1,numeroQueue,tabDominos));
            }
            if(numeroTete==extremite2){
                jeuDomino.add(new Dominos(extremite2,numeroQueue,tabDominos));
            }
            if(numeroQueue==extremite1){
                jeuDomino.add(new Dominos(numeroTete,extremite1,tabDominos));
            }
            if(numeroQueue==extremite2){
                jeuDomino.add(new Dominos(numeroTete,extremite2,tabDominos));
            }
        }
        return jeuDomino.iterator();
    }

    @Override
    public boolean estFinal(){
        return dominos.isEmpty();
    }


    public String toString() {
        StringBuilder s= new StringBuilder();
        s.append("Le plus a gauche est:");
        s.append(numeroTete);
        s.append("\nLe plus a droite est:");
        s.append(numeroQueue);
        s.append("\n\nListe des dominos a poser:");
        for (Domino d: dominos) {
            s.append(d);
        }
        return s.toString();
    }



}

