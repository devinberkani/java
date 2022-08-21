import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextInt();
        double travelTime = scanner.nextInt();
        System.out.println(distance / travelTime);
    }
}