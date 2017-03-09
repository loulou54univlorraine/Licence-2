package reseau;

import reseau.adresses.Adresse;
import reseau.adresses.AdresseMac;
import reseau.clientsServeurs.ClientDNS;
import reseau.couches.*;


import java.util.ArrayList;

/**
 * Created by Gauthier on 06/03/2017.
 */
public class Machine {

    private String nom;
    private Adresse adrIP;
    private AdresseMac adrM;
    private Adresse masque;
    private Ethernet ethernet;
    private IP ip;
    private UDP udp;


    public Machine(String nomMachine, Adresse adrIP, AdresseMac adrMac, Adresse masque) {
        this.nom = nomMachine;
        this.adrIP = adrIP;
        this.adrM = adrMac;
        this.masque = masque;
        this.ethernet = new Ethernet(adrMac);
        this.ip = new IP(adrIP, masque);
        this.udp = new UDP();

        udp.setCoucheInferieure(ip);
        ip.setCouches(udp, ethernet);
        ethernet.setCoucheSuperieure(ip);

    }

    public void ajouter(int port, Application7 appli) {
        udp.ajouter(port, appli);
        appli.setCoucheInferieure(udp);
    }

    public Liaison12 getCoucheLiaison12() {
        return ethernet;

    }

    public void setReseau(ReseauLocal rl) {
        ethernet.setReseau(rl);
    }


}
