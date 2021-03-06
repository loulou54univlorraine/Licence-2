package reseau.clientsServeurs;

import reseau.Machine;
import reseau.couches.Application7;
import reseau.Message;
import reseau.adresses.Adresse;

/**
 * @author martine
 */
public class ClientNumerique extends Application7 {

    public ClientNumerique(int port, Machine m, ClientDNS clientDNS) {
        super(port, m, clientDNS);
    }
   
    /**
     * Je reçois un message de la couche inférieure 
     * @param source adresse de la source
     * @param portSource port de la source
     * @param message
     */
    @Override
    public void receiveMessage(Adresse source, int portSource, Message message) {
        System.out.println("Je suis "+getNom()+" et je reçois "+message);
        resultat = message ;
    } 

}
