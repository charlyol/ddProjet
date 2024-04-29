package Personnage;

public class Personnage {
    private String nom;
    private Type type;

    public Personnage(String nom, Type type) {
        this.nom = nom;
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public Type getType() {
        return type;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

}
