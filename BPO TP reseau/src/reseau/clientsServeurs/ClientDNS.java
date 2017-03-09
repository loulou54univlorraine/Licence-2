package reseau.clientsServeurs;

import reseau.Machine;
import reseau.Message;
import reseau.adresses.Adresse;
import reseau.couches.Application7;

/**
 * Created by Gauthier on 09/03/2017.
 */
public class ClientDNS extends Application7 {

    private int portDNS;
    private Adresse adresseDNS;

    public ClientDNS(int port, Machine m, Adresse adresseDNS, int portDNS) {
        super();

        this.portDNS = portDNS;
        this.adresseDNS = adresseDNS;
    }

    public void receiveMessage(Adresse source, int portSource, Message message) {
        System.out.println("Je suis " + getNom() + " et je reçois " + message);
        resultat = message;
    }

    public Adresse getAdresseIP(String nomMachine) {
        sendMessage(adresseDNS, portDNS, new Message(nomMachine));
        return resultat.extraireAdresse(4);
    }
}
