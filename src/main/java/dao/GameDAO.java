package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameDAO {
    private final Scanner scanner = new Scanner(System.in);

    public int selectOrCreateGame() {
        List<String> games = getAllGames();
        if (games.isEmpty()) {
            System.out.println("Aucun jeu disponible. Création d'un nouveau jeu.");
            return createNewGame();
        } else {
            System.out.println("Jeux disponibles :");
            for (int i = 0; i < games.size(); i++) {
                System.out.println((i + 1) + ". " + games.get(i));
            }
            System.out.println((games.size() + 1) + ". Créer un nouveau jeu");
            System.out.println("Sélectionnez un jeu ou créez-en un nouveau :");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice > games.size()) {
                return createNewGame();
            } else {
                return getGameIdByName(games.get(choice - 1));
            }
        }
    }

    private int createNewGame() {
        System.out.println("Entrez le nom du nouveau jeu :");
        String name = scanner.nextLine();
        return insertNewGame(name);
    }

    private int getGameIdByName(String name) {
        String query = "SELECT idGames FROM Games WHERE name = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idGames");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur de base de données lors de la récupération de l'ID du jeu : " + e.getMessage());
        }
        return 0;
    }

    public List<String> getAllGames() {
        List<String> games = new ArrayList<>();
        String query = "SELECT name FROM Games";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                games.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur de base de données lors de la récupération des jeux : " + e.getMessage());
        }
        return games;
    }

    public int insertNewGame(String name) {
        String insertQuery = "INSERT INTO Games (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur de base de données lors de l'insertion d'un nouveau jeu : " + e.getMessage());
        }
        return 0;
    }
}