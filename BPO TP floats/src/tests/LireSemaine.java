package tests;
import java.io.*;


/**
 * Created by Gauthier on 13/03/2017.
 */
public class LireSemaine {

    public static void main(String[] args) {
        FileReader flot;
        BufferedReader flotFiltre;
        int nbDeJour=0;
        try{
            flot= new FileReader("semaine.txt");
            flotFiltre= new BufferedReader(flot);
            String ligne= flotFiltre.readLine();
            while(ligne!= null){
                ligne = flotFiltre.readLine();
                nbDeJour++;
            }
            System.out.println("Nombre de jours :" + nbDeJour);
        }catch (IOException e){
            System.out.println("Ma vie est une longue semaine, et pour une fois j'attends pas le week-end");
        }
    }
}
