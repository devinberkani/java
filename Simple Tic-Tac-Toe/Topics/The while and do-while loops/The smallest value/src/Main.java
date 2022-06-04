import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long m = scanner.nextLong();
        int n = 0;
        long total = 1;
        int testNumber = 1;
        boolean complete = false;
        while (!complete) {
            n++;
            testNumber = n;
            while(testNumber > 0) {
                total *= testNumber;
                if (total > m) {
                    complete = true;
                }
                testNumber--;
            }
            total = 1;
        }
        System.out.println(n);
    }
}