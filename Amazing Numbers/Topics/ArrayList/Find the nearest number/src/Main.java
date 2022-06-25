import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputArray = getIntegerList(scanner);
        int number = getNumber(scanner);
        getClosestNumbers(inputArray, number);
    }

    public static void getClosestNumbers(ArrayList<Integer> inputArray, int number) {
        ArrayList<Integer> finalList = new ArrayList<>();
        int currentNumDistance = Integer.MAX_VALUE;
        int closestDistance = Integer.MAX_VALUE;
        // get closest distance
        for (int n : inputArray) {
            currentNumDistance = Math.abs(number - n);
            if (currentNumDistance < closestDistance) {
                closestDistance = Math.abs(number - n);
            }
        }
        // add numbers with closest distance to array
        for (int n : inputArray) {
            currentNumDistance = Math.abs(number - n);
            if (currentNumDistance == closestDistance) {
                finalList.add(n);
            }
        }
        // put list in ascending order
        Collections.sort(finalList);
        // print the list
        for (int i = 0; i < finalList.size(); i++) {
            System.out.print(finalList.get(i));
            if (i != finalList.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int getNumber(Scanner scanner) {
        return scanner.nextInt();
    }

    public static ArrayList<Integer> getIntegerList(Scanner scanner) {
        ArrayList<Integer> integerList = new ArrayList<>();
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        for (String num : inputArray) {
            int inputNumber = Integer.parseInt(num);
            integerList.add(inputNumber);
        }
        return integerList;
    }
}