package game;

import generator.NumberGenerator;
import vehicles.Vehicle;

import java.util.ArrayList;

public class Player {

    private int balance;
    private final int startBalance;
    private final ArrayList<Vehicle> vehicles;
    private int numberOfMoves;

    public Player() {
        vehicles = new ArrayList<>();
        this.balance = NumberGenerator.getRandomInt(2000, 5000);
        this.startBalance = balance;
        numberOfMoves = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getStartBalance() {
        return startBalance;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void showMyVehicles() {
        System.out.println("| ID   | Price     | Brand    | Color    | Milleage | Breaks  | Suspension | Engine   | Body | Transmission | Cargo space| Type      |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (Vehicle vehicle : vehicles)
            vehicle.printVehicle();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void showMyVehiclesSell() {
        System.out.println("| ID   | Selling price |");
        System.out.println("-------------------------");
        for (Vehicle vehicle : vehicles)
            vehicle.printVehicleSell();
        System.out.println("-------------------------");
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        for (Vehicle v : vehicles) {
            if (v.getId() == vehicle.getId()) {
                vehicles.remove(v);
                break;
            }
        }
    }

    public Vehicle getVehicle(int id) {
        for (Vehicle v : vehicles) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public void moveDone() {
        numberOfMoves++;
        System.out.println("Number of moves: " + numberOfMoves);
    }
}

