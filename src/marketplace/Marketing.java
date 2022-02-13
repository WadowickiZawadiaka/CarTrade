package marketplace;

import game.DataReader;
import game.Player;
import generator.NumberGenerator;
import record.Transaction;

import java.util.Scanner;

public class Marketing {
    private static int marketId = 0;

    public static void advertise(Scanner scanner, Player player, Marketplace marketplace) {
        System.out.println("[0] Add your advertisement in the newspaper   - 400");
        System.out.println("[1] Add your advertisement on the internet - 100");
        int option = DataReader.readNumber(0, 1, scanner);

        if (option == 0) {
            if (player.getBalance() > 400) {
                for (int i = 0; i < NumberGenerator.getRandomInt(2, 6); i++)
                    marketplace.addClient();
                player.setBalance(player.getBalance() - 400);
                System.out.println("Added an advertisement to the newspaper.");
                marketplace.addTransaction(new Transaction(400, marketId, "Newspaper ad"));
                marketId++;
                player.moveDone();
            } else {
                System.out.println("Not enough funds.");
            }
        } else if (option == 1) {
            if (player.getBalance() > 100) {
                for (int i = 0; i < 2; i++)
                    marketplace.addClient();
                player.setBalance(player.getBalance() - 100);
                System.out.println("Added an advertisement to the internet.");
                marketplace.addTransaction(new Transaction(100, marketId, "Online ad"));
                marketId++;
                player.moveDone();
            } else {
                System.out.println("Not enough funds.");
            }
        }
    }
}
