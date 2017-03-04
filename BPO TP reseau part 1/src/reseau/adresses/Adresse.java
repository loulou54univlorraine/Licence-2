package reseau.adresses;


/**
 * @author martine
 * @version 20 nov. 2014
 */

public class Adresse {
    protected Octet[] alo;

    protected Adresse() {
        int taille = 4;
        alo = new Octet[taille];
        for (int i = 0; i < alo.length; i++) {
            alo[i] = new Octet();
        }

    }

    /**
     * Constructeur de copie
     *
     * @param a
     * @throws AssertionError si a est null
     */
    public Adresse(Adresse a) {
        assert (a != null) : "Adresse nulle";
        int taille = a.getNbreOctets();
        for (int i = 0 ; i < taille ; i++){
            this.alo[i] = new Octet(a.alo[i]);
        }
    }

    /**
     * @param al octets
     * @throws AssertionError si al est null
     */
    public Adresse(Octet... al) {
        assert (al != null) : "Adresse nulle";
        alo = new Octet[al.length];
        for (int i = 0; i < al.length; i++) {
            alo[i] = new Octet(al[i]);
        }
    }

    /**
     * Adresse 0
     *
     * @param nbBits nombre de bits
     * @throw AssertionError si le nombre total de bits n'est pas un multiple de 8 supérieur ou égal à 8
     */
    public Adresse(int nbBits) {
        assert (nbBits % 8 == 0) : "Erreur avec le nombre de bits";
        alo = new Octet[nbBits / 8];
        for (int i = 0; i < nbBits / 8; i++) {
            alo[i] = new Octet();

        }

    }

    /**
     * Adresse masque
     *
     * @param nbBits   nombre de bits total
     * @param nbBitsUn nombre de bits à 1
     * @throws AssertionError si le nombre total de bits n'est pas un multiple de 8 supérieur ou égal à 8
     * @throws AssertionError si le nombre total de 1 est incorrect (négatif ou supérieur à nbBits)
     */
    public Adresse(int nbBits, int nbBitsUn) {
        assert (nbBits % 8 == 0) : "Erreur avec le nombre de bits";
        assert (nbBitsUn < nbBits) : "Trop de bits à un";
        assert (nbBitsUn > 0) : "Nombre négatif de bits à un";
        int nbOctetUn = nbBitsUn / 8;
        alo = new Octet[nbBits / 8];
        int k = 0;
        for (int i = 0; i < nbBits / 8; i++) {
            alo[i] = new Octet();
        }
        for (k = 0; k < nbOctetUn; k++) {
            alo[k].setUn(8);
        }
        alo[k].setUn(nbBitsUn % 8);
    }

    /**
     * @param s notation décimale pointée d'une adresse (par ex : 245.156.0.0)
     * @throws AssertionError si le nombre d'octets est différent de 4, 6, 8 ou si un entier est trop grand
     */
    public Adresse(String s) {
        String[] morceau = s.split("\\.");
        assert (morceau.length == 4 || morceau.length == 6 || morceau.length == 8) : "Nombre d'octet faux";
        int[] adresse = new int[morceau.length];
        alo = new Octet[adresse.length];
        for (int i = 0; i < morceau.length; i++) {
            adresse[i] = Integer.parseInt(morceau[i]);
            assert (adresse[i] < 256) : "Entier trop grand";
            alo[i] = new Octet(adresse[i]);
        }
    }

    /**
     * @return le nombre de bits
     */
    public int size() {
        return alo.length * 8;
    }

    /**
     * @return le nombre d'octets
     */
    public int getNbreOctets() {
        return alo.length;
    }

    /**
     * Appliquer un masque
     *
     * @param masque masque à appliquer
     * @throws AssertionError si le masque et le receveur ne sont pas de la même taille
     */
    public void masquer(Adresse masque) {
        assert (alo.length == masque.getNbreOctets()) : "Adresse et masque de tailles différentes";
        for (int i = 0; i < alo.length; i++) {
            alo[i].masquer(masque.getOctet(i));
        }
    }

    /**
     * Inverser les octets (0 -> 1, 1 -> 0)
     */
    public void inverser() {
        for (Octet o : this.alo) {
            o.inverser();
        }
    }

    /**
     * Fixer les octets
     *
     * @param alo2 octets
     * @throws AssertionError si alo est null
     */
    public void setOctets(Octet... alo2) {
        assert (alo != null) : "alo est null";
        alo = alo2;
    }

    /**
     * Fixer un des octets de l'adresse
     *
     * @param o octet
     * @param k rang de l'octet
     * @throws AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public void setOctet(Octet o, int k) {
        assert (k > 0 && k < alo.length) : "k inérieur à 0 ou supérieur au nombre d'octet";
        alo[k] = o;
    }

    /**
     * Retourne le tableau d'octets composant l'adresse
     *
     * @return tableau d'octets composant l'adresse
     */
    public Octet[] getOctets() {
        return this.alo;
    }

    /**
     * Consulter un des octets de l'adresse
     *
     * @param k rang de l'octet
     * @throws AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public Octet getOctet(int k) {
        assert (k >= 0 && k < alo.length) : "Erreur, 0 < k < tab.length";
        return alo[k];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < alo.length; i++) {
            sb.append(alo[i]);
            if (i < alo.length - 1) {
                sb.append(".");
            }

        }
        return sb.toString();
    }

}
