import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        decompose(n, 0, n, "");
    }

    // ssf: sum so far
    // asf: answer so far
    // num: actual number
    private static void decompose(int n, int ssf, int num, String asf) {
        if (ssf > num) {
            return;
        }

        if (ssf == num) {
            System.out.println(asf);
            return;
        }

        for (int i = 1; i <= n; i++) {
            decompose(i, ssf + i, num, asf + i + " ");
        }
    }
}