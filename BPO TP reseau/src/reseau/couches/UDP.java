package reseau.couches;

import reseau.Message;
import reseau.adresses.Adresse;

/**
 * @author martine
 */
public class UDP extends Transport4 {

    public UDP() { 
        super();
    }
    
    @Override
    protected Message getEntete(int portSource, Adresse adrDest, int portDest, Message message) {
        Message entete= new Message(portSource);
        entete.ajouter(portDest);
        entete.ajouter(8+message.size());
        entete.ajouter(0);
        return entete;
    }

}
