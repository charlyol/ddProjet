package personnage;

public class Wizard extends Personnage {

    public Wizard(String nom) {

        super(nom);
        this.setLife(6);
        this.setLevelAtk(15);
        this.setEquipementOffensif(new EquipementOffensif("Sort", 8));
        this.setEquipementDefensif(new EquipementDefensif("Philtre", 2));

    }

    @Override
    public String hurler() {
        return "Hihou";
    }
}
