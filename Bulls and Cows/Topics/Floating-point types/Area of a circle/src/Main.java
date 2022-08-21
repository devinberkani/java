import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        System.out.println(getArea(radius));
    }

    public static double getArea(double radius) {
        return Math.PI * (radius * radius);
    }
}