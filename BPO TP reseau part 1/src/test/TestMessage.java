package test;

import reseau.Message;
import reseau.adresses.Adresse;

/**
 * 2 févr. 2016
 *
 * @author brigitte wrobel-dautcourt
 */

public class TestMessage {

    public static void main(String[] args) {
        Message m,mb,mc ;

        mb = new Message(1000, 500);
        System.out.println(mb.toString());
        assert mb.toString().equals(1000/255+"."+1000%255+"."+500/255+"."+500%255);

        mc = new Message(10, 100, 50);
        System.out.println(mc.toString());
        assert mc.toString().equals("0.10.0.100.0.50");

        m = new Message();
        System.out.println(m.size());
        assert m.toString().equals("0.0.0.0.0.0.0.0");

        m = new Message(mc);
        assert mc.toString().equals("0.10.0.100.0.50");

        m = new Message(10, 100, 50);
        assert m.toString().equals("0.10.0.100.0.50");
        assert (m.size() == 6);

        m.ajouter(10);
        System.out.println(m.toString());
        assert m.toString().equals("0.10.0.100.0.50.0.10");

        m.ajouter(mc);
        assert m.toString().equals("0.10.0.100.0.50.0.10.0.10.0.100.0.50");

        System.out.println(m.extraireEntier(0));
        assert (m.extraireEntier(0)== 10);

        String teststring = m.extraireChaine();
        System.out.println(teststring);
        assert(m.extraireChaine() == null);

        m.supprimer(1);
        System.out.println(m.extraireEntier(0));
        assert(m.extraireEntier(0) == 10*255);
    }

}
