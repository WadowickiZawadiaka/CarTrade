package game;

import marketplace.CarRepair;
import marketplace.Marketing;
import marketplace.Marketplace;

import java.util.Scanner;

public class Menu {
    private int option;
    private final Scanner scanner;
    private final Player player;
    private final Marketplace marketplace;
    private final CarRepair carRepair;

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


    public Menu() {
        option = 0;
        scanner = new Scanner(System.in);
        player = new Player();
        marketplace = new Marketplace();
        carRepair = new CarRepair();
    }

    public boolean menu() {
        checkWin();
        printMenu();
        readKey();
        mainMenu();
        return option != logs.length;
    }

    public void printMenu() {
        System.out.println("\n\t\t\t\t\t    Available operations:\n");
        for (String log : logs)
            System.out.println("\t\t\t\t\t" + log);
        System.out.println("\t\t\t\t\t    Type number:\n");
    }

    public void mainMenu() {
        switch (option) {
            case 0 -> {
                marketplace.printVehiclesList();
                System.out.println("Press enter...");
                scanner.nextLine();
            }
            case 1 -> {
                System.out.println("Type car id, that you want to buy: ");
                System.out.println(marketplace.buyVehicle(DataReader.readNumber(0, 100, scanner), player));
            }
            case 2 -> {
                player.showMyVehicles();
                System.out.println("Press enter...");
                scanner.nextLine();
            }
            case 3 -> {
                carRepair.printMechanics();
                carRepair.repairCar(scanner, player);
            }
            case 4 -> marketplace.printClients();
            case 5 -> marketplace.sellVehicle(player, scanner);
            case 6 -> Marketing.advertise(scanner, player, marketplace);
            case 7 -> System.out.println("Your account balance: " + player.getBalance());
            case 8 -> marketplace.printTransactionList();
            case 9 -> carRepair.printRepairs();
            case 10 -> player.showMyVehiclesSell();
            case 11 -> option = 12;
            default -> {
            }
        }
    }

    public void readKey() {
        Scanner reader = new Scanner(System.in);
        try {
            int temp = Integer.parseInt(reader.nextLine());
            if (temp >= 0 && temp < logs.length)
                option = temp;
            else
                System.out.println("ERROR, wrong number");
        } catch (Exception e) {
            System.out.println("ERROR, wrong number");
        }
    }

    public void checkWin() {
        if (player.getBalance() >= 2 * player.getStartBalance()) {
            System.out.println("You won!!!");
            System.out.println("You have done " + player.getNumberOfMoves() + " transactions.");
            System.out.println("You can continue game.");
        }
    }
}
