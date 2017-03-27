package projetBPO.jeux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Gauthier on 27/03/2017.
 */
public class Dictionnaire implements Iterable<String>{
    protected static Dictionnaire instance= new Dictionnaire();
    private ArrayList<String> listeMots;
    private Dictionnaire(){
        listeMots= new ArrayList();
    }


    public static Dictionnaire getInstance(){
        return instance;
    }


    public void setMots(String... mots){
        listeMots= new ArrayList(mots.length);
        for (String s : mots) {
            listeMots.add(s);
        }
    }


    public boolean contient(String mot){
        boolean res=false;
        int i =0;
        while (!res && i<listeMots.size()){
            res = listeMots.get(i).equals(mot);
            i=i+1;
        }
        return res;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nDébut du Dico :\n");
        for (int i = 0; i < listeMots.size(); i++) {
            s.append("\t-"+listeMots.get(i)+"\n");
        }
        s.append("\nFin du Dico");
        return s.toString();
    }

    public Iterator<String> iterator(){
        return listeMots.iterator();
    }


    public void setMots(String nomFichier)throws IOException{
        listeMots = new ArrayList<>();
        FileReader flot;
        BufferedReader flotFiltre;
        Scanner filtre;
        File chemin;
        boolean exist;


        try{

            chemin =  new File(nomFichier);
            exist=chemin.exists();
            if(!exist){
                throw new IOException("Le fichier n'exite pas");
            }

            flot= new FileReader(nomFichier);
            flotFiltre= new BufferedReader(flot);
            filtre = new Scanner(flot);
            String ligne=flotFiltre.readLine();


            while(ligne!=null){
                listeMots.add(ligne);

                ligne=flotFiltre.readLine();

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Dictionnaire dico = Dictionnaire.getInstance();
        dico.setMots("a","b","c","d");

        assert(dico.contient("a")):"Erreur a n'est pas dans le dictionnaire";
        assert(dico.contient("b")):"Erreur b n'est pas dans le dictionnaire";
        assert(dico.contient("c")):"Erreur c n'est pas dans le dictionnaire";
        assert(dico.contient("d")):"Erreur d n'est pas dans le dictionnaire";


        dico.setMots("Dictionnaires/dico4.txt");
        assert (dico.listeMots.size()==979):"Erreur avec l'implémentation du dictionnaire";

    }
}
