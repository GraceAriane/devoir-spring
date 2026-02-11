package devoir.persistence.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/gestionUtilisateurs";
    private static final String USER = "root";
    private static final String PASSWORD = "root237";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // CHARGEMENT DU DRIVER
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL introuvable", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base", e);
        }
    }
}
