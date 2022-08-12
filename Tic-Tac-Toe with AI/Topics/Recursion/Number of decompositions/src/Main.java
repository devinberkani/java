import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        ArrayList<String> numberCheckArr = new ArrayList<>();

        for (int i = 1; i <= input; i++) {
            numberCheckArr.add(Integer.toString(i));
        }

        Collections.sort(numberCheckArr); // lexicographically sort and reverse array of inputs

//        for (String s : numberCheckArr) {
//            System.out.println(s);
//        }

        method(input, numberCheckArr, 0);
    }

    public static void method(int input, ArrayList<String> numberCheckArr, int numberCheckIndex) {

        int numberCheck = Integer.parseInt(numberCheckArr.get(numberCheckIndex));
        int lastNumberCheck = Integer.parseInt(numberCheckArr.get(numberCheckArr.size() - 1));

        ArrayList<Integer> prevNumbers = new ArrayList<>();
        ArrayList<Integer> currentNumbers = new ArrayList<>();
        int iteration = 1;
        int nextNumber = 1;
        // increments next number for each number check
        while (nextNumber <= numberCheck) {
//                System.out.println("number check is " + numberCheck);
            // prints each row of number check
            int accumulator = numberCheck;
            while (accumulator != input) {
                while ((accumulator + nextNumber) > input) {
                    nextNumber--;
                }
                accumulator += nextNumber;
//                    System.out.println("accumulator is " + accumulator);
                if (accumulator <= input) {
                    currentNumbers.add(nextNumber);
                }
            }
            currentNumbers.add(numberCheck);
            currentNumbers.sort(Collections.reverseOrder());
            if (!currentNumbers.equals(prevNumbers)) {
                prevNumbers.clear();
                for (int i = 0; i < currentNumbers.size(); i++) {
                    prevNumbers.add(currentNumbers.get(i));
                    System.out.print(currentNumbers.get(i));
                    if (i != currentNumbers.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            currentNumbers.clear();
            iteration++;
            nextNumber = iteration;
//                System.out.println("next number is " + nextNumber);
        }
        if (numberCheck != lastNumberCheck) {
            numberCheckIndex++;
            method(input, numberCheckArr, numberCheckIndex);
        }
    }

}