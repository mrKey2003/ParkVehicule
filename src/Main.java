import Vehicules.Camion;
import Vehicules.Moto;
import Vehicules.Voiture;
import netscape.javascript.JSObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Park pk = new Park();
        Scanner clavier = new Scanner(System.in);
        int sortie  = 0;
        pk.nvVehicule(new Moto("buggati"));
        pk.nvVehicule(new Voiture("BMW"));
        pk.saveData(pk.getStock());
        pk.getData();
    }
}
