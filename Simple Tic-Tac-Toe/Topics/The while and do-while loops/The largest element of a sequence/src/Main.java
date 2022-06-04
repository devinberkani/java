import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int userInput = scanner.nextInt();
        int largestNumber = Integer.MIN_VALUE;

        while(userInput > 0) {
            if (userInput > largestNumber) {
                largestNumber = userInput;
            }
            userInput = scanner.nextInt();
        }

        System.out.println(largestNumber);
    }
}