package reseau.couches;

import reseau.Message;
import reseau.ReseauLocal;
import reseau.adresses.AdresseMac;

import java.util.ArrayList;

/**
 * @author martine
 */
public abstract class Liaison12 extends Couche {
    protected AdresseMac adrMac;
    protected ReseauLocal r;

    protected Liaison12 voisin ;

    public Liaison12(AdresseMac am) {
        super( );
        adrMac = am ;
    }

    /**
     * Fixer le support physique connecté à cette couche
     * @param rl
     */
    public void setVoisin(Liaison12 rl) {
        this.voisin = rl;
    }

    public abstract void sendMessage(AdresseMac dest, Message message);

    protected abstract Message getEntete(AdresseMac des, Message message) ;

    public abstract void receiveMessage(Message message) ;

    public void setReseau(ReseauLocal rl) {
        this.r = rl;
    }
}