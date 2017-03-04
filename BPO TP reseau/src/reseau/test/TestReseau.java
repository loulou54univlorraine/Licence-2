package reseau.test;

import reseau.couches.*;
import reseau.* ;
import reseau.adresses.*;
import reseau.clientsServeurs.*;

/**
 * @author martine
 */
public class TestReseau {

    public TestReseau() {

        String nom,nomServ,nomServ2;
        Adresse adr,adrServ,adrServ2;
        AdresseMac adrm,adrmServ,adrmServ2;
        Adresse masque,masqueServ,masqueServ2 ;

        //---------------------------------
        // Une machine
        nom = "zebulon" ;
        adr = new Adresse ("192.23.23.23") ;
        adrm = new AdresseMac("00.01.02.03.04.05") ;
        masque = new Adresse("255.255.0.0");

        // Les couches  
        int portNum = 45;
        Ethernet ethernet = new Ethernet(adrm);
        IP ip = new IP(adr, masque);
        UDP udp = new UDP();
        Application7 appliClientNum = new ClientNumerique(portNum) ;
        udp.ajouter(portNum,appliClientNum);

        // Création des liaisons entre les couches
        appliClientNum.setCoucheInferieure(udp);
        udp.setCoucheInferieure(ip);
        ip.setCouches(udp,ethernet);
        ethernet.setCoucheSuperieure(ip);
        // A compléter


        //---------------------------------
        // Une autre machine
        nomServ = "dionysos" ;
        adrServ = new Adresse ("192.23.12.12") ;
        adrmServ = new AdresseMac("24.88.90.00.FF.AB") ;
        masqueServ = new Adresse("255.255.0.0");

        // Couches serveur
        int portFoisDeux = 888;
        Ethernet ethernetServ = new Ethernet(adrmServ);
        IP ipServ = new IP(adrServ, masqueServ);
        UDP udpServ = new UDP();
        Application7 appliServ = new ServeurFoisDeux(portFoisDeux) ;
        udpServ.ajouter(portFoisDeux,appliServ);

        // Création des liaisons entre les couches
        appliServ.setCoucheInferieure(udpServ);
        udpServ.setCoucheInferieure(ipServ);
        ipServ.setCouches(udpServ,ethernetServ);
        ethernetServ.setCoucheSuperieure(ipServ);

        //---------------------------------
        // Une autre machine
        nomServ2 = "pollux" ;
        adrServ2 = new Adresse ("192.23.89.41") ;
        adrmServ2 = new AdresseMac("AA.CD.EF.00.AA.54") ;
        masqueServ2 = new Adresse("255.255.0.0");

        // Couches serveur
        int portMaj = 888;
        Ethernet ethernetServ2 = new Ethernet(adrmServ2);
        IP ipServ2 = new IP(adrServ2, masqueServ2);
        UDP udpServ2 = new UDP();
        Application7 appliServ2 = new ServeurMaj(portMaj) ;
        udpServ2.ajouter(portMaj,appliServ2);

        // Création des liaisons entre les couches
        appliServ2.setCoucheInferieure(udpServ2);
        udpServ2.setCoucheInferieure(ipServ2);
        ipServ2.setCouches(udpServ2,ethernetServ2);
        ethernetServ2.setCoucheSuperieure(ipServ2);

        //---------------------------------
        // Liaison entre les 2 machines
        ethernet.setVoisin(ethernetServ);
        ethernetServ.setVoisin(ethernet);
        //---------------------------------



        int valeur ; Message mess, mess2,res;  Adresse dest,dest2 ; String mot ;String val;

        // Envoi d'un message pour *2
        valeur = 10;
        mess = new Message(valeur) ;
        dest = new Adresse("192.23.12.12");
        System.out.println("Je voudrais le *2 de l'entier "+valeur);
        appliClientNum.sendMessage(dest, portFoisDeux, mess) ;
        res = appliClientNum.getResultat() ;
        System.out.println("Et j'obtiens "+res.extraireEntier(0));
        //---------------------------------
        // Liaison entre les 2 machines
        ethernet.setVoisin(ethernetServ2);
        ethernetServ2.setVoisin(ethernet);
        //---------------------------------
        // Envoi d'un message pour Maj
        System.out.println("envoie d'un message pour mettre en maj:\n");
        val = new String ("abcdefghijklmnopqrstuvwxyz");
        mess2 = new Message(val) ;
        dest2 = new Adresse("192.23.89.41");
        System.out.println("Je voudrais  "+val+" en majuscule");
        appliClientNum.sendMessage(dest2, portMaj, mess2) ;
        res = appliClientNum.getResultat() ;
        System.out.println("Et j'obtiens "+res.extraireChaine());

    }

    public static void main(String[] args) {
        new TestReseau();
    }

}