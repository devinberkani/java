import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(input);

        int inputLength = input.length();

        if (inputLength % 2 != 0) {
            int middleCharacter = (inputLength / 2);
            stringBuilder.deleteCharAt(middleCharacter);
        } else {
            int middleCharacter = (inputLength / 2) - 1;
            stringBuilder.deleteCharAt(middleCharacter);
            stringBuilder.deleteCharAt(middleCharacter);
        }

        System.out.println(stringBuilder);
    }
}