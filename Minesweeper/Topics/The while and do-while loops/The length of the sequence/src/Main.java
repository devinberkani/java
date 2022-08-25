import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> userInput = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int currentNumber = scanner.nextInt();
            if (currentNumber != 0) {
                userInput.add(currentNumber);
            } else {
                break;
            }
        }
        System.out.println(userInput.size());
    }
}