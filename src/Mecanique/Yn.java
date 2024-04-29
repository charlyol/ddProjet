package Mecanique;

import java.util.Scanner;

public class Yn {

    private final Scanner scanner = new Scanner(System.in);

    public String ask(String info) {
        System.out.println(" " + info + " (Y / n) ");
        String answer = scanner.nextLine().trim().toLowerCase();
        switch (answer) {
            case "n":
                Ascii.NegateLetter();
                break;
            case "y":
            case "":
                return "y";
            default:
                System.out.println("Invalid input: " + answer);
                return ask(info);
        }
        return answer;
    }
}

class Ascii {
    public static void NegateLetter() {
        // Code correspondant à la réponse "n"
    }
}
