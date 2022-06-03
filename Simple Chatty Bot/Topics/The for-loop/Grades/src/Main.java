import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int n = scanner.nextInt(); // number of total grades

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;

        for (int i = -1; i < n; i++) {
            String grade = scanner.nextLine();
            aCount = grade.equals("A") ? ++aCount : aCount;
            bCount = grade.equals("B") ? ++bCount : bCount;
            cCount = grade.equals("C") ? ++cCount : cCount;
            dCount = grade.equals("D") ? ++dCount : dCount;
        }

        System.out.println();
        System.out.println(dCount + " " + cCount + " " + bCount + " " + aCount);

    }
}