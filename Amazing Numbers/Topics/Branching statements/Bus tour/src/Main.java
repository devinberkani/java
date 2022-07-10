import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int numBridges = scanner.nextInt();
        boolean willCrash = false;

        for (int i = 0; i < numBridges; i++) {
            int bridgeNumber = i + 1;
            if (scanner.nextInt() <= busHeight) {
                System.out.println("Will crash on bridge " + bridgeNumber);
                willCrash = true;
                break;
            }
        }
        if (!willCrash) {
            System.out.println("Will not crash");
        }
    }
}