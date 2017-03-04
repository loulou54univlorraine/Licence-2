package reseau;
import reseau.adresses.Adresse;
import reseau.adresses.Octet;
import reseau.adresses.AdresseMac;

import java.util.ArrayList;


/**
 * @author martine
 * @version 4 déc. 2014
 */

public class Message{

    private ArrayList<Octet> aloListe;

    public Message() {
        this.aloListe = new ArrayList<Octet>(8) ;
        for (int i = 0 ; i < 8 ; i++){
            this.aloListe.add(new Octet());
        }
    }

    /**
     * Constructeur de copie
     * @param mess
     * @exception AssertionError si mess est null
     */
    public Message(Message mess){
        assert(mess!=null):"Message null";
        this.aloListe= new ArrayList<Octet>();
        aloListe=mess.aloListe;


    }

    /**
     * @param v des petits entiers qui constituent le message
     */
    public Message(short... v) {
        this.aloListe = new ArrayList<Octet>() ;
        int taille = v.length ;
        for (int i = 0 ; i < taille ; i++){
            this.aloListe.add(new Octet(v[i]));
        }
    }

    /**
     * @param v des entiers qui constituent le message
     */
    public Message(int... v) {
        this.aloListe = new ArrayList<Octet>() ;
        int taille = v.length ;
        for (int i = 0 ; i < taille ; i++){
            if (v[i] <= 255){
                this.aloListe.add(new Octet() );
                this.aloListe.add(new Octet(v[i]) );
            }else{
                Octet octetFort = new Octet((v[i]/255));
                Octet octetFaible = new Octet((v[i]%255));
                this.aloListe.add(octetFort);
                this.aloListe.add(octetFaible);
            }
        }
    }

    /**
     * @param mot
     */

    public Message(String mot) {
        this.aloListe = new ArrayList<Octet>() ;
        char[] tabLettres = mot.toCharArray();
        int taille = tabLettres.length ;
        for (int i = 0 ; i < taille ; i++){
            this.aloListe.add(i, new Octet(Character.getNumericValue(tabLettres[i])) );
        }
    }


    /**
     * @param adr
     */
    public Message(Adresse adr) {
        this.aloListe = new ArrayList<Octet>() ;
        int taille = adr.getNbreOctets() ;
        for (int i = 0 ; i < taille ; i++){
            this.aloListe.add(new Octet(adr.getOctets()[i]) );
        }

    }

    /**
     * @return le nombre d'octets
     */
    public int size() {
        return aloListe.size();
    }

    /**
     * Ajouter un petit entier à la fin
     * @param x
     */
    public void ajouter(short x) {
        int count = 0;
        if (x > 255) {
            aloListe.add(new Octet(255));
            count++;
        }
        else {
            aloListe.add(new Octet(x-255*count));
        }
    }

    /**
     * Ajouter un entier à la fin
     * @param x
     */
    public void ajouter(int x) {
        if (x <= 255){
            this.aloListe.add(new Octet() );
            this.aloListe.add(new Octet(x) );
        }else{
            Octet ocfort = new Octet((x/255));
            Octet ocfaible = new Octet((x%255));
            this.aloListe.add(ocfort);
            this.aloListe.add(ocfaible);
        }
    }

    /**
     * Ajouter un octet à la fin
     * @param o
     * @exception AssertionError si o est null
     */
    public void ajouter(Octet o) {
        assert (o != null ) : "L'octet ne peux pas etre nul.";
        aloListe.add(o);
    }

    /**
     * Concaténer un autre message
     * @param mess message à ajouter à la fin
     * @exception AssertionError si mess est null
     */
    public void ajouter(Message mess) {
        assert (mess != null ) : "Le message donné est nul.";
        int taille = mess.size() ;
        for (int i = 0 ; i < taille ; i++){
            this.aloListe.add(new Octet(mess.aloListe.get(i)) );
        }

    }

