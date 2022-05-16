import java.util.Scanner;

public class MinimumAndMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
//        boolean first = true;

        while(true) {
            System.out.println("Enter number: ");
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt) {
                userInput = scanner.nextInt();
//                if(first) {
//                    first = false;
//                    min = userInput;
//                    max = userInput;
//                }
                if(userInput < min) {
                    min = userInput;
                }
                if(userInput > max) {
                    max = userInput;
                }
            } else {
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
        System.out.println("Smallest number was " + min);
        System.out.println("Biggest number was " + max);
    }

}
