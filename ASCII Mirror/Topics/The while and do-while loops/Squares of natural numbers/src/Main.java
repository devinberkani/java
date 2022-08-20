import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        getSquares(input);
    }

    public static void getSquares(int input) {
        int currentNumber = 1;
        int square = 1;
        while (square <= input) {
            System.out.println(square);
            currentNumber++;
            square = currentNumber * currentNumber;
        }
    }
}