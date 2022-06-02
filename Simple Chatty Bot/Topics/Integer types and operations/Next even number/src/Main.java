import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int input = scanner.nextInt();
        int remainder = input % 2;

        int nextEven = input + (2 - remainder);

        System.out.println(nextEven);

    }
}