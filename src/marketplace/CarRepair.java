package marketplace;

import game.DataReader;
import game.Player;
import record.Repair;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarRepair {

    private final ArrayList<Mechanic> mechanics;
    private final ArrayList<Repair> repairs;

    public CarRepair() {
        repairs = new ArrayList<>();
        mechanics = new ArrayList<>(Arrays.asList(new Mechanic(2.0f, 0, 0, "Janusz"),
                new Mechanic(1.0f, 10, 0, "Marian"),
                new Mechanic(0.5f, 20, 2, "Adrian")));
    }

    public void printMechanics() {
        System.out.println("| Name     | Value multiplier | Failure chance | Malfunction chance |");
        System.out.println("------------------------------------------------------------------");
        for (Mechanic mechanic : mechanics)
            mechanic.printMechanicData();
        System.out.println("------------------------------------------------------------------");
    }

    public void printRepairs() {
        System.out.println("| Price     | Car ID  | Part ID   |");
        System.out.println("-----------------------------------");
        for (Repair repair : repairs)
            repair.print();
        System.out.println("-----------------------------------");
    }

    public void repairCar(Scanner scanner, Player player) {
        System.out.println("Type car ID that you want to repair: ");
        Vehicle vehicle = player.getVehicle(DataReader.readNumber(0, 100, scanner));
        if (vehicle == null) {
            System.out.println("You don't own this car.");
            return;
        }

        System.out.println("Choose a mechanic[0-2]: ");
        int mechanicId = DataReader.readNumber(0, 2, scanner);

        System.out.println("Choose part[0-4](breaks, suspension, engine, body, gearbox: ");
        int partId = DataReader.readNumber(0, 4, scanner);

        switch (partId) {
            case 0 -> {
                if (vehicle.isBrakes()) {
                    System.out.println("The vehicle has efficient brakes.");
                    return;
                }
                if (mechanics.get(mechanicId).repairBrakes(vehicle, player)) {
                    repairs.add(new Repair((int) (vehicle.getBrakesRepairPrice() * mechanics.get(mechanicId).getPrice()), vehicle.getId(), 0));
                    player.moveDone();
                }
            }
            case 1 -> {
                if (vehicle.isSuspension()) {
                    System.out.println("The vehicle has efficient suspension.");
                    return;
                }
                if (mechanics.get(mechanicId).repairSuspension(vehicle, player)) {
                    repairs.add(new Repair((int) (vehicle.getSuspensionRepairPrice() * mechanics.get(mechanicId).getPrice()), vehicle.getId(), 1));
                    player.moveDone();
                }
            }
            case 2 -> {
                if (vehicle.isEngine()) {
                    System.out.println("The vehicle has efficient engine.");
                    return;
                }
                if (mechanics.get(mechanicId).repairEngine(vehicle, player)) {
                    repairs.add(new Repair((int) (vehicle.getEngineRepairPrice() * mechanics.get(mechanicId).getPrice()), vehicle.getId(), 2));
                    player.moveDone();
                }
            }
            case 3 -> {
                if (vehicle.isCarBody()) {
                    System.out.println("The vehicle has efficient body.");
                    return;
                }
                if (mechanics.get(mechanicId).repairCarBody(vehicle, player)) {
                    repairs.add(new Repair((int) (vehicle.getCarBodyRepairPrice() * mechanics.get(mechanicId).getPrice()), vehicle.getId(), 3));
                    player.moveDone();
                }
            }
            case 4 -> {
                if (vehicle.isGearBox()) {
                    System.out.println("The vehicle has efficient gearbox.");
                    return;
                }
                if (mechanics.get(mechanicId).repairGearBox(vehicle, player)) {
                    repairs.add(new Repair((int) (vehicle.getGearBoxRepairPrice() * mechanics.get(mechanicId).getPrice()), vehicle.getId(), 4));
                    player.moveDone();
                }
            }
            default -> {
            }
        }

    }
}
