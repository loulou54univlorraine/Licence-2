

package reseau.adresses;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class AdresseMac extends Adresse {
    public AdresseMac(Adresse a) {
        super(a);
    }

    public AdresseMac(Octet... alo) {
        super();
        this.setOctets(alo);
    }

    public AdresseMac() {
        super(48);
    }

    public AdresseMac(String s) {
        super();
        String[] spli = s.split("\\.");
        if(spli.length != 6) {
            throw new IllegalArgumentException("Nombre d\'octets incorrect");
        } else {
            Octet[] newAl = new Octet[6];
            int k = 0;
            String[] arr$ = spli;
            int len$ = spli.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String oc = arr$[i$];
                int val = Integer.parseInt(oc, 16);
                newAl[k] = new Octet(val);
                ++k;
            }

            this.setOctets(newAl);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Octet[] arr$ = this.getOctets();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Octet o = arr$[i$];
            int val = o.getValue();
            sb.append(Integer.toHexString(val) + ".");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        AdresseMac adr = new AdresseMac("00.ff.00.ff.00.ff");

        assert adr.toString().equals("0.ff.0.ff.0.ff");

        Octet[] tabO = new Octet[8];

        for(int am = 0; am < tabO.length; ++am) {
            tabO[am] = new Octet(am);
        }

        AdresseMac var5 = new AdresseMac(tabO);
        System.out.println("am : " + var5);
        AdresseMac am2 = new AdresseMac();
        System.out.println("am2 : " + am2);
    }
}
