import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s: strings) {
            if (!s.matches("\\d+")) {
                stringBuilder.append(s);
            }
        }

        String myString = stringBuilder.toString();
        return myString.replaceAll("\\d+", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}