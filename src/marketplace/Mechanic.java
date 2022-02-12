package marketplace;

import game.Player;
import generator.NumberGenerator;
import vehicles.Vehicle;
import vehicles.repairable;

public class Mechanic implements repairable {
    private final float price;
    private final int repairProbability;
    private final int damageProbability;
    private final String name;

    public float getPrice() {
        return price;
    }

    public Mechanic(float price, int repairProbability, int damageProbability, String name) {
        this.price = price;
        this.repairProbability = repairProbability;
        this.damageProbability = damageProbability;
        this.name = name;
    }

    public void printMechanicData() {
        System.out.println("| " + name + " ".repeat(9 - String.valueOf(name).length()) + "| " +
                price + " ".repeat(12 - String.valueOf(price).length()) + "| " +
                repairProbability + " ".repeat(21 - String.valueOf(repairProbability).length()) + "| " +
                damageProbability + " ".repeat(15 - String.valueOf(damageProbability).length()) + "|");
    }

    @Override
    public boolean repairBrakes(Vehicle vehicle, Player player) {
        if (player.getBalance() > vehicle.getBrakesRepairPrice() * price) {
            if (NumberGenerator.calcProbability(repairProbability)) {
                vehicle.setBrakes(true);
                System.out.println("Succesful repair");
                player.setBalance(player.getBalance() - (int) (vehicle.getBrakesRepairPrice() * price));
                player.removeVehicle(vehicle);
                vehicle.setPrice((int) (vehicle.getPrice() * 1.1f));
                player.addVehicle(vehicle);
                return true;
            } else {
                System.out.println("Repair failure");
            }
        } else {
            System.out.println("No funds.");
        }
        return false;
    }

    @Override
    public boolean repairSuspension(Vehicle vehicle, Player player) {
        if (player.getBalance() > vehicle.getSuspensionRepairPrice() * price) {
            if (NumberGenerator.calcProbability(repairProbability)) {
                vehicle.setSuspension(true);
                System.out.println("Succesful repair");
                player.setBalance(player.getBalance() - (int) (vehicle.getSuspensionRepairPrice() * price));
                player.removeVehicle(vehicle);
                vehicle.setPrice((int) (vehicle.getPrice() * 1.2f));
                player.addVehicle(vehicle);
                return true;
            } else {
                System.out.println("Repair failure");
            }
        } else {
            System.out.println("No funds.");
        }
        return false;
    }

    public boolean repairEngine(Vehicle vehicle, Player player) {
        if (player.getBalance() > vehicle.getEngineRepairPrice() * price) {
            if (NumberGenerator.calcProbability(repairProbability)) {
                vehicle.setEngine(true);
                System.out.println("Succesful repair");
                player.setBalance(player.getBalance() - (int) (vehicle.getEngineRepairPrice() * price));
                player.removeVehicle(vehicle);
                vehicle.setPrice((int) (vehicle.getPrice() * 2.0f));
                player.addVehicle(vehicle);
                return true;
            } else {
                System.out.println("Repair failure");
            }
        } else {
            System.out.println("No funds.");
        }
        return false;
    }

    @Override
    public boolean repairBody(Vehicle vehicle, Player player) {
        if (player.getBalance() > vehicle.getCarBodyRepairPrice() * price) {
            if (NumberGenerator.calcProbability(repairProbability)) {
                vehicle.setCarBody(true);
                System.out.println("Succesful repair");
                player.setBalance(player.getBalance() - (int) (vehicle.getCarBodyRepairPrice() * price));
                player.removeVehicle(vehicle);
                vehicle.setPrice((int) (vehicle.getPrice() * 1.5f));
                player.addVehicle(vehicle);
                return true;
            } else {
                System.out.println("Repair failure");
            }
        } else {
            System.out.println("No funds.");
        }
        return false;
    }

    @Override
    public boolean repairGearBox(Vehicle vehicle, Player player) {
        if (player.getBalance() > vehicle.getGearBoxRepairPrice() * price) {
            if (NumberGenerator.calcProbability(repairProbability)) {
                vehicle.setGearBox(true);
                System.out.println("Succesful repair");
                player.setBalance(player.getBalance() - (int) (vehicle.getGearBoxRepairPrice() * price));
                player.removeVehicle(vehicle);
                vehicle.setPrice((int) (vehicle.getPrice() * 1.5f));
                player.addVehicle(vehicle);
                return true;
            } else {
                System.out.println("Repair failure");
            }
        } else {
            System.out.println("No funds.");
        }
        return false;
    }
}
