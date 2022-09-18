import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String input = scanner.nextLine();
        switch(input) {

            case "triangle":
                System.out.println(getTriangleArea());
                break;

            case "rectangle":
                System.out.println(getRectangleArea());
                break;

            case "circle":
                System.out.println(getCircleArea());
                break;

            default:
                System.out.println("unknown shape entered");
                break;

        }
    }

    public static double getTriangleArea() {

        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));

    }

    public static double getRectangleArea() {

        double a = scanner.nextInt();
        double b = scanner.nextInt();

        return a * b;

    }

    public static double getCircleArea() {

        double r = scanner.nextInt();

        return 3.14 * (r * r);

    }
}