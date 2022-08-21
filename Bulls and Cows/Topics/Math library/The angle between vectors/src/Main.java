import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double u1 = scanner.nextInt();
        double u2 = scanner.nextInt();

        double v1 = scanner.nextInt();
        double v2 = scanner.nextInt();

        double vec1Length = getVectorLength(u1, u2);
        double vec2Length = getVectorLength(v1, v2);

        System.out.println(getAngle(u1, u2, v1, v2, vec1Length, vec2Length));
    }

    public static double getVectorLength(double comp1, double comp2) {
        return Math.sqrt((Math.pow(comp1, 2) + Math.pow(comp2, 2)));
    }

    public static double getAngle(double u1, double u2, double v1, double v2, double length1, double length2) {
        return Math.toDegrees(Math.acos(((u1 * v1) + (u2 * v2)) / (length1 * length2)));
    }
}