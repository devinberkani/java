import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] userInputArr = userInput.split(" ");
        boolean answer = true;

        for(int i = 1; i < userInputArr.length; i++) {
            int result = userInputArr[i].compareTo(userInputArr[i - 1]);
            if (result < 0) {
                answer = false;
                break;
            }
        }
        System.out.println(answer);
    }

}