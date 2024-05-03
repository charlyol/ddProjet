package personnage;

public abstract class Personnage {

    private String nom;
    private int life;
    private int lifeMax;
    private int levelAtk;
    private int levelAtkMax;
    private int position;
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Personnage(String nom) {
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLevelAtk() {
        return levelAtk;
    }

    public void setLevelAtk(int levelAtk) {
        this.levelAtk = levelAtk;
    }
    public int getLifeMax() {
        return lifeMax;
    }

    public void setLifeMax(int lifeMax) {
        this.lifeMax = lifeMax;
    }

    public int getLevelAtkMax() {
        return levelAtkMax;
    }

    public void setLevelAtkMax(int levelAtkMax) {
        this.levelAtkMax = levelAtkMax;
    }
    public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
    }

    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    public abstract String hurler();
}
