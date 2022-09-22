import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean limitReached = false;
        int total = 0;

        while (!limitReached) {
            int currentNumber = scanner.nextInt();
            if (currentNumber == 0) {
                limitReached = true;
            } else {
                total += currentNumber;
                if (total >= 1000) {
                    total -= 1000;
                    limitReached = true;
                }
            }
        }
        System.out.println(total);
    }
}