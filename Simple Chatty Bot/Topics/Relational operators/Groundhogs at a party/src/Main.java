import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value

        int numReesesCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        boolean weekdayParty = !isWeekend && numReesesCups >= 10 && numReesesCups <=20;
        boolean weekendParty = isWeekend && numReesesCups >= 15 && numReesesCups <= 25;
        boolean result = weekendParty || weekdayParty;

        System.out.println(result);

    }
}