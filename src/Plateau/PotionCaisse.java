package Plateau;

import personnage.Personnage;

public class PotionCaisse implements Caisse {
    private final String nom;
    private final int health;

    public PotionCaisse(String name, int health) {
        this.nom = name;
        this.health = health;
    }

    @Override
    public void open(Personnage perso) {
        int newLife = perso.getLife() + health;
        int lifeMax = perso.getLifeMax();
        System.out.println(" Caisse " + nom + " de " + health + " PV ouverte ");

        perso.setLife(Math.min(newLife, lifeMax));
        if (lifeMax == newLife){
            System.out.println(" Votre vie est au max ! ");
        } else {
            System.out.println(" Vous venez de boire une " + nom + " de " + health + " PV ");
        }

    }

}
