package Personnage;

public class EquipementDefensif {

    private String nom;
    private int niveauDefense;

    public EquipementDefensif(String nom, int niveauDefense) {
        this.nom = nom;
        this.niveauDefense = niveauDefense;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public void setNiveauDefense(int niveauDefense) {
        this.niveauDefense = niveauDefense;
    }
    public int getNiveauDefense() {
        return niveauDefense;
    }
}
