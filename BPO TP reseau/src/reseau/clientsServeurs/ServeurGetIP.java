package reseau.clientsServeurs;

import reseau.couches.Application7;
import reseau.Machine;
import reseau.Message;
import reseau.tables.DNS;

/**
 * Created by Gauthier on 09/03/2017.
 */
public class ServeurGetIP extends Application7 {
    private DNS dns;

    /**
     * @param port le port dans la couche transport
     */
    public ServeurGetIP(int port, Machine m, DNS dns) {
        super(port, m);
        this.dns = dns;
    }

    /**
     * @param message String a convertir en IP
     * @return IP
     */
    @Override
    protected Message traiter(Message message) {
        System.out.println("Je donne l'ip...");
        String nomMachine = message.extraireChaine();
        return new Message(dns.getAdresse(nomMachine));
    }

}
