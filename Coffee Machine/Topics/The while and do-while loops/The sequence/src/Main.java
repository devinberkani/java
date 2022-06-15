import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int maxElement = 0;
        int numOfElements = scanner.nextInt();
        int count = 0;

        while(count < numOfElements) {
            int currentElement = scanner.nextInt();
            if (currentElement % 4 == 0 && currentElement > maxElement) {
                maxElement = currentElement;
            }
            count++;
        }
        System.out.println(maxElement);
    }
}