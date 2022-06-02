import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        String input = scanner.nextLine();
        input = input.toLowerCase();
        System.out.println(input.startsWith("j"));
    }
}