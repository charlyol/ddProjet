package personnage;

public class Warrior extends Personnage {

    public Warrior(String nom) {

        super(nom);
        this.setLife(10);
        this.setLevelAtk(10);
        this.setEquipementOffensif(new EquipementOffensif("Épée", 5));
        this.setEquipementDefensif(new EquipementDefensif("Bouclier", 3));

    }

    @Override
    public String hurler() {
        return "Waaaah";
    }
}
