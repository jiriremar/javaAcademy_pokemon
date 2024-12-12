package cz.remar.utility;

import java.util.Scanner;

public class InputUtils {
    private final static Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        return scanner.nextLine();
    }

    public static int readInt() {
        while (true){
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (Exception e) {
                System.out.print("Please enter an integer 1 - 8 ");
                scanner.nextLine();
            }
        }
    }
}
