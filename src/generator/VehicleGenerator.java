package generator;

import enums.Brand;
import enums.Color;
import vehicles.Car;
import vehicles.Truck;

public class VehicleGenerator {
    private static int vehicleCounter = 0;

    public static Car generateCar(int parameter) {
        Car car = new Car();
        car.setId(vehicleCounter);
        car.setBrand(Brand.getRandom());
        car.setPrice((int) (NumberGenerator.getRandomInt(500, 1200 + parameter) * car.getBrand().getPriceMultiply()));
        car.setMileage(NumberGenerator.getRandomInt(5000, 300000));
        car.setColor(Color.getRandom());
        car.setCarBody(NumberGenerator.getRandomBoolean());
        car.setBrakes(NumberGenerator.getRandomBoolean());
        car.setEngine(NumberGenerator.getRandomBoolean());
        car.setGearBox(NumberGenerator.getRandomBoolean());
        car.setSuspension(NumberGenerator.getRandomBoolean());
        car.setType("car");
        car.setBrakesRepairPrice((int) (NumberGenerator.getRandomInt(100, 300) * car.getBrand().getPriceMultiply()));
        car.setSuspensionRepairPrice((int) (NumberGenerator.getRandomInt(300, 500) * car.getBrand().getPriceMultiply()));
        car.setEngineRepairPrice((int) (NumberGenerator.getRandomInt(1000, 2000) * car.getBrand().getPriceMultiply()));
        car.setCarBodyRepairPrice((int) (NumberGenerator.getRandomInt(500, 1000) * car.getBrand().getPriceMultiply()));
        car.setGearBoxRepairPrice((int) (NumberGenerator.getRandomInt(500, 1000) * car.getBrand().getPriceMultiply()));
        vehicleCounter++;
        return car;
    }

    public static Truck generateTruck(int parameter) {
        Truck truck = new Truck();
        truck.setId(vehicleCounter);
        truck.setBrand(Brand.getRandom());
        truck.setPrice((int) (NumberGenerator.getRandomInt(2000, 5200 + parameter) * truck.getBrand().getPriceMultiply()));
        truck.setMileage(NumberGenerator.getRandomInt(5000, 300000));
        truck.setColor(Color.getRandom());
        truck.setCapacity(NumberGenerator.getRandomInt(1000, 3000));
        truck.setCarBody(NumberGenerator.getRandomBoolean());
        truck.setBrakes(NumberGenerator.getRandomBoolean());
        truck.setEngine(NumberGenerator.getRandomBoolean());
        truck.setGearBox(NumberGenerator.getRandomBoolean());
        truck.setSuspension(NumberGenerator.getRandomBoolean());
        truck.setType("truck");
        truck.setBrakesRepairPrice((int) (NumberGenerator.getRandomInt(400, 600) * truck.getBrand().getPriceMultiply()));
        truck.setSuspensionRepairPrice((int) (NumberGenerator.getRandomInt(200, 400) * truck.getBrand().getPriceMultiply()));
        truck.setEngineRepairPrice((int) (NumberGenerator.getRandomInt(1000, 2000) * truck.getBrand().getPriceMultiply()));
        truck.setCarBodyRepairPrice((int) (NumberGenerator.getRandomInt(700, 1000) * truck.getBrand().getPriceMultiply()));
        truck.setGearBoxRepairPrice((int) (NumberGenerator.getRandomInt(500, 1000) * truck.getBrand().getPriceMultiply()));
        vehicleCounter++;
        return truck;
    }
}