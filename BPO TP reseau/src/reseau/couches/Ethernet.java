package reseau.couches;

import reseau.Message;
import reseau.adresses.Adresse;
import reseau.adresses.AdresseMac;

/**
 * @author martine
 */
public class Ethernet extends Liaison12 {

    public Ethernet(AdresseMac am ) {
        super(am);
    }

    @Override
    public void sendMessage(AdresseMac dest, Message message) {
        Message entete=getEntete(dest,message);
        entete.ajouter(message);
        message=entete;
        // Afficher une trace de l'envoi
        System.out.println("Je suis "+getNom()+" et j'envoie "+message.size()+" octets : " +message);
        // Transmettre à la couche
        .receiveMessage(message);
    }



    /**
     * Je reçois un message de la couche moinsUn
     * @param message
     */
    @Override
    public void receiveMessage(Message message) {
        AdresseMac adr=message.extraireAdresseMac();
        message.supprimer(12);
        if(adrMac.toString().equals(adr.toString())){
            // Afficher une trace de la reception
            System.out.println("Je suis "+getNom()+" et je passse "+message.size()+" octets reçus : " +message);
            r.sendTrame(message);
        }
    }

    @Override
    protected Message getEntete(AdresseMac dest, Message message) {
        // Adresse Mac destination 48 bits), adresse Mac source (48 bits)
        Message entete= new Message(dest);
        entete.ajouter(adrMac);
        return entete;
    }
}


