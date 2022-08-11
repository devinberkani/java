import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        method(input, 1);
    }

    public static void method(int input, int numberCheck) {
        int nextNumberCheck = numberCheck + 1;
        if (input == numberCheck) {
            System.out.println(input);
        } else {
            int accumulator = 0;
            while (accumulator != input) {
                if ((accumulator + numberCheck) > input) {
                    numberCheck--;
                    // need to find a way for numbers to go back and check starting at 1 for consecutive checks
                }
                accumulator += numberCheck;
                if (accumulator <= input) {
                    printNumber(numberCheck);
                }
            }
            System.out.println();
            method(input, nextNumberCheck);
        }
    }

    public static void printNumber (int numberCheck) {
        System.out.print(numberCheck);
        System.out.print(" ");

    }

}