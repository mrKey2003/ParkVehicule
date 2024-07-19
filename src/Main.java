import Vehicules.Camion;
import Vehicules.Moto;
import Vehicules.Voiture;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Park pk = new Park();
        Scanner clavier = new Scanner(System.in);
        int sortie  = 0;
        while (sortie!=1){

            System.out.print("Park @ ");
            String cmd = clavier.nextLine();
            if(cmd.equals("nv")){

                System.out.println("Ajout d'un vehicule");
                System.out.print("Mark du Vehicule :");
                String mark = clavier.nextLine();
                System.out.print("Type du Vehicule 1.voiture,2.moto,3.camion :");
                int type = clavier.nextInt();
                switch (type){
                    case 1:pk.nvVehicule(new Voiture(mark));
                    break;
                    case 2:pk.nvVehicule(new Moto(mark));
                    break;
                    case 3:pk.nvVehicule(new Camion(mark));
                    break;
                };

            }
            else  if(cmd.equals("exit")){

                sortie = 1;
            }
            else if(cmd.equals("list")){

                pk.printl();
            }
            else if(cmd.equals("rm")){

                System.out.print("ID du vehicule :");
                int id = clavier.nextInt();
                pk.rmVoiture(id);
            }
            else if(cmd.equals("mdv")){

                System.out.print("Type du Vehicule 1.voiture,2.moto,3.camion :");
                int type = clavier.nextInt();
                System.out.print("Mark : ");
                String mark = clavier.nextLine();
                System.out.print("ID :");
                int id = clavier.nextInt();
                switch (type){
                    case 1:pk.modifVehicule(id,mark,"voiture");
                        break;
                    case 2:pk.modifVehicule(id,mark,"moto");
                        break;
                    case 3:pk.modifVehicule(id,mark,"camion");
                        break;
                };

            }
            else if(cmd.equals("look")){

                System.out.print("Mark : ");
                String mark = clavier.nextLine();
                pk.lookVehicule(mark);
            }
            else if(cmd.equals("lookL")){

                System.out.print("Mark (Entrer une lettre): ");
                String mark = clavier.nextLine();
                pk.lookVehiculeParL(mark.charAt(0));
            }
            else if(cmd.equals("nbr")){
                pk.nbrVehicule();
            }
            else if(cmd.equals("nbrt")){

                System.out.print("Type de vehicule 1.voiture,2.Moto,3.camion: ");
                int type = clavier.nextInt();
                switch (type){
                    case 1:pk.nbrVehiculeType("voiture");
                        break;
                    case 2:pk.nbrVehiculeType("moto");
                        break;
                    case 3:pk.nbrVehiculeType("camion");
                        break;
                };
            }
            else if(cmd.equals("listT")){

                System.out.print("Type de vehicule 1.voiture,2.Moto,3.camion: ");
                int type = clavier.nextInt();
                switch (type){
                    case 1:pk.listeVehiculeType("voiture");
                        break;
                    case 2:pk.listeVehiculeType("moto");
                        break;
                    case 3:pk.listeVehiculeType("camion");
                        break;
                };
            }
            else {

                System.out.println("Commande Inconnue");
            }
            clavier.close();
        }
    }
}
