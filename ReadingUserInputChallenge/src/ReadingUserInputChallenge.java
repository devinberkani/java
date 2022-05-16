import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {

        //initiate scanner
        Scanner scanner = new Scanner(System.in);

        //initiate count
        int numberCount = 1;
        //initiate sum
        int sum = 0;

        while(numberCount <= 10) {
            //tell user to enter number
            System.out.println("Enter number #" + numberCount + ": ");
            //initiate boolean to tell if entry is number
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                int enteredNumber = scanner.nextInt();
                sum += enteredNumber;
                numberCount++;
            } else {
                System.out.println("Invalid Number");
            }
            scanner.nextLine(); //handle next line character (enter key)
        }
        //close scanner
        scanner.close();
        System.out.println("The sum of all of your numbers is " + sum);
    }

}
