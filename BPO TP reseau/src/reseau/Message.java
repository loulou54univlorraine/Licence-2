

package reseau;

import java.util.ArrayList;
import java.util.Iterator;
import reseau.adresses.Adresse;
import reseau.adresses.AdresseMac;
import reseau.adresses.Octet;

public class Message implements Iterable<Octet> {
    protected ArrayList<Octet> alo;

    public Message() {
        this.alo = new ArrayList();
    }

    public Message(Message mess) {
        assert mess != null : "Message indéfini :" + mess;

        this.alo = new ArrayList(mess.alo);
    }

    public Message(short... v) {
        this.alo = new ArrayList();
        short[] arr$ = v;
        int len$ = v.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            short x = arr$[i$];
            this.alo.add(new Octet(x));
        }

    }

    public Message(int... v) {
        this.alo = new ArrayList();
        int[] arr$ = v;
        int len$ = v.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            int x = arr$[i$];
            this.ajouter(x);
        }

    }

    public Message(String mot) {
        this.alo = new ArrayList();
        char[] tabC = mot.toCharArray();
        char[] arr$ = tabC;
        int len$ = tabC.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            char c = arr$[i$];
            short s = (short)c;
            this.ajouter(s);
        }

    }

    public Message(Adresse adr) {
        this.alo = new ArrayList();
        this.ajouter(adr);
    }

    public int size() {
        return this.alo.size();
    }

    public void ajouter(short x) {
        this.alo.add(new Octet(x));
    }

    public void ajouter(int x) {
        int xForts = x / 128;
        int xFaibles = x % 128;
        this.alo.add(new Octet(xForts));
        this.alo.add(new Octet(xFaibles));
    }

    public void ajouter(Octet o) {
        assert o != null : "Octet indéfini :" + o;

        this.alo.add(o);
    }

    public void ajouter(Message mess) {
        assert mess != null : "Message indéfini :" + mess;

        Iterator i$ = mess.iterator();

        while(i$.hasNext()) {
            Octet o = (Octet)i$.next();
            this.ajouter(o);
        }

    }

    public void ajouter(Adresse adr) {
        assert adr != null : "Adresse indéfinie :" + adr;

        Iterator i$ = adr.iterator();

        while(i$.hasNext()) {
            Octet o = (Octet)i$.next();
            this.ajouter(o);
        }

    }

    public String toString() {
        return this.alo.toString();
    }

    public Iterator<Octet> iterator() {
        return this.alo.iterator();
    }

    public int extraireEntier(int index) {
        assert index >= 0 && index <= this.alo.size() - 1 : "Index incorrect :" + index;

        Octet forts = this.alo.get(index);
        Octet faibles = this.alo.get(index + 1);
        return forts.getValue() * 128 + faibles.getValue();
    }

    public Adresse extraireAdresse(int nbOctets) {
        assert nbOctets <= this.alo.size() : "Nb octets incorrect = " + nbOctets;

        Octet[] octets = new Octet[nbOctets];

        for(int k = 0; k < nbOctets; ++k) {
            octets[k] = this.alo.get(k);
        }

        return new Adresse(octets);
    }

    public AdresseMac extraireAdresseMac() {
        assert this.alo.size() >= 6 : "Message trop petit ";

        Octet[] octets = new Octet[6];

        for(int k = 0; k < 6; ++k) {
            octets[k] = this.alo.get(k);
        }

        return new AdresseMac(octets);
    }

    public String extraireChaine() {
        StringBuilder sb = new StringBuilder("");
        Iterator i$ = this.alo.iterator();

        while(true) {
            Octet o;
            do {
                if(!i$.hasNext()) {
                    return sb.toString();
                }

                o = (Octet)i$.next();
            } while(!o.estUneLettre() && !o.estUnPoint());

            sb.append((char)o.getValue());
        }
    }

    public void augmenter(int i, int bi, int bs) {
        Iterator i$ = this.alo.iterator();

        while(i$.hasNext()) {
            Octet o = (Octet)i$.next();
            if(o.getValue() >= bi && o.getValue() <= bs) {
                o.ajouter(i);
            }
        }

    }

    public void supprimer(int i) {
        assert i < this.alo.size() && i >= 0 : "Argument incorrect";

        for(int k = 0; k < i; ++k) {
            this.alo.remove(0);
        }

    }

    public void supprimer(int debut, int fin) {
        assert 0 <= debut && debut <= fin & fin < this.size() : "Arguments incorrects";

        for(int k = debut; k <= fin; ++k) {
            this.alo.remove(debut);
        }

    }

    public static void main(String[] args) {
        Message m = new Message(10, 20, 30);

        assert m.toString().equals("[0, 10, 0, 20, 0, 30]");

        m.supprimer(3);

        assert m.toString().equals("[20, 0, 30]");

        m.ajouter(new Message(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));

        assert m.toString().equals("[20, 0, 30, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8]");

        m.supprimer(3);

        assert m.toString().equals("[0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8]");

        m.supprimer(2, 9);

        assert m.toString().equals("[0, 1, 0, 6, 0, 7, 0, 8]");

        m.supprimer(4, 5);

        assert m.toString().equals("[0, 1, 0, 6, 0, 8]");

        m = new Message(1, 2, 3, 4, 5, 6, 7, 8);
        Adresse a = m.extraireAdresse(6);

        assert a.toString().equals("0.1.0.2.0.3");

        m = new Message();
        short valeur = 300;
        m.ajouter(300);

        assert m.extraireEntier(0) == valeur;

        m = new Message();
        m.ajouter(new AdresseMac("12.AA.23.00.CD.EF"));
        AdresseMac am = m.extraireAdresseMac();

        assert am.toString().equals("12.aa.23.0.cd.ef");

        m = new Message("aaaaa");
        String v = m.extraireChaine();

        assert v.equals("aaaaa");

        m.augmenter(-32, 97, 122);
        v = m.extraireChaine();

        assert v.equals("AAAAA");

    }
}
