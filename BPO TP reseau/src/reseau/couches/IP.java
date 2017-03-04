package reseau.couches;

import reseau.tables.ARP;
import reseau.Message;
import reseau.adresses.*;

/**
 * @author martine
 */
public class IP extends Reseau3 {

    static private int compteur = 0;
    protected Adresse masque ;
    private ARP arp = new ARP() ;

    /**
     * @param ici la machine où je suis
     * @param masque
     */
    public IP(Adresse ici, Adresse masque) {
        super(ici) ;
        this.masque = masque;
    }

    /**
     * @param dest
     * @param message
     * @return entête du message
     */
    public Message getEntete(Adresse dest, Message message) {
        // Longueur totale (16 bits), Identification (16 bits), Protocole (8 bits)
        // Adresse IP source (32 bits), Adresse IP destination (32 bits)
        Message entete= new Message(13+message.size());
        entete.ajouter(compteur);
        compteur++;
        entete.ajouter((short)17);
        entete.ajouter(getAdresseIP());
        entete.ajouter(dest);
        return entete;
    }

    /**
     * Utilisation de la table ARP pour retrouver l'adresseMac à partir d'une adresse IP
     * @param adr adresse IP
     * @return adresseMac associée à l'adresse IP
     */
    private AdresseMac getAdresseMac(Adresse adr) {
        return arp.get(adr);
    }

    /**
     * @return mon adresse IP
     */
    public Adresse getAdresseIP() {
        return this.adresse;
    }

    /**
     * @param dest adresse du destinataire
     * @param message
     */
    @Override
    public void sendMessage(Adresse dest, Message message) {
        Adresse masqueDest = new Adresse(dest);
        Adresse masqueSource = new Adresse(getAdresseIP());
        masqueDest.masquer(masque);
        masqueSource.masquer(masque);

        if(masqueDest.toString().equals(masqueSource.toString())){
            Message entete=getEntete(dest,message);
            entete.ajouter(message);
            message=entete;
            // Afficher une trace de l'envoi
            System.out.println("Je suis "+getNom()+" et j'envoie "+message.size()+" octets : " +message);
            // Transmettre à la couche Liaison12
            ((Liaison12)moinsUn).sendMessage(getAdresseMac(dest),message);
        }else{
            System.out.println("l'ordinateur ne fait pas partie du réseau local");
        }
    }

    @Override
    public void receiveMessage(Message message) {
        message.supprimer(5);
        Adresse adr =message.extraireAdresse(4);
        message.supprimer(8);
        // Afficher une trace de la reception
        System.out.println("Je suis "+getNom()+" et je passse "+message.size()+" octets reçus : " +message);
        ((Transport4)plusUn).receiveMessage(adr,message);
    }

}


