package reseau.tables;

import reseau.adresses.Adresse;

import java.util.HashMap;


/**
 * Created by Gauthier on 09/03/2017.
 */
public class DNS {
    private HashMap<String, Adresse> nomIP;
    private HashMap<Adresse, String> iPnom;

    public DNS() {
        nomIP = new HashMap<>();
        iPnom = new HashMap<>();
    }

    public void ajouter(String nomMachine, Adresse adrIP) {
        nomIP.put(nomMachine, adrIP);
        iPnom.put(adrIP, nomMachine);
    }

    public Adresse getAdresse(String nomMachine) {
        return nomIP.get(nomMachine);

    }

}
