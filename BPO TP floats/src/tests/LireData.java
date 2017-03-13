package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Gauthier on 13/03/2017.
 */
public class LireData {
    public static void main(String[] args) {
        FileReader flot;
        BufferedReader flotFiltre;
        Scanner filtre;
        File chemin;
        boolean exist;

        String nomFichier;
        int[] freq = new int[26];

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


            while(filtre.hasNextLine()){
                String lettre = filtre.nextLine();

                freq[((int)lettre.charAt(0))-65]++;

            }


            for (int i = 0; i < freq.length; i++) {
                System.out.println((char)(i+'A')+ " a une frequence de "+freq[i]);
            }
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


