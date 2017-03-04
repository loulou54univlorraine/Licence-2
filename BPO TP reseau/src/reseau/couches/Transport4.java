package reseau.couches;

import java.util.HashMap;
import reseau.Message;
 
import reseau.adresses.Adresse;

/**
 * @author martine
 * @version 19 nov. 2014
 */
public abstract class Transport4 extends Couche {
    
    private HashMap<Integer, Application7> portsAppli ;     // Accès aux applications via le port
    
    public Transport4() {
        portsAppli = new HashMap<>();
    }

    /**
     * Ajouter une nouvelle application avec son no de port
     * @param port
     * @param appli 
     */
    public void ajouter(int port, Application7 appli) {
        portsAppli.put(port, appli) ;
    }
    
    /**
     * @param port
     * @return l'application liée au port donné
     */
    public Application7 getApplication(int port) {
        Application7 a = portsAppli.get(port) ;
        if (a==null) throw new IllegalArgumentException("Port inconnu "+port);
        return a;
    }
   
    /**
     * Envoyer un message à un destinataire précis
     * @param portSource
     * @param dest
     * @param portDest
     * @param message 
     */
    public void sendMessage(int portSource, Adresse dest, int portDest, Message message) {
        Message entete=getEntete(portSource,dest,portDest,message);
        entete.ajouter(message);
        message=entete;
        // Afficher une trace de l'envoi
        System.out.println("Je suis "+getNom()+" et j'envoie "+message.size()+" octets : " +message);
        // Transmettre à la couche Reseau3
        ((Reseau3)moinsUn).sendMessage(dest,message);
    }


 
    public void receiveMessage(Adresse source, Message message) {

    int portSource= message.extraireEntier(0);
    int portDest= message.extraireEntier(2);
    message.supprimer(8);
    // Afficher une trace de l'envoi
    System.out.println("Je suis "+getNom()+" et je passse "+message.size()+" octets reçus : " +message);
    // Transmettre à la couche Reseau3
    getApplication(portDest).receiveMessage(source,portSource,message);
    }

    protected abstract Message getEntete(int portSource, Adresse dest, int portDest, Message message);
    
}
