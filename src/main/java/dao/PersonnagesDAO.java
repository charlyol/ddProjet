package dao;

import Affichage.Display;
import Plateau.Chest;
import models.Personnages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonnagesDAO {
    private final Scanner scanner = new Scanner(System.in);

    public Personnages selectOrCreatePersonnage(int gameId) throws SQLException {
        List<Personnages> personnages = getAllPersonnagesByGameId(gameId);
        Personnages selectedPersonnages = null;

        if (!personnages.isEmpty()) {
            System.out.println("Personnages disponibles :");
            for (int i = 0; i < personnages.size(); i++) {
                System.out.println((i + 1) + " . " + personnages.get(i).getName() + " - " + personnages.get(i).getType());
            }
            System.out.println("Entrez le numéro du personnage pour le sélectionner, ou tapez 'n' pour créer un personnage :");
            String input = scanner.nextLine();

            if ("n".equalsIgnoreCase(input)) {
                selectedPersonnages = promptForNewPersonnageDetails(gameId);
            } else {
                try {
                    int choice = Integer.parseInt(input) - 1;
                    selectedPersonnages = personnages.get(choice);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Sélection invalide. Veuillez réessayer.");
                    return selectOrCreatePersonnage(gameId);
                }
            }
        } else {
            System.out.println("Aucun personnage disponible. Création d'un nouveau personnage.");
            selectedPersonnages = promptForNewPersonnageDetails(gameId);
        }

        return selectedPersonnages;
    }

    private Personnages promptForNewPersonnageDetails(int gameId) throws SQLException {
        Display display = new Display();
        System.out.println("Entrez le nom du nouveau personnage :");
        String name = scanner.nextLine();
        display.chooseYourClasse();
        String type = scanner.nextLine();
        return createNewPersonnage(gameId, name, type);
    }

    private Personnages createNewPersonnage(int gameId, String name, String type) throws SQLException {
        System.out.println("Creating a new personnage with name: " + name + " and type: " + type);

        Personnages personnage = null;
        try {
            Class<? extends Personnages> persoClass = (Class<? extends Personnages>) Class.forName(type);
            Constructor<? extends Personnages> constructor = persoClass.getConstructor(String.class, List.class);
            personnage = constructor.newInstance(name, type);
            personnage.setGames_idGames(gameId);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        savePersonnage(personnage);
        return personnage;
    }

    public void savePersonnage(Personnages personnage) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement pstmt;
        if (personnage.getIdPersonnages() == null) {
            String insertSQL = "INSERT INTO Personnages (type, name, life, lifeMax, levelAtk, levelAtkMax, position, Games_idGames) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, personnage.getType());
            pstmt.setString(2, personnage.getName());
            pstmt.setInt(3, personnage.getLife());
            pstmt.setInt(4, personnage.getLifeMax());
            pstmt.setInt(5, personnage.getLevelAtk());
            pstmt.setInt(6, personnage.getLevelAtkMax());
            pstmt.setInt(7, personnage.getPosition());
            pstmt.setInt(8, personnage.getGames_idGames());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                personnage.setIdPersonnages(rs.getInt(1));
            }
        } else {
            String updateSQL = "UPDATE Personnages SET type = ?, name = ?, life = ?, lifeMax = ?, levelAtk = ?, levelAtkMax = ?, position = ?, Games_idGames = ? WHERE idPersonnages = ?";
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, personnage.getType());
            pstmt.setString(2, personnage.getName());
            pstmt.setInt(3, personnage.getLife());
            pstmt.setInt(4, personnage.getLifeMax());
            pstmt.setInt(5, personnage.getLevelAtk());
            pstmt.setInt(6, personnage.getLevelAtkMax());
            pstmt.setInt(7, personnage.getPosition());
            pstmt.setInt(8, personnage.getGames_idGames());
            pstmt.setInt(9, personnage.getIdPersonnages());
            pstmt.executeUpdate();
        }
    }

    private List<Personnages> getAllPersonnagesByGameId(int gameId) throws SQLException {
        List<Personnages> personnages = new ArrayList<>();
        String sql = "SELECT * FROM Personnages WHERE Games_idGames = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gameId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Personnages personnage = new Personnages() {
                    @Override
                    public String hurler() {
                        return "";
                    }
                };
                personnage.setIdPersonnages(rs.getInt("idPersonnages"));
                personnage.setName(rs.getString("name"));
                personnage.setType(rs.getString("type"));
                personnage.setLife(rs.getInt("life"));
                personnage.setLifeMax(rs.getInt("lifeMax"));
                personnage.setLevelAtk(rs.getInt("levelAtk"));
                personnage.setLevelAtkMax(rs.getInt("levelAtkMax"));
                personnage.setPosition(rs.getInt("position"));
                personnage.setGames_idGames(rs.getInt("Games_idGames"));
                personnages.add(personnage);
            }
        }
        return personnages;
    }
}