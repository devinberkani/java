import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] numArray = new int[arrSize];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = scanner.nextInt();
        }

        int n = scanner.nextInt(); // number to check
        int nCount = 0;

        for (int num : numArray) {
            if (num == n) {
                nCount++;
            }
        }

        System.out.println(nCount);

    }
}