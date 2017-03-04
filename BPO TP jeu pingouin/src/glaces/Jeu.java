package glaces;

import java.util.*;

public class Jeu {

    public static void main(String[] args) {
        int vitessePing = 6;
        Ocean oc;
        System.out.println("Bienvenue dans ce jeu de survie\n les morses veulent votre peau\n échapper vous sur les icebergs\nVous devez utiliser les touches directionnelles Z Q S D ");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Difficulté :\n facile -- 1\n moyen -- 2\n difficile -- 3\nVotre choix :\n");
        int dif = sc.nextInt();
        switch (dif) {
            case 1:
                oc = new Ocean(1000, 1000, 8, 3);
                break;
            case 2:
                oc = new Ocean(1000, 1000, 5, 5);
                break;
            case 3:
                oc = new Ocean(1000, 1000, 3, 8);
            default:
                oc = new Ocean(1000, 1000, 5, 5);
        }

        ArcticImage art = new ArcticImage(oc.getWidth(), oc.getHeight());
        art.setColors(oc.getColors());
        boolean continuer = true;

        while (i < 2000 && continuer) {
            oc.deplacerIce();
            oc.deplacerMors();

            for (int j = 0; j < oc.getCount(); j++) {
                oc.getTab(j).fondre(0.5);
                if (oc.getPing().collisionIce(oc.getTab(j)) == true) {
                    oc.getTab(j).fondre(1);
                }
            }
            for (int k = 0; k < oc.getCountMorse(); k++) {
                if (oc.getPing().collisionIce(oc.getTabMors(k).getMors()) == true) {
                    System.out.println("\nVotre score est de : " + i + " points");
                    continuer = false;
                }
            }

            System.out.println("\nVeuillez saisir une direction:");
            String str = sc.nextLine();
            if ((str.equals("Z") || str.equals("z")) && (oc.getPing().getPingouin().coinEnHautADroite().getOrdonnee() > vitessePing + 1)) {
                oc.getPing().deplacerPing(0, -vitessePing);
            }
            if (str.equals("Q") || str.equals("q") && (oc.getPing().getPingouin().coinEnBasAGauche().getAbscisse() > vitessePing + 1)) {
                oc.getPing().deplacerPing(-vitessePing, 0);
            }
            if (str.equals("S") || str.equals("s") && (oc.getPing().getPingouin().coinEnBasAGauche().getOrdonnee() < oc.getHeight() - (vitessePing + 1))) {
                oc.getPing().deplacerPing(0, vitessePing);
            }
            if (str.equals("D") || str.equals("d") && (oc.getPing().getPingouin().coinEnHautADroite().getAbscisse() < oc.getWidth() - (vitessePing + 1))) {
                oc.getPing().deplacerPing(vitessePing, 0);
            }

            art.setColors(oc.getColors());

            i++;
        }
        art.fermer();
    }
}


