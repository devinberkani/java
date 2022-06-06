import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] cinemaSeats = new int[n][m];

        for (int i = 0; i < cinemaSeats.length; i++) {
            for (int j = 0; j < cinemaSeats[i].length; j++) {
                cinemaSeats[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();


        int emptySeatCount = 0;
        int finalRowNumber = 0;

        for (int i = 0; i < cinemaSeats.length; i++) {
            if(finalRowNumber > 0) {
                break;
            }
            emptySeatCount = 0;
            for (int j = 0; j < cinemaSeats[i].length; j++) {
                if (cinemaSeats[i][j] == 0) {
                    emptySeatCount++;
                    if (emptySeatCount == k) {
                        finalRowNumber = i + 1;
                    }
                } else {
                    emptySeatCount = 0;
                }
            }
        }
        System.out.println(finalRowNumber);
    }
}