import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int inputLength = input.length();

        char[] inputArr = input.toCharArray();

        char[] reverseInputArr = new char[inputLength];

        int countdown = inputLength - 1;
        for (int i = 0; i < inputLength; i++) {
            reverseInputArr[i] = inputArr[countdown];
            countdown--;
        }

        String result = Arrays.equals(inputArr, reverseInputArr) ? "yes" : "no";
        System.out.println(result);
    }
}