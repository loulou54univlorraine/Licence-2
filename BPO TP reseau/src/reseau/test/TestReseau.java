package reseau.test;

import reseau.couches.*;
import reseau.* ;
import reseau.adresses.*;
import reseau.clientsServeurs.*;
import reseau.tables.DNS;

/**
 * @author martine
 */
public class TestReseau {

    public TestReseau() {

        String nom, nomServ, nomservDNS;
        Adresse adr, adrServ, adrservDNS;
        AdresseMac adrm, adrmServ, adrmservDNS;
        Adresse masque, masqueServ, masqueservDNS;

        //---------------------------------
        DNS dns = new DNS();
        ReseauLocal r = new ReseauLocal();


        //---------------------------------
        // Une machine DNS
        nomservDNS = "Zabadie";
        adrservDNS = new Adresse("192.23.89.41");
        adrmservDNS = new AdresseMac("AA.CD.EF.00.AA.54");
        masqueservDNS = new Adresse("255.255.0.0");
        int portservDNS = 900;
        int portClientDns = 666;
        Machine m3 = new Machine(nomservDNS, adrservDNS, adrmservDNS, masqueservDNS);
        ClientDNS clientDNS = new ClientDNS(portClientDns, m3, adrservDNS, portservDNS);
        Application7 appliServeurGetIP = new ServeurGetIP(portservDNS, m3, dns, clientDNS);

        //---------------------------------
        // Une machine
        nom = "zebulon" ;
        adr = new Adresse ("192.23.23.23") ;
        adrm = new AdresseMac("00.01.02.03.04.05") ;
        masque = new Adresse("255.255.0.0");
        int portNum = 45;
        Machine m1 = new Machine(nom, adr, adrm, masque);
        Application7 appliClientNum = new ClientNumerique(portNum, m1, clientDNS);
        //---------------------------------
        // Une autre machine
        nomServ = "Pollux";
        adrServ = new Adresse ("192.23.12.12") ;
        adrmServ = new AdresseMac("24.88.90.00.FF.AB") ;
        masqueServ = new Adresse("255.255.0.0");
        int portFoisDeux = 888;
        int portMaj = 889;
        Machine m2 = new Machine(nomServ, adrServ, adrmServ, masqueServ);
        Application7 appliServeurFoisDeux = new ServeurFoisDeux(portFoisDeux, m2, clientDNS);
        Application7 appliServeurMaj = new ServeurMaj(portMaj, m2, clientDNS);




        // ajout reseau

        r.ajouter(m1);
        r.ajouter(m2);
        r.ajouter(m3);
        dns.ajouter(nom, adr);
        dns.ajouter(nomServ, adrServ);
        dns.ajouter(nomservDNS, adrservDNS);
        //---------------------------------


        int valeur;
        Message mess, mess2, mess3, res;
        Adresse dest, dest2, dest3;
        String mot;
        String valeur2, valeur3;

        // Envoi d'un message pour *2
        valeur = 10;
        mess = new Message(valeur) ;
        dest = new Adresse("192.23.12.12");
        System.out.println("Je voudrais le *2 de l'entier "+valeur);
        appliClientNum.sendMessage(dest, portFoisDeux, mess) ;
        res = appliClientNum.getResultat() ;
        System.out.println("Et j'obtiens "+res.extraireEntier(0));
        System.out.println("------------------------------------------------------------");
        //---------------------------------
        // Envoi d'un message pour Maj
        System.out.println("envoie d'un message pour mettre en maj:\n");
        valeur2 = new String("abcdefghijklmnopqrstuvwxyz");
        mess2 = new Message(valeur2);
        dest2 = new Adresse("192.23.12.12");
        System.out.println("Je voudrais  " + valeur2 + " en majuscule");
        appliClientNum.sendMessage(dest2, portMaj, mess2) ;
        res = appliClientNum.getResultat() ;
        System.out.println("Et j'obtiens "+res.extraireChaine());
        System.out.println("------------------------------------------------------------");

        // Envoi d'un message pour getIP
        System.out.println("\nenvoie d'un message pour récupérer l'iP:\n");
        valeur3 = new String("Pollux");
        mess3 = new Message(valeur3);
        dest3 = new Adresse("192.23.89.41");
        System.out.println("Je voudrais l'ip de  " + valeur3);
        appliClientNum.sendMessage(dest3, portservDNS, mess3);
        res = appliClientNum.getResultat();
        System.out.println("Et j'obtiens " + res.extraireAdresse(4) + "\n\n");
        System.out.println("------------------------------------------------------------");


    }

    public static void main(String[] args) {
        new TestReseau();
    }

}