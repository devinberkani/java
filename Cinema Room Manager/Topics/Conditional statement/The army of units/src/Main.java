import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int armySize = scanner.nextInt();

        if (armySize < 1) {
            System.out.println("no army");
        } else if (armySize < 20) {
            System.out.println("pack");
        } else if (armySize < 250) {
            System.out.println("throng");
        } else if (armySize < 1000) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }

    }

}