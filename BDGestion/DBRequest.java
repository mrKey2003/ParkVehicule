package BDGestion;

import Vehicules.Camion;
import Vehicules.Moto;
import Vehicules.Vehicule;
import Vehicules.Voiture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBRequest {

    public static Map<Integer, Vehicule> RQ(DBconnexion instance, String rq){

        Map<Integer,Vehicule> tab = new HashMap<>();
        try{

            Connection con = instance.getConnection();
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(rq);
            while(result.next()){

                Vehicule v = new Vehicule(result.getString("type"),result.getString("mark"));
                switch (result.getString("type")){

                    case "voiture" -> v = new Voiture(result.getString("mark"));
                    case "moto" -> v = new Moto(result.getString("mark"));
                    case "camion" -> v = new Camion(result.getString("mark"));
                }

                tab.put(result.getInt("id"),v);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return tab;
    }
    public  static boolean RQt(DBconnexion instance,String rq){

        boolean result = false;
        try{

            Connection con = instance.getConnection();
            Statement st = con.createStatement();
            result = st.execute(rq);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }
    public static  int RQc(DBconnexion instance,String rq){

        int nbr = 0;
        try{

            Connection con = instance.getConnection();
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(rq);
            nbr = result.getInt("COUNT(*)");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return nbr;
    }
}
