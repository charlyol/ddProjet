package Personnage;

public class Type {
    private String type;
    private int life;
    private int levelAtk;
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;

    public Type(String type, int life, int levelAtk) {
       if(type.equals("guerrier")){
           this.type = "Guerrier";
           this.life = 10;
           this.levelAtk = 10;
           this.equipementDefensif = new EquipementDefensif("Bouclier", 3);
           this.equipementOffensif = new EquipementOffensif("Épée", 5);
       } else if(type.equals("magicien")){
           this.type = "Magicien";
           this.life = 6;
           this.levelAtk = 15;
           this.equipementDefensif = new EquipementDefensif("Philtre", 2);
           this.equipementOffensif = new EquipementOffensif("Sort", 8);
       }
    }

    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }
    public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
    }
    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }
    public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
    }
    public int getLevelAtk() {
        return levelAtk;
    }
    public void setLevelAtk(int levelAtk) {
        this.levelAtk = levelAtk;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}