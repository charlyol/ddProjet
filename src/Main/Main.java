package Main;
import Affichage.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/GameD&D";
        String userName="TotoDB";
        String password="Totodu26&";

        try {
            Connection con = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Menu menu = new Menu();
        menu.affichage();
    }
}
