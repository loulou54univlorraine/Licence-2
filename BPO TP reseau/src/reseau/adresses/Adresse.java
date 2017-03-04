

package reseau.adresses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import reseau.adresses.Octet;

public class Adresse implements Iterable<Octet> {
    protected Octet[] alo;

    public Adresse(Adresse a) {
        assert a != null : "Adresse indéfinie";

        this.alo = new Octet[a.getNbreOctets()];

        for(int k = 0; k < a.getNbreOctets(); ++k) {
            this.alo[k] = new Octet(a.getOctet(k));
        }

    }

    public Adresse(Octet... al) {
        assert al != null : "Adresse indéfinie";

        this.alo = new Octet[al.length];
        this.setOctets(al);
    }

    public Adresse(int nbBits) {
        assert nbBits >= 8 && nbBits % 8 == 0 : "Nombre de bits incorrect";

        int nbOctets = nbBits / 8;
        this.alo = new Octet[nbOctets];

        for(int k = 0; k < nbOctets; ++k) {
            this.alo[k] = new Octet();
        }

    }

    public Adresse(int nbBits, int nbBitsUn) {
        assert nbBits >= 8 && nbBits % 8 == 0 : "Nombre de bits incorrect";

        assert nbBitsUn >= 0 && nbBitsUn <= nbBits : "Nombre de bits  à 1incorrect";

        int nbOctets = nbBits / 8;
        ArrayList llo = new ArrayList();
        int nbOctetsUn = nbBitsUn / 8;

        int nbO;
        for(nbO = 0; nbO < nbOctetsUn; ++nbO) {
            Octet k = new Octet();
            k.setUn();
            llo.add(k);
        }

        if(nbBitsUn % 8 != 0) {
            Octet var8 = new Octet();
            var8.setUn(nbBitsUn % 8);
            llo.add(var8);
        }

        nbO = llo.size();

        int var9;
        for(var9 = nbO; var9 < nbOctets; ++var9) {
            llo.add(new Octet());
        }

        this.alo = new Octet[llo.size()];

        for(var9 = 0; var9 < llo.size(); ++var9) {
            this.alo[var9] = (Octet)llo.get(var9);
        }

    }

    public Adresse(String s) {
        String[] spli = s.split("\\.");

        assert spli.length == 4 || spli.length == 8 || spli.length == 6 : "Nombre d\'octets incorrect";

        this.alo = new Octet[spli.length];
        int k = 0;
        String[] arr$ = spli;
        int len$ = spli.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String oc = arr$[i$];
            int val = Integer.parseInt(oc);
            this.alo[k] = new Octet(val);
            ++k;
        }

    }

    public int size() {
        return 8 * this.getNbreOctets();
    }

    public int getNbreOctets() {
        return this.alo.length;
    }

    public void masquer(Adresse masque) {
        assert masque.size() == this.size() : "Taille de masque incorrecte";

        for(int k = 0; k < this.getNbreOctets(); ++k) {
            Octet no = new Octet(this.getOctet(k));
            no.masquer(masque.getOctet(k));
            this.setOctet(no, k);
        }

    }

    public void inverser() {
        Octet[] arr$ = this.alo;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Octet o = arr$[i$];
            o.inverser();
        }

    }

    public void setOctets(Octet... alo) {
        assert alo != null : "Paramètre incorrect";

        this.alo = alo;
    }

    public Octet[] getOctets() {
        return this.alo;
    }

    public void setOctet(Octet o, int k) {
        assert k >= 0 && k < this.getNbreOctets() : "Rang incorrect " + k;

        this.alo[k] = o;
    }

    public Octet getOctet(int k) {
        assert k >= 0 && k < this.getNbreOctets() : "Rang incorrect " + k;

        return this.alo[k];
    }

    public Iterator<Octet> iterator() {
        return Arrays.asList(this.alo).iterator();
    }

    public int hashCode() {
        return this.alo[0].getValue();
    }

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            Adresse other = (Adresse)obj;
            return this.toString().equals(other.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Octet[] arr$ = this.alo;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Octet o = arr$[i$];
            sb.append(o + ".");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Adresse adr = new Adresse("192.45.43.100");

        assert adr.toString().equals("192.45.43.100");

        Adresse mask = new Adresse("255.255.255.255");
        adr.masquer(mask);

        assert mask.toString().equals("255.255.255.255");

        assert adr.toString().equals("192.45.43.100");

        adr = new Adresse("192.45.43.100");
        mask = new Adresse("255.255.255.000");
        adr.masquer(mask);

        assert mask.toString().equals("255.255.255.0");

        assert adr.toString().equals("192.45.43.0");

        adr = new Adresse(16, 8);

        assert adr.toString().equals("255.0");

        adr.inverser();

        assert adr.toString().equals("0.255");

        adr = new Adresse(32, 8);

        assert adr.toString().equals("255.0.0.0");

        adr.inverser();

        assert adr.toString().equals("0.255.255.255");

        adr = new Adresse(32, 12);

        assert adr.toString().equals("255.240.0.0");

        adr.inverser();

        assert adr.toString().equals("0.15.255.255");

        adr = new Adresse(32, 17);

        assert adr.toString().equals("255.255.128.0");

        adr.inverser();

        assert adr.toString().equals("0.0.127.255");

        adr = new Adresse(32, 17);
        Adresse adr2 = new Adresse(32, 17);

        assert adr.equals(adr2);

        assert adr.hashCode() == adr2.hashCode();

    }
}
