package reseau.couches;

import reseau.Machine;
import reseau.Message;
import reseau.adresses.Adresse;

/**
 * @author martine
 */
public abstract class Application7 extends Couche {
    
    protected int port ;
    protected Message resultat ;                   // destiné à contenir le résutat de la requête au serveur
    protected Machine machine;

    public Application7(int port) {
        this.port = port ;
    }

    public Application7(int port, Machine m) {
        this.port = port;
        m.ajouter(port, this);

    }
    
    public int getPort() {
        return this.port ;

    }

    /**
     * @param dest adresse du destinataire
     * @param portDest port du service demandé
     * @param message
     */
    public void sendMessage(Adresse dest, int portDest, Message message) {
        // On efface le résultat de la précédente requête
        resultat = null ;
        // Afficher une trace de l'envoi
        System.out.println("Je suis "+getNom()+" et j'envoie "+message.size()+" octets : " +message);
        // Transmettre à la couche Transport
        ((Transport4)moinsUn).sendMessage(port, dest, portDest, message);
    }

    /**
     * Je reçois un message de la couche inférieure 
     * @param source adresse de la source
     * @param portSource port de la source
     * @param message
     */
    public void receiveMessage(Adresse source, int portSource, Message message) {
        message=traiter(message);
        sendMessage(source,portSource,message);
    
    }

    /**
     * 
     * @return Le résultat de la dernière requête
     */
    public Message getResultat() {
        return resultat;
    }

    protected Message traiter(Message message) {
        return message ;
    }
 
}