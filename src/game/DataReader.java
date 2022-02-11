package game;

import java.util.Scanner;

public class DataReader {
    public static int readNumber(int min, int max, Scanner scanner) {
        boolean read = false;
        int number = 0;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (Exception e4) {
                System.out.println("Wrong data!");
            }
            if (number >= min && number <= max) {
                read = true;
            } else {
                System.out.println("Wrong number!");
            }
        } while (!read);
        return number;
    }
}