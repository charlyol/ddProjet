package Main;

import Affichage.Menu;
import dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            con = connection.getConnection();
            System.out.println("Connexion réussie !");

            Menu menu = new Menu();
            menu.affichage();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}