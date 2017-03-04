package test;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class TestAdresse {

    public static void main(String[] args) {

        Adresse adr;

        adr = new Adresse(24) ;
        assert (adr.getNbreOctets() == 3) ;
        assert(adr.size() == 24);
        assert(adr.getOctets() != null);

        adr = new Adresse(new Octet(10)) ;
        assert(adr.toString().equals("10")) ;

        adr = new Adresse("192.168.1.10");
        assert  (adr.toString().equals("192.168.1.10"));

        adr = new Adresse(32,24);
        assert(adr.toString().equals("255.255.255.0")) ;

    }

}