    /**
     * Ajouter les octets d'une adresse à la fin
     * @param adr
     * @exception AssertionError si adr est null
     */
    public void ajouter(Adresse adr) {
        assert (adr != null ) : "L'adresse donné est nulle.";
        int taille = adr.getNbreOctets() ;
        for (int i = 0 ; i < taille ; i++){
            this.aloListe.add(new Octet(adr.getOctets()[i]));
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder(this.size()*2);
        res.append(this.aloListe.get(0));
        for(int i = 1; i < this.aloListe.size(); i++){
            res.append(".");
            res.append(this.aloListe.get(i));
        }
        String resfinal = res.toString();
        return resfinal ;
    }

    /**
     * Extraire les 2 octets situés en index et index+1 pour en faire un entier
     * octets forts puis faibles (big endian)
     * @param index
     * @exception AssertionError si index ou index+1 n'est pas dans le domaine du tableau
     * @return un entier
     */
    public int extraireEntier(int index) {
        assert (index < this.size()-1) :"L'index donné est plus grand que le tableau d'octets";
        return (this.aloListe.get(index).getValue()* 255 ) + this.aloListe.get(index + 1).getValue();
    }

    /**
     * Extraire les nbOctets premiers octets pour en faire une adresse
     * @param nbOctets
     * @exception AssertionError si nbOctets > longueur du message
     * @return une adresse
     */
    public Adresse extraireAdresse(int nbOctets) {
        assert (nbOctets < this.aloListe.size() ) : "le nombre d'octet est plus grand que celui du message";
        Octet[] res = new Octet[nbOctets] ;
        int taille = nbOctets ;
        for (int i = 0 ; i < taille ; i++){
            res[i] = this.aloListe.get(i);
        }
        return new Adresse(res) ;
    }

    /**
     * Extraire les 6 premiers octets pour en faire une adresse Mac
     * @exception AssertionError si le message ne contient pas au moins 8 octets
     * @return une adresse Mac
     */
    public AdresseMac extraireAdresseMac() {
        assert (this.aloListe.size() <= 8 ) : "le nombre d'octet du message ne peut pas former d' adresse MAC";
        Octet[] res = new Octet[6] ;
        int taille = 6 ;
        for (int i = 0 ; i < taille ; i++){
            res[i] = this.aloListe.get(i);
        }
        return new AdresseMac(res) ;
    }

    /**
     * Transformer le message en une suite de lettres, si possible
     * @return null si l'un des octets n'est pas une lettre (maj ou min)
     */
    public String extraireChaine() {
        int[] tab = new int[this.aloListe.size()];
        char[] tabchar = new char[this.aloListe.size()];
        for (Octet o : this.aloListe){
            if (o.estUneLettre() == false ){
                return null;
            }
        }
        for (int i = 0 ; i < tab.length ; i++){
            tab[i] = this.aloListe.get(i).getValue();
            tabchar[i] = (char)tab[i] ;
        }
        String res = new String(tabchar);

        return res ;
    }

    /**
     * Augmenter de i chaque octet compris entre bi et bs
     * @param i
     * @param bi
     * @param bs
     */
    public void augmenter(int i, int bi, int bs) {
        assert (bi < bs && bs < this.aloListe.size() ) : "Erreur dans l'interval d'ajout";
        for (int j = bi-1 ; j <= bs-1 ; j++){
            this.aloListe.get(j).ajouter(i);
        }
    }

    /**
     * On enlève les i premiers éléments
     * @param i
     * @exception AssertionError si i n'est pas dans le domaine du tableau
     */
    public void supprimer(int i) {
        assert (i < this.aloListe.size() ) : "le nombre d'octets est plus petit que l'indice de suppression";
        for (int j = 0 ; j < i ; j++){
            this.aloListe.remove(0);
        }
    }

    /**
     * On enlève les éléments entre debut et fin inclus
     * @param debut
     * @param fin
     * @exception AssertionError si on n'a pas 0<=debut<=fin<size()
     */
    public void supprimer(int debut, int fin) {
        assert (0 < debut && debut < fin && fin < this.aloListe.size() ) : "L'interval de suppression n'est pas compris dans le tableau";
        int taille = fin - debut ;
        for (int j = 0 ; j < taille-1 ; j++){
            this.aloListe.remove(debut - 1);
        }
    }

}
