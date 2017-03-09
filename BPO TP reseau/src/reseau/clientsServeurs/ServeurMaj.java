package reseau.clientsServeurs;

import reseau.Machine;
import reseau.Message;
import reseau.couches.Application7;

import java.io.*;

/**
 * Created by Gauthier on 03/03/2017.
 */
public class ServeurMaj extends Application7{
    /**
     * @param port le port dans la couche transport
     */
    public ServeurMaj(int port, Machine m, ClientDNS clientDNS) {
        super(port, m, clientDNS);
    }

    /**
     * @param message entier à convertir en majuscule
     * @return message en maj
     */
    @Override
    protected Message traiter(Message message) {
        System.out.println("Je mets le texte en majuscule ...");
        String chaine = message.extraireChaine() ;
        return new Message(chaine.toUpperCase());
    }

}
