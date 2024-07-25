package BDGestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnexion {
    private static DBconnexion instance = null;
    private Connection connection;

    private  DBconnexion() {
        // Initialisation de la connexion à la base de données
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/park", "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBconnexion getInstance() {
        if (instance == null) {
            instance = new DBconnexion();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}