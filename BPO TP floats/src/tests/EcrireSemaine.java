package tests;
import java.io.*;

/**
 * Created by Gauthier on 13/03/2017.
 */
public class EcrireSemaine {
    public static void main(String[] args) {
        FileWriter flot;
        PrintWriter flotFiltre;
        String finDeLigne = System.getProperty("line.separator");
        try{
            flot = new FileWriter("semaine.txt");
            flotFiltre = new PrintWriter(new BufferedWriter(flot));
            flotFiltre.println("Lundi");
            flotFiltre.println("Mardi");
            flotFiltre.println("Mercredi");
            flotFiltre.println("Jeudi");
            flotFiltre.println("Vendredi");
            flotFiltre.println("Samedi");
            flotFiltre.println("Dimanche");
            flotFiltre.close();
        }catch(IOException e){
            System.out.println("Ma semaine commence le samedi");
        }
    }
}

