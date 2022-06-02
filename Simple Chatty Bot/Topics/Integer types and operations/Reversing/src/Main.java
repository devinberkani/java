import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();

        int lastDigit = number % 10;
        int middleDigit = (number % 100) / 10;
        int firstDigit = (number % 1000) / 100;

        lastDigit *= 100;
        middleDigit *= 10;

        System.out.println(lastDigit + middleDigit + firstDigit);

    }
}