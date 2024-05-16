package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/GameD&D";
    private static final String USERNAME = "TotoDB";
    private static final String PASSWORD = "Totodu26&";

    // Instance unique de la classe DatabaseConnection
    private static volatile DatabaseConnection instance;
    private final Connection connection;

    // Constructeur privé pour empêcher l'instanciation externe
    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
    }

    // Méthode publique statique pour obtenir l'instance unique
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Méthode pour obtenir la connexion
    public Connection getConnection() {
        return connection;
    }
}


//Pour appeler la méthode de connection.

//          try {
//            DatabaseConnection connection = DatabaseConnection.getInstance();
//            Connection con = connection.getConnection();
//            System.out.println("Connexion réussie !");
//            //logique requêtes SQL//
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//stmt.execute("insert into Heros(HeroClass, HeroName, HeroLife, HeroLifeMax, HeroLevelAtk , HeroLevelAtkMax,HeroPosition,HeroEquipementOffensif,HeroEquipementDeffensif)
//values ('Humain', 'Charly', '31','100', '10','30','1','Hand','foot')");
//ResultSet resultset = stmt.executeQuery("select * from Heros");
//while (resultset.next()) {
//System.out.println(" Id Hero : " + resultset.getInt("IdHero"));
//System.out.println(" Class Hero : " + resultset.getString("HeroClass"));
//System.out.println(" Name Hero : " + resultset.getString("HeroName"));
//}