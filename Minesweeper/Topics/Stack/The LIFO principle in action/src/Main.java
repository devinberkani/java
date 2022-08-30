import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            deque.push(scanner.nextInt());
        }

        for (int i = 0; i < n ; i++) {
            System.out.println(deque.pop());
        }
    }
}