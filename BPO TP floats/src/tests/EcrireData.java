package tests;
import java.io.*;
import java.util.*;


/**
 * Created by Gauthier on 13/03/2017.
 */
public class EcrireData{
    public static void main(String[] args) {
        FileWriter flot;
        PrintWriter flotFiltre;
        File chemin;
        String nomChemin = args[0];

        Random r = new Random();
        int nbLigneRandom = r.nextInt(50)+50;
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
                int val = 65 + r.nextInt(25);

                for (int i = 0; i <= nbLigneRandom; i++) {

                    int val2=r.nextInt(200)-100;
                    flotFiltre.println((char)val+" "+ val2);
                    val ++;
                    if(val>'Z'){
                        val='A';
                    }


                }

                flotFiltre.close();}
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

