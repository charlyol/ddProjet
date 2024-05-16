package Main;

import Affichage.Menu;
import dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {

        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            Connection con = connection.getConnection();
            System.out.println("Connexion réussie !");

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();
        menu.affichage();
    }
}
