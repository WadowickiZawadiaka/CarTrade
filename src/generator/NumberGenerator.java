package generator;

import java.util.Random;

public class NumberGenerator {
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static boolean calcProbability(int probability) {
        Random random = new Random();
        int number = random.nextInt(100);
        return probability <= number;
    }
}
