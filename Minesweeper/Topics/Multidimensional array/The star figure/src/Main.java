import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int size = scanner.nextInt();
       printStar(size);
    }

    public static void printStar(int size) {
        char[][] star = new char[size][size];

        for (char[] row: star) {
            Arrays.fill(row, '.');
        }

        int middleIndex = (size / 2);

        // print the star
        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[i].length; j++) {
                if (i == middleIndex) {
                    star[i][j] = '*';
                }
                if (j == middleIndex) {
                    star[i][j] = '*';
                }
                if (i == j) {
                    star[i][j] = '*';
                }
                if (i + j == star.length - 1) {
                    star[i][j] = '*';
                }
                System.out.print(star[i][j]);
                if (j != star.length - 1) {
                    System.out.print(" ");
                }
            }
            if (i != star.length - 1) {
                System.out.println();
            }
        }
    }
}