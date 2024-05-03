package personnage;

public abstract class EquipementOffensif {

    private String nom;
    private int niveauAttaque;

    public EquipementOffensif(String nom, int niveauAttaque) {
        this.nom = nom;
        this.niveauAttaque = niveauAttaque;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public void setNiveauAttaque(int niveauAttaque) {
        this.niveauAttaque = niveauAttaque;
    }
    public int getNiveauAttaque() {
        return niveauAttaque;
    }
}
