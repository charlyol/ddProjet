package personnage;

public abstract class EquipementDefensif {

    private String nom;
    private int levelDef;

    public EquipementDefensif(String nom, int levelDef) {
        this.nom = nom;
        this.levelDef = levelDef;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public void setLevelDef(int levelDef) {
        this.levelDef = levelDef;
    }
    public int getLevelDef() {
        return levelDef;
    }
}
