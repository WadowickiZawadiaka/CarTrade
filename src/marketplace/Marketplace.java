package marketplace;

import game.DataReader;
import game.Player;
import generator.NumberGenerator;
import generator.VehicleGenerator;
import generator.ClientGenerator;
import record.Transaction;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Marketplace {
    private static ArrayList<Vehicle> avalibleVehicles;
    private static ArrayList<Client> avalibleClients;
    private static ArrayList<Transaction> transactions;

    public Marketplace() {
        avalibleVehicles = new ArrayList<>();
        transactions = new ArrayList<>();
        avalibleClients = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (NumberGenerator.calcProbability(20))
                avalibleVehicles.add(VehicleGenerator.generateCar(i * 400));
            else
                avalibleVehicles.add(VehicleGenerator.generateTruck(i * 500));
            avalibleClients.add(ClientGenerator.generateClient());
        }
    }

    public void sellVehicle(Player player, Scanner scanner) {
        System.out.println("Which car do you want to sell? Type car ID: ");
        int carId = DataReader.readNumber(0, 100, scanner);
        Vehicle vehicle = player.getVehicle(carId);

        if (vehicle != null) {
            System.out.println("Type client ID: ");
            int clientId = DataReader.readNumber(0, avalibleClients.size(), scanner);
            Client client = avalibleClients.get(clientId);
            if (client.getBrand_1() == vehicle.getBrand() || client.getBrand_2() == vehicle.getBrand()) {
                if (client.getBalance() > (int) (1.02f * vehicle.getPrice())) {
                    if (client.getVehicleType().equals(vehicle.getType())) {
                        if (!(!client.isDamage() && !vehicle.checkIsFine())) {
                            client.setBalance(client.getBalance() - vehicle.getPrice());
                            player.setBalance(player.getBalance() + vehicle.getPrice());
                            avalibleClients.remove(clientId);
                            avalibleClients.add(client);
                            transactions.add(new Transaction(vehicle.getPrice(), carId, "sale"));
                            System.out.println("Succesful transaction! Two new clients have entered car trade.");
                            this.addClient();
                            this.addClient();
                            player.moveDone();
                            player.removeVehicle(vehicle);
                            avalibleVehicles.add(VehicleGenerator.generateCar(400));
                            avalibleVehicles.add(VehicleGenerator.generateTruck(400));
                        } else {
                            System.out.println("The customer does not accept the broken car .");
                        }
                    } else {
                        System.out.println("The customer is not interested in a given type of car.");
                    }
                } else {
                    System.out.println("The customer does not have enough cash.");
                }
            } else {
                System.out.println("The customer is not interested in a given car brand.");
            }
        } else {
            System.out.println("You do not own the vehicle.");
        }
    }

    public void printClients() {
        System.out.println("| ID   | Balance  | Type       | Damage      | Brand 1 | Brand 2 |");
        System.out.println("------------------------------------------------------------------");
        for (Client client : avalibleClients)
            client.print();
        System.out.println("------------------------------------------------------------------");
    }

    public void printVehiclesList() {
        System.out.println("| ID   | Price     | Brand    | Color    | Milleage | Brakes  | Suspension | Engine   | Body | Gearbox | Cargo space | Type     |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (Vehicle vehicle : avalibleVehicles)
            vehicle.printVehicle();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printTransactionList() {
        System.out.println("| Price     | ID       | Transaction type |");
        System.out.println("-------------------------------------------");
        for (Transaction transaction : transactions)
            transaction.printTransaction();
        System.out.println("-------------------------------------------");
    }

    public String buyVehicle(int id, Player player) {
        int carId = -1;
        for (int i = 0; i < avalibleVehicles.size(); i++) {
            if (avalibleVehicles.get(i).getId() == id) {
                carId = i;
                break;
            }
        }
        if (carId == -1) return "The car is not on the list.";
        if (player.getBalance() > avalibleVehicles.get(carId).getPrice() * 1.02f) {
            avalibleVehicles.get(carId).buyFromMarketplace(player);
            transactions.add(new Transaction(avalibleVehicles.get(carId).getPrice(), id, "Vehicle purchase"));
            avalibleVehicles.remove(carId);
            player.moveDone();
        } else {
            return "No funds";
        }

        return "Succesful transaction!";
    }

    public void addClient() {
        avalibleClients.add(ClientGenerator.generateClient());
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}

