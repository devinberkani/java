import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] userInputArray = userInput.split(" ");
        ArrayList<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < userInputArray.length; i++) {
            int currentNumber = Integer.parseInt(userInputArray[i]);
            if (i % 2 != 0) {
                integerList.add(currentNumber);
            }
        }
        Collections.reverse(integerList);
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i));
            if (i != integerList.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}