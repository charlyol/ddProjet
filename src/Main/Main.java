package Main;
import Affichage.Menu;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/GameD&D";
        String userName="TotoDB";
        String password="Totodu26&";

        try {
            Connection con = DriverManager.getConnection(url,userName,password);
            Statement stmt = con.createStatement();

            stmt.execute("insert into Heros(HeroClass, HeroName, HeroLife, HeroLifeMax, HeroLevelAtk , HeroLevelAtkMax,HeroPosition,HeroEquipementOffensif,HeroEquipementDeffensif) values ('Humain', 'Charly', '31','100', '10','30','1','Hand','foot')");



            ResultSet resultset = stmt.executeQuery("select * from Heros");

            while (resultset.next()) {
                System.out.println(" id Hero : " + resultset.getInt("idHero"));
                System.out.println(" Class Hero : " + resultset.getString("HeroClass"));
                System.out.println(" Name Hero : " + resultset.getString("HeroName"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Menu menu = new Menu();
        menu.affichage();
    }
}
