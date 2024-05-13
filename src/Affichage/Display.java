package Affichage;
import Mecanique.CreatNewPersonnageException;
import personnage.Personnage;
import Mecanique.Dialog;
import personnage.Verstappen;
import personnage.Warrior;
import personnage.Wizard;
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

    public Personnage creatPerso() {
        System.out.println("Créer un nouveau personnage");
        while (true) {
            try {
                String nom = dialog.askString("Quel est son nom ?");
                if (nom == null) {
                    throw new CreatNewPersonnageException("Création d'un nouveau personnage échouer");
                }
                System.out.println("Choisissez une classe :");
                System.out.println("1. Warrior");
                System.out.println("2. Wizard");
                System.out.println("3. Verstappen");
                System.out.print("Votre choix : ");
                int choix = scanner.nextInt();
                scanner.nextLine();
                switch (choix) {
                    case 1:
                        return new Warrior(nom);
                    case 2:
                        return new Wizard(nom);
                    case 3:
                        return new Verstappen(nom);
                    default:
                        System.out.println("Invalid input: ");
                }
            } catch (CreatNewPersonnageException e) {
                System.out.println("Erreur de creation");
            }
        }
    }

    public void notifyStatsPerso(Personnage personnage) {
        System.out.println(" Vie : " + personnage.getLife());
        System.out.println(" Equipement Offensif : " + personnage.getEquipementOffensif().getNom());
        System.out.println(" Points Atk : " + personnage.getEquipementOffensif().getNiveauAttaque());
        System.out.println(" Equipement Défensif : " + personnage.getEquipementDefensif().getNom());
        System.out.println(" Points Def : " + personnage.getEquipementDefensif().getNiveauDefense());
    }

    public void notifyMoveOnCase(int position) {
        System.out.println("Vous êtes actuellement sur la case " + position);
    }

    public boolean askThrowDice() {
        return dialog.askBoolean("Voulez-vous lancer le dé ?");
    }

    public boolean askFlee() {
        return dialog.askBoolean("Voulez-vous fuir ?");
    }

    public void notifyStartAventure(){
        System.out.println("L'aventure recommence ?");
    }

    public void notifyByeBye(){
        System.out.println("Peut-être une autre fois...");
    }

    public boolean notifyFinishGameAndRestart(){
        return dialog.askBoolean("Bravo vous avez fini le jeu ! Nouvelle partie ?");
    }

    public void notifyMeetMonster(String name, int atk, int life) {
        System.out.println("Rencontre avec un " + name + " d'une puissance de " + atk + " Atk " + " avec " + life + " PV ");
    }

    public void notifyDefMonster (String name, int toto) {
        System.out.println(" Le " + name + " vous enlève " + toto + " de PV ");
    }

    public void notifyAtkMonster (String name, int levelAtk, int monsterLife) {
        System.out.println(" vous avez touchez le " + name + " il est perd " + levelAtk + " PV de vie, il lui reste maintenant " + monsterLife + " de vie");
    }

    public void notifyMonsterDead (String name){
        System.out.println(" Le " + name + " est mort bravo ! ");
    }

    public void notifyWin (){
        System.out.println("Félicitations vous êtes sur la case 64 ! Vous avez fini le jeu !");
    }

    public void notifyResultDice(int result){
        System.out.println("Vous avez fait un score de " + result + " !");
    }

    public void notifyNothinghere() {
        System.out.println("il n'y a rien ici");
    }

    public void notifyLifeMax(){
        System.out.println(" Votre vie est au max ! ");
    }

    public void notifyOpenCaisseLife(String nom,int health){
        System.out.println(" Caisse " + nom + " de " + health + " PV ouverte ");
    }

    public void notifyGetLife(String nom,int health){
        System.out.println(" Vous venez de boire une " + nom + " de " + health + " PV ");
    }

    public void notifyOpenEquipement(String name, int atk){
        System.out.println(" Caisse de " + name + " de " + atk + " Atk ouverte ");
    }

    public void notifyGetEquipement(String name, int atk){
        System.out.println(" Vous venez d'avoir " + name + " de " + atk + " Atk ");
    }

    public void notifyYouAreWizzard(){
        System.out.println(" Vous êtes un Wizzard vous ne pouvez pas l'utilisez ");
    }

    public void notifyYouAreWarrior(){
        System.out.println(" Vous êtes un Warrior vous ne pouvez pas l'utilisez ");
    }

    public void notifyDontTouch(String name){
        System.out.println(" Le " + name + " ne vous touche pas ");
    }

    public void notifyVerstappenHurle(){
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

    public void notifyWarriorHurle(){
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

    public void notifyWizardHurle(){
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

    public boolean notifyYourAreDead(){
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

