import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int[] box1 = new int[3];
        int[] box2 = new int[3];

        for (int i = 0; i < box1.length; i++) {
            box1[i] = scanner.nextInt();
        }

        for (int i = 0; i < box2.length; i++) {
            box2[i] = scanner.nextInt();
        }

        Arrays.sort(box1);
        Arrays.sort(box2);

        int box1BiggerCount = 0;
        int box2BiggerCount = 0;
        for (int i = 0; i < box1.length; i++) {
            if (box1[i] > box2[i]) {
                box1BiggerCount++;
            } else if (box2[i] > box1[i]){
                box2BiggerCount++;
            }
        }

        if (box1BiggerCount == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (box2BiggerCount == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}