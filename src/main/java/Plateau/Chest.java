package Plateau;

import models.Personnages;

public interface Chest {
    void open(Personnages perso);

    enum StuffType {
        MELEE_WEAPON, // Arme corps à corps
        SPELL, // Sort
        ARMOR, // Armure bouclier
        POTION, // Potion
        MONSTER, // Monstre pas gentil
        PHILTRE // Philtre
    }

    StuffType getType();
}