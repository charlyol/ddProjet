```mermaid
sequenceDiagram
    participant Menu
    participant User
    participant Game
    participant Personnages
    participant Board
    participant Chest

    Menu->>User: Commencer une nouvelle aventure ?
    User-->>Menu: Oui
    Menu->>User: Choisir un personnage
    User-->>Menu: Warrior
    Menu->>Game: Création du personnage Warrior
    Game->>Personnages: Créer un personnage Warrior
    Personnages-->>Game: Personnage Warrior créé
    Game-->>User: Personnage Warrior créé
    User->>Game: Commencer le jeu
    Game->>Board: Initialiser le plateau de jeu
    Board-->>Game: Plateau de jeu initialisé
    Game-->>User: Le jeu commence
    loop Chaque tour
        User->>Game: Effectuer une action
        Game->>Personnages: Effectuer une action
        Personnages->>Chest: Ouvrir un coffre
        Chest-->>Personnages: Résultat de l'action
        Personnages-->>Game: Résultat de l'action
        Game-->>User: Résultat de l'action
    end
    User->>Game: Fin de la partie
    Game-->>User: Partie terminée