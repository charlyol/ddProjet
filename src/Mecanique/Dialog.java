package Mecanique;

import java.util.Scanner;

public class Dialog {

    private final Scanner scanner = new Scanner(System.in);

    public boolean askBoolean(String info) {
        System.out.println(" " + info + " (Y / n) ");
        String answer = scanner.nextLine().trim().toLowerCase();
        switch (answer) {
            case "n":
                return false;
            case "y":
            case "":
                return true;
            default:
                System.out.println("Invalid input: " + answer);
                return askBoolean(info);
        }
    }

    public String askString(String info) {
        System.out.println(info);
        String answer = scanner.nextLine().trim().toLowerCase();
        switch (answer) {
            case "":
                System.out.println("Invalid input: " + answer);
                return askString(info);
            default:
                return answer;
        }
    }

}
