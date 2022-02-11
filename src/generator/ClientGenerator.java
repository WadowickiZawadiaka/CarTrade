package generator;

import enums.Brand;
import marketplace.Client;

public class ClientGenerator {
    private static int clientCounter = 0;

    public static Client generateClient() {
        String type = "car";
        if (NumberGenerator.getRandomBoolean())
            type = "truck";
        Client client = new Client((NumberGenerator.getRandomInt(5000, 100000)), NumberGenerator.getRandomBoolean(),
                type, clientCounter, Brand.getRandom(), Brand.getRandom());
        clientCounter++;
        return client;
    }
}

