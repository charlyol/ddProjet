package personnage;

public abstract class EquipementOffensif {

    private String nom;
    private int levelAtk;

    public EquipementOffensif(String nom, int levelAtk) {
        this.nom = nom;
        this.levelAtk = levelAtk;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public void setLevelAtk(int levelAtk) {
        this.levelAtk = levelAtk;
    }
    public int getLevelAtk() {
        return levelAtk;
    }
}
