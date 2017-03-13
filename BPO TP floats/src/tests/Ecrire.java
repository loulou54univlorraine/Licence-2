package tests;
import java.io.*;
import java.util.*;


/**
 * Created by Gauthier on 13/03/2017.
 */
public class Ecrire{
    public static void main(String[] args) {
        FileWriter flot;
        PrintWriter flotFiltre;
        File chemin;
        String nomChemin = args[0];
        Random r = new Random();
        int nbRandom = r.nextInt(500)+500;
        boolean exist;
        String finDeLigne = System.getProperty("line.separator");
        try{
            chemin=new File(nomChemin);
            exist=chemin.exists();
            if(exist){
                throw new IOException("Le fichier exite déja");
            }
            if(!exist){
                flot = new FileWriter(args[0]);
                flotFiltre = new PrintWriter(new BufferedWriter(flot));
                for (int i = 0; i <= nbRandom; i++) {
                    flotFiltre.println(i);
            }

            flotFiltre.close();}
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

