package Affichage;

import models.Personnages;
import Mecanique.Dialog;
import java.util.Scanner;

public class Display {

    Scanner scanner = new Scanner(System.in);
    Dialog dialog = new Dialog();

    public boolean start() {
        boolean response = dialog.askBoolean("Commencer une nouvelle aventure ?");
        if (response) {
            System.out.println("L'aventure commence !");
        } else {
            System.out.println("Peut-être une autre fois...");
        }
        return response;
    }

    public String creatNamePerso() {
        System.out.println("Créer un nouveau personnage");
        while (true) {
            String nom = dialog.askString("Quel est son nom ?");
            if (nom != null && !nom.isEmpty()) {
                return nom;
            } else {
                System.out.println("Le nom ne peut pas être vide. Veuillez réessayer.");
            }
        }
    }

    public String chooseYourClasse() {
        System.out.println("Choisissez une classe :");
        System.out.println("1. Warrior");
        System.out.println("2. Wizard");
        System.out.println("3. Verstappen");
        while (true) {
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    return "Warrior";
                case 2:
                    return "Wizard";
                case 3:
                    return "Verstappen";
                default:
                    System.out.println("Choix invalide. Veuillez choisir entre 1, 2, ou 3.");
            }
        }
    }

    public void notifyStatsPerso(Personnages personnages) {
        System.out.println(" Vie : " + personnages.getLife());
        System.out.println(" Equipement Offensif : " + personnages.getEquipementOffensif().getNom());
        System.out.println(" Points Atk : " + personnages.getEquipementOffensif().getLevelAtk());
        System.out.println(" Equipement Défensif : " + personnages.getEquipementDefensif().getNom());
        System.out.println(" Points Def : " + personnages.getEquipementDefensif().getLevelDef());
    }

    public void notifyMoveOnCase(int position) {
        System.out.println("Vous êtes actuellement sur la case " + position);
    }

    public void notifyNewCaseNow(int position) {
        if (position > 64) {
            System.out.println("Vous êtes maintenant sur la dernière case ");
        } else {
            System.out.println("Vous êtes maintenant sur la case " + position);
        }
    }

    public void notifyLoosePosition(int result) {
        if (result == 1) {
            System.out.println("Vous avez décidé de fuir le combat ! Vous reculez d'une case !");
        } else {
            System.out.println("Vous avez décidé de fuir le combat ! Vous reculez de " + result + " cases !");
        }
    }


    public boolean askThrowDice() {
        return dialog.askBoolean("Voulez-vous lancer le dé ?");
    }

    public String askNameGame() {
        return dialog.askString("Quel est le nom de la partie ?");
    }

    public boolean askFlee() {
        return dialog.askBoolean("Voulez-vous fuir ?");
    }

    public String notifyStartAventure() {
        System.out.println("L'aventure recommence ?");
        return null;
    }

    public void notifyByeBye() {
        System.out.println("Peut-être une autre fois...");
    }

    public boolean notifyFinishGameAndRestart() {
        return dialog.askBoolean("Bravo vous avez fini le jeu ! Nouvelle partie ?");
    }

    public boolean notifyFigthOrFlee() {
        return dialog.askBoolean("Engager le combat ou fuite ?");
    }

    public void notifyMeetMonster(String name, int atk, int life) {
        System.out.println("Rencontre avec un " + name + " d'une puissance de " + atk + " Atk " + " avec " + life + " PV ");
    }

    public void notifyDefMonster(String name, int toto) {
        System.out.println(" Le " + name + " vous enlève " + toto + " de PV ");
    }

    public void notifyAtkMonster(String name, int levelAtk, int monsterLife) {
        System.out.println(" vous avez touchez le " + name + " il est perd " + levelAtk + " PV de vie, il lui reste maintenant " + monsterLife + " de vie");
    }

    public void notifyMonsterDead(String name) {
        System.out.println(" Le " + name + " est mort bravo ! ");
    }

    public void notifyWin() {
        System.out.println("Félicitations vous êtes sur la case 64 ! Vous avez fini le jeu !");
    }

    public void notifyResultDice(int result) {
        System.out.println("Vous avez fait un score de " + result + " !");
    }

    public void notifyNothinghere() {
        System.out.println("il n'y a rien ici");
    }

    public void notifyLifeMax() {
        System.out.println(" Votre vie est au max ! ");
    }

    public void notifyOpenCaisseLife(String nom, int health) {
        System.out.println(" Caisse " + nom + " de " + health + " PV ouverte ");
    }

    public void notifyGetLife(String nom, int health) {
        System.out.println(" Vous venez de boire une " + nom + " de " + health + " PV ");
    }

    public void notifyOpenEquipement(String name, int atk) {
        System.out.println(" Caisse de " + name + " de " + atk + " Atk ouverte ");
    }

    public void notifyGetEquipement(String name, int atk) {
        System.out.println(" Vous venez d'avoir " + name + " de " + atk + " Atk ");
    }

    public void notifyYouAreWizzard() {
        System.out.println(" Vous êtes un Wizzard vous ne pouvez pas l'utilisez ");
    }

    public void notifyYouAreWarrior() {
        System.out.println(" Vous êtes un MeleeWeapon vous ne pouvez pas l'utilisez ");
    }

    public void notifyDontTouch(String name) {
        System.out.println(" Le " + name + " ne vous touche pas ");
    }

    public void notifyVerstappenHurle() {
        System.out.println(
                """
                        ⣋⡞⡵⣻⢼⣹⢣⡗⣏⡯⣞⡹⢶⡹⢬⣛⢧⠧⣏⣧⣛⠶⣽⡸⣵⣹⢲⢣⡏⡗⡞⣼⣱⡹⢼⢼⣷⡇⡛⠶⣬⣿⢱⣎⡟⣮⣹⢚⡼⣣⢏⣳⡹⢎⡳⣝⣚⡳⠽⣎⢷
                        ⣭⢏⣗⡫⢶⣩⢻⡼⣇⡗⡧⢻⡝⣺⡱⢎⢯⡳⣇⠶⣫⢏⣶⢹⢲⠵⣋⠷⣩⢗⡏⡶⣥⡿⢚⣭⠍⣉⠱⢄⠲⠌⡚⢙⠹⠷⠧⣻⢸⢱⠏⡶⣭⣛⡼⡱⢦⣟⣹⢲⢣
                        ⡷⢮⡥⣏⡗⣮⢹⣼⢲⢏⡵⣇⡻⢥⠟⣼⢳⡹⣜⢳⡵⡫⣆⢯⢏⡳⣭⣛⣼⣸⢟⣩⡵⣋⠩⠽⡻⢖⡯⣾⣾⡷⣶⣧⣝⣦⣔⡨⠹⢬⣋⣗⣣⠮⣵⢹⣓⠮⢶⣩⢞
                        ⢻⣟⡲⣏⣯⣗⡳⢾⣽⢞⡲⢧⡯⣭⣛⡵⢮⢝⣜⢳⢜⡇⡟⣮⡹⢼⡑⣾⣯⣶⣿⣿⣽⣧⣿⣽⢿⣿⣾⣿⣿⣿⣿⣿⣷⣿⣾⣿⣯⡤⣳⡮⣵⢛⡖⣽⣸⡍⡗⣜⠮
                        ⠾⣭⢷⣛⡶⢯⡽⣋⣾⢺⠽⣭⣓⠷⢮⡵⣛⡾⣜⣻⢜⡧⣻⣴⢻⢼⣽⣿⣿⣿⣿⣽⣭⣵⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⡿⡜⢧⡝⡶⢳⢺⣙⣮⠝
                        ⣻⢜⣳⢭⣟⣡⠟⡷⣭⣻⣸⠶⢯⡝⣇⡗⣧⠻⣼⣱⢺⣡⢗⡮⣟⣾⣿⣿⣿⣿⣿⢿⡿⡿⠿⡿⠟⠻⠿⠛⠛⠋⠉⠛⠿⣿⣿⣿⣿⣿⠩⢷⣝⣺⡜⡧⣻⢹⠲⡭⣞
                        ⢳⣯⣝⡺⢼⠼⣍⡟⡳⠶⣭⢻⣹⢚⢦⡟⣭⣛⡵⣜⡳⣽⢎⣗⣧⣿⣿⣿⡿⣿⠃⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠈⣿⣿⣭⢳⡌⡔⣶⢿⡜⣧⠗⣯⡝⣧⡳
                        ⣷⠲⡭⣝⣺⢽⢮⣇⡯⣟⣜⡻⣼⣹⢮⡹⣇⢯⣓⡯⡞⡽⣺⣜⠶⣿⣿⣿⣧⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣧⢻⣾⣟⡮⢽⡲⣏⡳⢞⡵⢫
                        ⣗⣏⡗⡯⣵⣺⣽⣻⢧⣋⡮⡟⣶⣹⣘⣳⣙⠧⢯⡗⣏⡳⡽⢼⣏⣿⣿⡟⠁⣀⣤⣠⣀⣀⠀⠀⠀⠀⢀⡀⣈⣀⣀⣀⣀⠀⠈⠹⣿⣿⢻⡿⣼⡹⢯⢵⡲⣏⠿⣼⣓
                        ⠺⣼⣭⡗⡧⣿⣾⣿⣻⢧⣏⣧⣓⠾⡼⢬⣽⣹⡻⠼⠧⡟⣭⣛⢾⣿⣿⡇⢸⣯⣋⣭⣟⣿⣿⣷⠂⠘⣿⣿⣿⣿⣏⣛⠿⣷⡀⠀⣿⣿⣿⡿⣶⡹⣏⢾⡹⣕⡻⡵⢎
                        ⣽⢺⡴⢯⡗⣿⣟⣿⣿⣼⢺⡵⠯⣏⣟⣚⡲⢧⠿⣝⣓⡛⡶⢭⣹⡿⣿⠇⠨⢚⣛⣋⣭⣽⡿⠋⠀⠀⠘⠿⠿⣯⣙⣋⣙⢖⡇⠀⢹⡿⢛⢾⣷⣛⡼⢧⢻⢬⡗⣝⢫
                        ⡼⣹⢚⡳⡹⢧⣟⡿⣿⢼⢺⡹⣝⡲⢣⡳⢭⣛⣞⠲⣬⢭⣛⡳⡾⣤⣿⠀⠔⠉⠀⠀⠉⠀⢠⠎⠁⠀⠀⠮⡀⠀⠀⠀⠀⠀⢁⠀⠀⠣⣶⣦⣿⢣⡝⣫⢧⢻⡔⢫⢧
                        ⢎⡧⢯⢼⣹⠱⡇⡯⡟⣏⡎⣷⢪⣝⢡⢏⣳⢺⢬⣙⠞⣶⠣⣍⣷⡹⢹⡄⢀⠀⠀⠀⢀⣀⠰⣶⣦⣰⣶⣦⠗⠢⡄⠀⠀⠘⠆⠀⢰⢀⡽⣛⣽⣱⡝⡲⢏⢦⢹⣣⢳
                        ⣙⠦⣫⠶⣍⢾⢩⢗⡣⡇⡷⢬⢳⡜⡺⡜⣥⡛⢦⣏⡹⢭⣳⢒⡼⣯⡀⢧⠸⢧⠀⣴⣿⢁⡰⢻⠿⠷⡿⠿⠲⣀⢿⣆⠂⢰⣏⠀⢯⠋⣀⣵⣛⠲⠼⣍⠿⣜⢺⡔⢧
                        ⣥⢻⡡⡟⢬⣚⢭⢮⢱⡍⢧⣋⠖⡭⣓⠼⢲⣙⢎⡲⢭⡣⢎⡽⣒⡫⢿⣿⣠⢹⡆⢻⡽⢿⣛⣛⣚⣛⣓⣛⣻⠿⢛⡿⢠⣋⠎⢠⣿⣿⣛⠦⡍⣻⠸⣍⠶⣩⠖⣭⣓
                        ⡰⠯⣴⢛⡲⢭⡺⣬⢳⡸⢣⢇⡏⣖⢣⢏⡳⡼⣹⢸⠥⣏⡗⣺⠱⣍⢧⣿⣧⢦⠛⣦⡀⠀⠌⠭⢭⣭⣭⡭⠃⠐⣈⡔⢋⠘⡰⣼⡳⢼⡱⣍⡳⣱⡛⢬⡳⠵⣋⠶⣩
                        ⠷⡢⢽⣘⣳⣊⢧⣏⢾⣱⠾⣸⢵⣫⡜⣼⣃⣧⢻⣸⢰⣍⡳⣝⡲⣝⡌⣿⢹⣾⣦⣝⢳⠀⠀⠀⠈⠩⠉⠁⠀⠀⠙⢡⣸⢂⣧⣿⣓⠾⣱⢭⢧⡻⡵⢬⡳⢦⡝⡦⣏
                        ⣟⣙⣣⠾⣴⡻⣖⡳⠾⣼⣛⡽⣺⢲⣭⢳⡞⡦⡟⣼⢹⢼⡱⢣⡟⣬⣿⡇⠈⠻⣿⣿⣶⣿⣧⣶⣈⣷⣦⡴⣃⣦⣾⣇⣾⠟⠁⡷⢾⢽⣙⢮⡳⡽⣜⠷⣍⢿⣜⡳⣇
                        ⢰⢣⣣⢟⣲⠹⢼⢩⣟⡲⡭⢞⣱⢏⡞⡲⢝⡣⡟⡧⡛⢼⣡⢛⣼⣿⣿⡇⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣿⣿⣯⠿⠋⠉⠀⢸⡯⢏⡖⣫⢕⡫⢵⢎⠻⣬⣓⢮⠳⡍
                        ⣹⢢⡓⢮⠧⣝⢚⡼⢲⢭⣓⣋⠶⡮⣝⣝⢪⣓⠧⡇⣏⡳⣸⣿⣿⣟⣿⣿⣦⡀⠀⠐⠀⠌⠌⢋⠛⢟⡋⠿⡐⠃⠀⠀⠌⠀⣹⡟⡼⣙⢆⡻⡜⡭⢎⡳⣃⠾⣸⣱⢩
                        ⢬⣳⣹⢋⠶⢣⡞⡼⣋⠶⢢⢭⣛⡵⢲⠪⣼⢩⣛⢎⣵⣶⣿⣿⣿⣭⠻⣛⣿⣿⣦⣄⠀⠀⠐⠠⢉⠢⡘⠐⠄⡀⢀⠀⠀⢀⣿⣷⣚⠱⡮⡑⣽⣸⢱⢣⠇⣯⣓⢼⣘
                        ⡾⠴⣩⢞⣭⢣⢏⡵⠫⣝⣹⠺⢲⢭⡣⣟⣼⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣌⡖⡬⣻⣿⣷⣦⣁⠁⡂⢄⠱⡨⠔⠠⠀⠀⢠⣾⣿⣟⣿⣿⣼⣕⣣⠶⣩⢮⡹⡆⣏⠶⣩
                        ⣋⣛⠖⡺⢬⣽⣂⣏⡓⢮⣍⣟⣹⣶⡿⣿⡿⢞⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣷⣾⣤⣣⣕⣪⢁⣒⣬⣿⣿⣿⣿⣿⣿⢿⣿⣿⣗⡷⣜⡲⢧⡍⡗⣭
                        ⢣⠭⣭⣛⣺⠴⢣⠬⣝⣷⣾⣻⣽⠞⢋⣥⣾⣿⣿⣿⣿⠟⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠛⢛⣿⣿⣿⣿⣿⣿⣟⠿⣿⣿⣿⡿⣿⢾⡱⣇
                        ⣩⣓⠶⢧⡽⣘⣿⣿⣟⣯⣿⢿⣄⢂⢻⣿⣯⡉⠙⢿⡏⢀⡾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⢶⣮⣿⣿⣿⣿⣿⣿⣿⣦⣈⠙⠟⠀⢘⣷⡙⣷
                        ⠼⡬⣏⣳⣶⣿⣿⣿⣾⣭⡤⣷⡻⣷⡄⢻⣿⣿⠷⠦⢤⣶⣾⣿⣿⣿⣾⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣭⣿⣿⣿⣿⣿⣿⣻⣿⣾⣯⣭⣡⣏⣯⣝⣷⢸⣧
                        ⣗⡛⣶⣿⣿⣿⣿⣿⣿⣿⣿⣗⢧⣿⣿⣆⢻⣿⣿⣿⣿⣏⠉⡉⡁⡔⠒⢄⠀⠀⢢⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠓⠛⠛⠻⠿⣿⣿⣿⣿⣻⣿⢘⣿⣙⢧
                        ⢦⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡾⣿⣦⢿⣿⣿⣿⣿⢘⣥⡝⢔⢲⠦⠗⣚⠁⡞⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢗⡄⣀⠠⡀⠀⠉⠛⠿⣷⢿⣾⣿⢿⣶⣿
                        ⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣏⣿⣿⣿⣿⣏⠼⣰⠨⡇⣇⢧⢞⣪⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣤⣀⣀⣀⡁⠘⠐⠀⣨⣿⣿⡿⣷⣻⣿
                        ⣾⣿⡿⣛⣛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⡿⣷⣶⣾⣭⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⢿⣿⣿
                        ⡓⢶⣿⡿⣹⠻⡿⢙⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣷⡿⣿⣿⣿⠿⣿⡟⠛⢻⣿⡛⣯⣹⣿⣿⣿⡿⣿⣿⣿⣿⣿⣟⣿⣿⣿⣯⢩⡙⡝⡟⡟⢛⢿⢹⠿⠿⣿⣿⣿⣿⣿
                        ⢭⣿⣿⣇⡛⠺⢛⣡⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⡸⢀⢸⣩⡟⡄⠶⢱⢰⢸⡿⠷⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠒⣹⠐⣧⠨⢸⣸⡇⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⢻⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣷⣼⣾⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣷⣿⣿⣧⣿⣿⣿⣿⣿⣿""");
    }

    public void notifyWarriorHurle() {
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣿⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⢟⣭⣴⣶⡦⠍⠛⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀
                ⠈⠳⣶⣤⣤⣶⣿⠿⢫⣾⣿⣿⠋⠀⠀⠀⠀⢸⣿⡟⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠈⠉⠉⠉⠁⣰⣿⣿⣿⠇⠀⢀⣀⣤⣴⣾⣧⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⡟⢠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⣠⣿⣿⣿⡟⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀
                ⠀⠀⢀⣠⣶⣿⣿⡿⠋⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⠀⠀⠀⠀
                ⠉⠛⠛⠛⠛⠛⠉⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣛⣥⣶⣆⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠏⣥⣤⡙⢟⣫⡴⠿⠿⠿⠷⠿⣷⡀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡜⢿⡿⢃⣌⢻⣟⠛⠻⠶⠶⢶⣾⣿⡄
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⣾⣿⣿⣷⡝⢿⣷⣶⣶⣦⡾⠟⠁
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣟⣛⣻⠿⠿⢧⢹⣿⣿⣿⣿⣦⡙⢷⡶⠋⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣝⠻⣿⣿⣛⠷⠌⢿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣮⣝⠻⣿⣶⣦⣤⣉⠛⠿⢿⠁⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠰⣾⣿⣿⣿⣿⣿⣿⣿⣿⣶⣭⣛⠿⢿⣧⢷⣤⡀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠛⠿⣿⣿⣿⣿⣷⡦⠉⢿⣿⡷⠦⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⡿⠋⠀⠀⠈⠀⠀⠀⠀⠀⠀""");
    }

    public void notifyWizardHurle() {
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⠟⠛⠉⠉⠉⠛⠻⢿⣶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⣍⠻⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⣄⠛⢿⣶⣄⣠⡾⣧⡀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣷⣦⡉⠻⣫⣾⡽⣷⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠇⠀⠀⣀⣀⡀⠀⠀⠀⠀⣀⣀⡀⠀⠸⣿⠻⣿⣾⡿⠃⠹⣿⣷⡀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⠟⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⣿⣇⠀⠉⠀⠀⠀⠈⠛⠛⠒⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⠃⢀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣀⡀⠘⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⡿⠿⠟⠋⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠙⠛⠿⢿⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢀⣠⣴⣾⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠿⣷⣦⣄⡀⠀⠀⠀⠀
                ⠀⣀⣴⣾⣿⣛⣁⣤⣤⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣠⣤⣌⣛⣿⣷⣦⣀⠀
                ⣼⡿⣿⣿⣿⣿⣿⣿⠋⠉⢹⡿⠻⣿⣿⡶⠒⠒⠲⣶⣶⣶⣶⣶⣶⡶⠖⠒⠲⢾⣿⣿⠟⢿⡏⠉⠙⣿⣿⣿⣿⣿⣿⢿⣷
                ⢹⣷⡙⢿⣿⣿⠾⠍⠁⠀⣾⠇⠀⢻⠀⢈⣻⣷⣶⣤⣤⡽⠟⢯⣤⣤⣴⣾⣿⡁⠀⡟⠀⠘⣷⠀⠈⠩⠷⣿⣿⡿⢋⣾⡟
                ⠀⠙⢿⣶⣭⣛⡿⠷⠤⣼⠏⢠⢶⣾⠀⠀⠙⠓⢦⣼⣿⡇⠀⢸⣿⣧⣴⠟⠋⠀⠀⣿⡄⡄⠹⣧⠤⠾⠿⣛⣭⣴⡿⠋⠀
                ⠀⠀⠀⠈⠛⠻⠿⣷⣶⠟⢰⡏⢸⣇⠀⠀⠀⠈⠉⢉⣹⠇⠀⠘⣏⡉⠉⠁⠀⠀⠀⢸⡇⢹⡆⠻⣶⣾⠿⠟⠛⠉⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢠⡏⢠⡟⠀⣼⣿⣄⠀⠀⠀⡼⠋⠻⠀⠀⠀⠾⠉⢳⡀⠀⠀⣠⣿⣷⠀⢹⡄⢹⣆⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢀⣟⣠⡿⢀⣼⡇⢹⣝⡷⣤⣼⣳⠴⠛⠳⠤⠔⠛⠦⣞⣷⣤⢴⣫⡟⠸⣷⡀⢿⣄⣻⡀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠸⢋⣿⠁⣼⢹⣆⠀⠉⠛⠛⠉⠁⠀⠀⣀⣿⣄⠀⠀⠀⠉⠛⠛⠉⠀⢠⡏⢧⠀⢿⡝⠇⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣼⡇⣰⠃⠈⢿⣦⣄⣀⣀⣀⣤⡴⠞⠋⠉⠉⠳⢦⣤⣀⣀⣀⣠⣴⡿⠁⠘⣦⢸⣷⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⢿⣿⡏⢠⠄⢸⣧⠉⠉⢻⣀⣠⡶⠞⠛⠉⠛⠳⢶⣤⣀⡟⠉⠉⢸⡇⠀⡄⢹⡿⠟⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⢸⣡⡏⠀⡄⢿⡀⠀⠀⠛⠉⠀⠀⠀⠀⠀⠀⠀⠉⠛⠁⠀⢀⡿⢡⡀⢹⣬⡇⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠸⡿⣇⢸⣿⢸⣷⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⣾⡇⣼⣧⣸⢻⡇⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⠹⣿⡏⡿⣧⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣾⣿⠻⣿⠏⢿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠁⠀⠻⣿⣦⣾⠀⠀⠀⠀⠀⣶⣤⡟⠟⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⢻⣧⡀⠀⠀⣼⡿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣦⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀""");
    }

    public boolean notifyYourAreDead() {
        return dialog.askBoolean("""
                                         ▄▄▄▄    ██▀███   ▄▄▄    ██▒   █▓ ▒█████      ▐██▌                                               \s
                                        ▓█████▄ ▓██ ▒ ██▒▒████▄ ▓██░   █▒▒██▒  ██▒    ▐██▌                                               \s
                                        ▒██▒ ▄██▓██ ░▄█ ▒▒██  ▀█▄▓██  █▒░▒██░  ██▒    ▐██▌                                               \s
                                        ▒██░█▀  ▒██▀▀█▄  ░██▄▄▄▄██▒██ █░░▒██   ██░    ▓██▒                                               \s
                                        ░▓█  ▀█▓░██▓ ▒██▒ ▓█   ▓██▒▒▀█░  ░ ████▓▒░    ▒▄▄                                                \s
                                        ░▒▓███▀▒░ ▒▓ ░▒▓░ ▒▒   ▓▒█░░ ▐░  ░ ▒░▒░▒░     ░▀▀▒                                               \s
                                        ▒░▒   ░   ░▒ ░ ▒░  ▒   ▒▒ ░░ ░░    ░ ▒ ▒░     ░  ░                                               \s
                                         ░    ░   ░░   ░   ░   ▒     ░░  ░ ░ ░ ▒         ░                                               \s
                                         ░         ░           ░  ░   ░      ░ ░      ░                                                  \s
                                              ░                      ░                                                                   \s
                         ▄▄▄█████▓ █    ██    ▓█████   ██████     ███▄ ▄███▓ ▒█████   ██▀███  ▄▄▄█████▓    ▐██▌                          \s
                         ▓  ██▒ ▓▒ ██  ▓██▒   ▓█   ▀ ▒██    ▒    ▓██▒▀█▀ ██▒▒██▒  ██▒▓██ ▒ ██▒▓  ██▒ ▓▒    ▐██▌                          \s
                         ▒ ▓██░ ▒░▓██  ▒██░   ▒███   ░ ▓██▄      ▓██    ▓██░▒██░  ██▒▓██ ░▄█ ▒▒ ▓██░ ▒░    ▐██▌                          \s
                         ░ ▓██▓ ░ ▓▓█  ░██░   ▒▓█  ▄   ▒   ██▒   ▒██    ▒██ ▒██   ██░▒██▀▀█▄  ░ ▓██▓ ░     ▓██▒                          \s
                           ▒██▒ ░ ▒▒█████▓    ░▒████▒▒██████▒▒   ▒██▒   ░██▒░ ████▓▒░░██▓ ▒██▒  ▒██▒ ░     ▒▄▄                           \s
                           ▒ ░░   ░▒▓▒ ▒ ▒    ░░ ▒░ ░▒ ▒▓▒ ▒ ░   ░ ▒░   ░  ░░ ▒░▒░▒░ ░ ▒▓ ░▒▓░  ▒ ░░       ░▀▀▒                          \s
                             ░    ░░▒░ ░ ░     ░ ░  ░░ ░▒  ░ ░   ░  ░      ░  ░ ▒ ▒░   ░▒ ░ ▒░    ░        ░  ░                          \s
                           ░       ░░░ ░ ░       ░   ░  ░  ░     ░      ░   ░ ░ ░ ▒    ░░   ░   ░             ░                          \s
                                     ░           ░  ░      ░            ░       ░ ░     ░                  ░                             \s
                                                                                                                                         \s
                 ███▄    █  ▒█████   █    ██  ██▒   █▓▓█████  ██▓     ██▓    ▓█████     ██▓███   ▄▄▄       ██▀███  ▄▄▄█████▓ ██▓▓█████   \s
                 ██ ▀█   █ ▒██▒  ██▒ ██  ▓██▒▓██░   █▒▓█   ▀ ▓██▒    ▓██▒    ▓█   ▀    ▓██░  ██▒▒████▄    ▓██ ▒ ██▒▓  ██▒ ▓▒▓██▒▓█   ▀   \s
                ▓██  ▀█ ██▒▒██░  ██▒▓██  ▒██░ ▓██  █▒░▒███   ▒██░    ▒██░    ▒███      ▓██░ ██▓▒▒██  ▀█▄  ▓██ ░▄█ ▒▒ ▓██░ ▒░▒██▒▒███     \s
                ▓██▒  ▐▌██▒▒██   ██░▓▓█  ░██░  ▒██ █░░▒▓█  ▄ ▒██░    ▒██░    ▒▓█  ▄    ▒██▄█▓▒ ▒░██▄▄▄▄██ ▒██▀▀█▄  ░ ▓██▓ ░ ░██░▒▓█  ▄   \s
                ▒██░   ▓██░░ ████▓▒░▒▒█████▓    ▒▀█░  ░▒████▒░██████▒░██████▒░▒████▒   ▒██▒ ░  ░ ▓█   ▓██▒░██▓ ▒██▒  ▒██▒ ░ ░██░░▒████▒  \s
                ░ ▒░   ▒ ▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒    ░ ▐░  ░░ ▒░ ░░ ▒░▓  ░░ ▒░▓  ░░░ ▒░ ░   ▒▓▒░ ░  ░ ▒▒   ▓▒█░░ ▒▓ ░▒▓░  ▒ ░░   ░▓  ░░ ▒░ ░  \s
                ░ ░░   ░ ▒░  ░ ▒ ▒░ ░░▒░ ░ ░    ░ ░░   ░ ░  ░░ ░ ▒  ░░ ░ ▒  ░ ░ ░  ░   ░▒ ░       ▒   ▒▒ ░  ░▒ ░ ▒░    ░     ▒ ░ ░ ░  ░  \s
                   ░   ░ ░ ░ ░ ░ ▒   ░░░ ░ ░      ░░     ░     ░ ░     ░ ░      ░      ░░         ░   ▒     ░░   ░   ░       ▒ ░   ░     \s
                         ░     ░ ░     ░           ░     ░  ░    ░  ░    ░  ░   ░  ░                  ░  ░   ░               ░     ░  ░  \s
                                                  ░                                                                                      \s""");
    }

}

