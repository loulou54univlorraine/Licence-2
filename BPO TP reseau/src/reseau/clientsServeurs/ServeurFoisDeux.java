package reseau.clientsServeurs;

import reseau.Machine;
import reseau.couches.Application7;
import reseau.Message;

/**
 * @author martine
 */
public class ServeurFoisDeux extends Application7 {
    
    /**
     * @param port le port dans la couche transport
     */
    public ServeurFoisDeux(int port, Machine m, ClientDNS clientDNS) {
        super(port, m, clientDNS);
    }

    /**
     * @param message entier à convertir en * 2
     * @return entier * 2
     */
    @Override
    protected Message traiter(Message message) {
        System.out.println("Je calcule * 2...");
        int entier = message.extraireEntier(0) ;
        int res = entier * 2 ;
        return new Message(res);
    }

}
