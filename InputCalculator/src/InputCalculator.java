import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        long count = 0;
        long sum = 0;
        long average = 0;

        while(true) {
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt) {
                int userInput = scanner.nextInt();
                count++;
                sum += userInput;
                average = Math.round(((double) sum / (double) count));
            } else {
                break;
            }
        }
        scanner.close();
        System.out.println("SUM = " + sum + " AVG = " + average);
    }
}
