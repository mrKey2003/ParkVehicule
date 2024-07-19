import Vehicules.Camion;
import Vehicules.Moto;
import Vehicules.Voiture;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Park v = new Park();
        System.out.println("Avant Ajout");
        v.printl();
        System.out.println("Apres Ajout");
        v.nvVehicule(new Moto("tvs"));
        v.nvVehicule(new Voiture("tvs"));
        v.nvVehicule(new Camion("tvs"));
        v.printl();
        System.out.println("Avant Modification");
        v.printl();
        System.out.println("Apres Modification");
        v.printl();
        v.modifVehicule(0,"BMW","voiture");
        System.out.println("Avant Supression");
        v.printl();
        System.out.println("Apres Suppresion");
        v.rmVoiture(0);
        v.printl();
        System.out.println("Recherche par mark");
        v.lookVehicule("BMW");
        System.out.println("Recherche par Lettre B");
        v.lookVehiculeParL('B');
        System.out.println("Nombre de vehicule");
        v.nbrVehicule();
        System.out.println("Nombre de vehicule de type voiture");
        v.nbrVehiculeType("voiture");
        System.out.println("Liste de vehicule par type voiture");
        v.listeVehiculeType("voiture");
    }
}
