import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int n = scanner.nextInt(); // length
        int m = scanner.nextInt(); // width
        int k = scanner.nextInt(); // numOfSquares

        //logic
        boolean notTooBig = k <= n * m;
        boolean noRemainders = k % n == 0 || k % m == 0;

        if(notTooBig && noRemainders) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}