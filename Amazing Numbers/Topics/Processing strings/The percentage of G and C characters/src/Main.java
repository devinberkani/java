import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        char[] inputArr = input.toCharArray();

        double inputLength = inputArr.length;
        double count = 0;

        for (char c : inputArr) {
            if (c == 'g' || c == 'c') {
                count++;
            }
        }

        double result = (count / inputLength) * 100;

        System.out.println(result);

    }
}