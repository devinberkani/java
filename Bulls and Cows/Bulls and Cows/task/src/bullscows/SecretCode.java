package bullscows;

import java.util.ArrayList;
import java.util.Random;

public class SecretCode {
    private final ArrayList<Integer> secretCode = new ArrayList<>();

    public SecretCode() {
        setSecretCode();
    }

    // generate secret code of numbers between 0-9
    private void setSecretCode() {

        Random random = new Random();
        int upperBound = 10;

        // fill secretCode array
        for (int i = 0; i < 4; i++) {
            secretCode.add(random.nextInt(upperBound));
        }
    }

    protected ArrayList<Integer> getSecretCode() {
        return secretCode;
    }
}
