import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int a = scanner.nextInt(); // min hours you should sleep
        int b = scanner.nextInt(); // max hours you should sleep
        int h = scanner.nextInt(); // hours slept

        if(h < a) {
            System.out.println("Deficiency");
        } else if(h > b) {
            System.out.println("Excess");
        } else {
            System.out.println("Normal");
        }

    }
}