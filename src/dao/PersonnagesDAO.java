package dao;

import models.Personnage;
import models.Personnages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonnagesDAO {

    public void savePersonnage(Personnages personnages) {

        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            Connection con = connection.getConnection();
            PreparedStatement statement;

            if (personnages.getIdPersonnages() == null) {
                // Insertion
                String insertSQL = "INSERT INTO Personnages (idPersonnages, type, name, life, lifeMax, levelAtk, levelAtkMax, position, Games_idGames) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                statement = con.prepareStatement(insertSQL);
                statement.setInt(1, personnages.getIdPersonnages());
                statement.setString(2, personnages.getType());
                statement.setString(3, personnages.getName());
                statement.setInt(4, personnages.getLife());
                statement.setInt(5, personnages.getLifeMax());
                statement.setInt(6, personnages.getLevelAtk());
                statement.setInt(7, personnages.getLevelAtkMax());
                statement.setInt(8, personnages.getPosition());
                statement.setInt(9, personnages.getGames_idGames());
            } else {
                // Mise à jour
                String updateSQL = "UPDATE Personnages SET type = ?, name = ?, life = ?, lifeMax = ?, levelAtk = ?, levelAtkMax = ?, position = ?, Games_idGames = ? WHERE idPersonnages = ?";
                statement = con.prepareStatement(updateSQL);
                statement.setString(1, personnages.getType());
                statement.setString(2, personnages.getName());
                statement.setInt(3, personnages.getLife());
                statement.setInt(4, personnages.getLifeMax());
                statement.setInt(5, personnages.getLevelAtk());
                statement.setInt(6, personnages.getLevelAtkMax());
                statement.setInt(7, personnages.getPosition());
                statement.setInt(8, personnages.getGames_idGames());
            }

            statement.execute();
            System.out.println(personnages.getIdPersonnages() + " Saved into the database");

            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Personnage getPersonnageById(int id) {
        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            Connection con = connection.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from Personnages where idPersonnages = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Personnage personnage = new Personnage();
                personnage.setIdPersonnages(resultSet.getInt("idPersonnages"));
                personnage.setType(resultSet.getString("type"));
                personnage.setName(resultSet.getString("name"));
                personnage.setLife(resultSet.getInt("life"));
                personnage.setLifeMax(resultSet.getInt("lifeMax"));
                personnage.setLevelAtk(resultSet.getInt("levelAtk"));
                personnage.setLevelAtkMax(resultSet.getInt("levelAtkMax"));
                personnage.setPosition(resultSet.getInt("position"));
                personnage.setGames_idGames(resultSet.getInt("Games_idGames"));
                return personnage;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Personnages> getAllPersonnages() {
        List<Personnages> personnagesList = new ArrayList<>();
        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            Connection con = connection.getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Personnages");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Personnages personnages = new Personnage();
                personnages.setIdPersonnages(resultSet.getInt("idPersonnages"));
                personnages.setType(resultSet.getString("type"));
                personnages.setName(resultSet.getString("name"));
                personnages.setLife(resultSet.getInt("life"));
                personnages.setLifeMax(resultSet.getInt("lifeMax"));
                personnages.setLevelAtk(resultSet.getInt("levelAtk"));
                personnages.setLevelAtkMax(resultSet.getInt("levelAtkMax"));
                personnages.setPosition(resultSet.getInt("position"));
                personnages.setGames_idGames(resultSet.getInt("Games_idGames"));
                personnagesList.add(personnages);
            }

            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnagesList;
    }

    public void deletePersonnage(int id) {
        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            Connection con = connection.getConnection();
            PreparedStatement statement = con.prepareStatement("DELETE FROM Personnages WHERE idPersonnages = ?");
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Personnage with ID " + id + " deleted from the database.");
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
