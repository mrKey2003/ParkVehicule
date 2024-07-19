import Vehicules.Camion;
import Vehicules.Moto;
import Vehicules.Vehicule;
import Vehicules.Voiture;
import netscape.javascript.JSObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Park pk = new Park();
        Scanner clavier = new Scanner(System.in);
        int sortie = 0;
        while (sortie != 1) {

            pk.getData();
            System.out.print("Park @ ");
            String cmd = clavier.nextLine();
            switch (cmd) {
                case "nv" -> {

                    System.out.println("Ajout d'un vehicule");
                    System.out.print("Mark du Vehicule :");
                    String mark = clavier.nextLine();
                    System.out.print("Type du Vehicule 1.voiture,2.moto,3.camion :");
                    int type = clavier.nextInt();
                    switch (type) {
                        case 1 -> pk.nvVehicule(new Voiture(mark));
                        case 2 -> pk.nvVehicule(new Moto(mark));
                        case 3 -> pk.nvVehicule(new Camion(mark));
                    }
                }
                case "exit" -> {
                    pk.saveData();
                    sortie = 1;
                }
                case "list" -> pk.printl();
                case "rm" -> {

                    System.out.print("ID du vehicule :");
                    int id = clavier.nextInt();
                    pk.rmVoiture(id);

                }
                case "mdv" -> {

                    System.out.print("Type du Vehicule 1.voiture,2.moto,3.camion :");
                    int type = clavier.nextInt();
                    System.out.print("Mark : ");
                    String mark = clavier.nextLine();
                    System.out.print("ID :");
                    int id = clavier.nextInt();
                    switch (type) {
                        case 1 -> pk.modifVehicule(id, mark, "voiture");
                        case 2 -> pk.modifVehicule(id, mark, "moto");
                        case 3 -> pk.modifVehicule(id, mark, "camion");
                    }
                }
                case "look" -> {

                    System.out.print("Mark : ");
                    String mark = clavier.nextLine();
                    pk.lookVehicule(mark);
                }
                case "lookL" -> {

                    System.out.print("Mark (Entrer une lettre): ");
                    String mark = clavier.nextLine();
                    pk.lookVehiculeParL(mark.charAt(0));
                }
                case "nbr" -> pk.nbrVehicule();
                case "nbrt" -> {

                    System.out.print("Type de vehicule 1.voiture,2.Moto,3.camion: ");
                    int type = clavier.nextInt();
                    switch (type) {
                        case 1 -> pk.nbrVehiculeType("voiture");
                        case 2 -> pk.nbrVehiculeType("moto");
                        case 3 -> pk.nbrVehiculeType("camion");
                    }
                }
                case "listT" -> {

                    System.out.print("Type de vehicule 1.voiture,2.Moto,3.camion: ");
                    int type = clavier.nextInt();
                    switch (type) {
                        case 1 -> pk.listeVehiculeType("voiture");
                        case 2 -> pk.listeVehiculeType("moto");
                        case 3 -> pk.listeVehiculeType("camion");
                    }

                }
                default -> System.out.println("Commande Inconnue");
            }
        }
    }
}
