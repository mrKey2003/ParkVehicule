import Vehicules.Camion;
import Vehicules.Moto;
import Vehicules.Vehicule;
import Vehicules.Voiture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Park {

    private Map<Integer,Vehicule> stock = new HashMap<>();
    private int key = 0;

    public void nvVehicule(Vehicule v)  {

        this.stock.put(this.key,v);
        this.key = this.key+1;
    }

    public void getData(){

        String fileName = "b.txt"; // Nom du fichier à lire
        Map<Integer,Vehicule> dt = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tab = line.split(",");
                Vehicule v = null;
                if(tab[1].equals("voiture")) v = new Voiture(tab[2]);
                else if(tab[1].equals("moto")) v = new Moto(tab[2]);
                else if(tab[1].equals("camion")) v = new Camion(tab[2]);
                dt.put(Integer.parseInt(tab[0]),v);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
        }

        this.stock = dt;
    }
    public void saveData(){
        Map<Integer,Vehicule> dt = this.stock;
        try{

            FileWriter f = new FileWriter("b.txt",true);
            for(Map.Entry<Integer,Vehicule> v:dt.entrySet()){

                String chaine = v.getKey().toString()+""+v.getValue().toCSVType();
                f.write(chaine);
            }
            f.close();

        }catch (IOException e){

            System.out.println("Impossible D'ecrire dans le fichier :"+e.getMessage());
        }
    }
    public void rmVoiture(int ID){

        boolean exist = this.stock.containsKey(ID);
        if(exist == true){

            this.stock.remove(ID);
        }

    }

    public void modifVehicule(int ID,String mark,String type){

        boolean exist = this.stock.containsKey(ID);
        if(exist){

            this.stock.get(ID).setMark(mark);
            this.stock.get(ID).setType(type);
        }
    }

    public void printl(){

        System.out.println("==============");
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            System.out.println("ID"+v.getKey().toString()+","+v.getValue());
        }
        System.out.println("==============");

    }

    public void lookVehicule(String mark){

        boolean trouver = false;
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getMark().equals(mark)){

                System.out.println(v.getValue().toString());
                trouver = true;
                break;
            }
        }
        if(trouver == false){

            System.out.println("Aucun Vehicule ne correspond a votre Recherche");
        }
    }

    public  void lookVehiculeParL(char l){

        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getMark().charAt(0) == l){

                System.out.println(v.getValue().toString());
            }
        }
    }
    public void nbrVehicule(){

        System.out.println("Il y'a "+this.key+" vehicule(s) en stock");
    }
    public void nbrVehiculeType(String type){

        int nombre = 0;
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getType().equals(type)){
                nombre = nombre+1;
            }
        }
        System.out.println("il y'a "+nombre+" vehicule(s) de Type "+type);
    }
    public void listeVehiculeType(String type){

        System.out.println(type.toUpperCase(Locale.ROOT));
        for(Map.Entry<Integer,Vehicule> v:this.stock.entrySet()){

            if(v.getValue().getType().equals(type)){

                System.out.println(v.getValue().toString());
            }
        }
    }
}
