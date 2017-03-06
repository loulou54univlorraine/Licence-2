package reseau;

import reseau.adresses.Adresse;
import reseau.adresses.AdresseMac;
import reseau.couches.Liaison12;

import java.util.ArrayList;

/**
 * Created by Gauthier on 06/03/2017.
 */
public class ReseauLocal {

    private ArrayList<Liaison12> reseaux;

    public ReseauLocal() {
        reseaux = new ArrayList<Liaison12>();
    }

    public void ajouter(Machine m) {
        reseaux.add(m.getCoucheLiaison12());

    }

    public void sendTrame(Message trame) {
        for (int i = 0; i < reseaux.size(); i++) {
            reseaux.get(i).receiveMessage(trame);

        }

    }


}



