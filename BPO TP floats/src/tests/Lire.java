package tests;
import java.io.*;
import java.util.Scanner;


/**
 * Created by Gauthier on 13/03/2017.
 */
public class Lire{

    public static void main(String[] args) {
        FileReader flot;
        BufferedReader flotFiltre;
        Scanner filtre;

        int nbLignes=0;
        int somme=0;
        float moyenne;

        File chemin;
        boolean exist;

        String nomFichier;

        try{
            nomFichier=args[0];
            chemin =  new File(nomFichier);
            exist=chemin.exists();
            if(!exist){
                throw new IOException("Le fichier n'exite pas");
            }

            flot= new FileReader(nomFichier);
            flotFiltre= new BufferedReader(flot);
            filtre = new Scanner(flot);


            while(filtre.hasNextInt()){
                nbLignes++;
                somme=somme + filtre.nextInt();
            }

            moyenne = somme/nbLignes;

            System.out.println("Nombre de lignes: " + nbLignes +"\net la moyenne est: "+ moyenne);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
