package game;

import marketplace.CarRepair;
import marketplace.Marketplace;

import java.util.Scanner;

public class Menu {
    private int option;
    private final Scanner scanner;
    private final Player player;
    private final Marketplace marketplace;
    private final CarRepair carRepair;

    public Menu(int option, Scanner scanner, Player player, Marketplace marketplace, CarRepair carRepair) {
        this.option = option;
        this.scanner = scanner;
        this.player = player;
        this.marketplace = marketplace;
        this.carRepair = carRepair;
    }

    private static final String[] logs = new String[]{
            "[0]  Check car base",
            "[1]  Buy a car",
            "[2]  Check your cars",
            "[3]  Repair car",
            "[4]  Check client list",
            "[5]  Sell car",
            "[6]  Buy advertisement",
            "[7]  Check your account balance",
            "[8]  Check transaction history",
            "[9]  Check repairs history",
            "[10] Check the cost of selling vehicles",
            "[11] Finish game"};
}
