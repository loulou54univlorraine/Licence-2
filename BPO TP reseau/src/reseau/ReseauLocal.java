package reseau;

import reseau.adresses.Adresse;
import reseau.adresses.AdresseMac;

import java.util.ArrayList;

/**
 * Created by Gauthier on 06/03/2017.
 */
public class ReseauLocal {

    private ArrayList<Machine> machines;

    public ReseauLocal() {
        machines = new ArrayList<Machine>();
        machines.add(new Machine("machine1", new Adresse("192.23.23.23"), new AdresseMac("00.01.02.03.04.05"), new Adresse("255.255.0.0")));


    }

    public void ajouter(Machine m) {
        machines.add(m);

    }
}

