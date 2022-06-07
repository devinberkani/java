import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here



        long firstValue = scanner.nextLong();
        String operation = scanner.next();
        long secondValue = scanner.nextLong();

        switch (operation) {
            case "+":
                System.out.println(firstValue + secondValue);
                break;

            case "-":
                System.out.println(firstValue - secondValue);
                break;

            case "/":
                if (secondValue == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(firstValue / secondValue);
                break;

            case "*":
                System.out.println(firstValue * secondValue);
                break;

            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}