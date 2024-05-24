package models;

import Plateau.Chest;
import personnage.EquipementDefensif;
import personnage.EquipementOffensif;

import java.util.ArrayList;
import java.util.List;

public abstract class Personnages {

    private Integer idPersonnages;
    private String type;
    private String name;

    public Personnages() {
        this.levelAtkMax = levelAtkMax;
        this.levelAtk = levelAtk;
        this.lifeMax = lifeMax;
        this.life = life;
        this.name = name;
        this.type = type;
        this.compatibleTypes = compatibleTypes;
        Games_idGames = Games_idGames;
    }

    private int life;
    private int lifeMax;
    private int levelAtk;
    private int levelAtkMax;
    private int position;
    private int Games_idGames;
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;

    protected List<Chest.StuffType> compatibleTypes = new ArrayList<>();

    public int getGames_idGames() {
        return Games_idGames;
    }

    public void setGames_idGames(int games_idGames) {
        Games_idGames = games_idGames;
    }

    public Personnages(List<Chest.StuffType> compatibleTypes) {
        this.compatibleTypes = compatibleTypes;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIdPersonnages() {
        return idPersonnages;
    }

    public void setIdPersonnages(Integer idPersonnages) {
        this.idPersonnages = idPersonnages;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Personnages(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Personnages{" +
                "idPersonnages=" + idPersonnages +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", life=" + life +
                ", lifeMax=" + lifeMax +
                ", levelAtk=" + levelAtk +
                ", levelAtkMax=" + levelAtkMax +
                ", position=" + position +
                ", Games_idGames=" + Games_idGames +
                ", equipementOffensif=" + equipementOffensif +
                ", equipementDefensif=" + equipementDefensif +
                '}';
    }

    public boolean isCompatibleWith(Chest.StuffType stuffType){
        return compatibleTypes.contains(stuffType);
    }

}
