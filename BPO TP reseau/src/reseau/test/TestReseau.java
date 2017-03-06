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
        int portNum = 45;
        Machine m1 = new Machine(nom, adr, adrm, masque);
        Application7 appliClientNum = new ClientNumerique(portNum);
        m1.ajouter(portNum, appliClientNum);

        //---------------------------------
        // Une autre machine
        nomServ = "dionysos" ;
        adrServ = new Adresse ("192.23.12.12") ;
        adrmServ = new AdresseMac("24.88.90.00.FF.AB") ;
        masqueServ = new Adresse("255.255.0.0");

        // Couches serveur
        int portFoisDeux = 888;
        int portMaj = 889;
        Machine m2 = new Machine(nomServ, adrServ, adrmServ, masqueServ);
        Application7 appliServeurFoisDeux = new ServeurFoisDeux(portFoisDeux);
        ReseauLocal r = new ReseauLocal();
        r.ajouter(m1);
        r.ajouter(m2);
        m2.ajouter(portFoisDeux, appliServeurFoisDeux);
        Application7 appliServeurMaj = new ServeurMaj(portMaj);
        m2.ajouter(portMaj, appliServeurMaj);
        //---------------------------------



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
        // Envoi d'un message pour Maj
        System.out.println("envoie d'un message pour mettre en maj:\n");
        val = new String ("abcdefghijklmnopqrstuvwxyz");
        mess2 = new Message(val) ;
        dest2 = new Adresse("192.23.12.12");
        System.out.println("Je voudrais  "+val+" en majuscule");
        appliClientNum.sendMessage(dest2, portMaj, mess2) ;
        res = appliClientNum.getResultat() ;
        System.out.println("Et j'obtiens "+res.extraireChaine());

    }

    public static void main(String[] args) {
        new TestReseau();
    }

}