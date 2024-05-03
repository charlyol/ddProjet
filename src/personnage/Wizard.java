package personnage;

public class Wizard extends Personnage {

    public Wizard(String nom) {

        super(nom);
        this.setLife(6);
        this.setLevelAtk(15);
        this.setLifeMax(12);
        this.setLevelAtkMax(30);
        Philtre philtre = new Philtre();
        Sort sort = new Sort();
        this.setEquipementDefensif(philtre);
        this.setEquipementOffensif(sort);

    }

    @Override
    public String hurler() {
        return "Hihou";
    }
}
