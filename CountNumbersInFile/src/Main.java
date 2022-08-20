import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pathToFile = "./dataset_91033.txt";

        System.out.println(printFile(pathToFile));

    }

    public static int printFile(String pathToFile) {

        int sum = 0;
        File file = new File(pathToFile);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int currentNumber = scanner.nextInt();
                sum += currentNumber;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
        return sum;
    }
}