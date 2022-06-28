import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();

        int uppercaseNeeded = A;
        int lowercaseNeeded = B;
        int integersNeeded = C;
        int totalNeeded = N;

        char[] uppercase = {'A', 'B'};
        char[] lowercase = {'c', 'd'};

        StringBuilder password = new StringBuilder();

        boolean isIndex = true;
        int index;

        // uppercase
        while (uppercaseNeeded > 0) {
            index = isIndex ? 0 : 1;
            password.append(uppercase[index]);
            isIndex = !isIndex;
            uppercaseNeeded--;
            totalNeeded--;
        }

        // lowercase
        while (lowercaseNeeded > 0) {
            index = isIndex ? 0 : 1;
            password.append(lowercase[index]);
            isIndex = !isIndex;
            lowercaseNeeded--;
            totalNeeded--;
        }

        // integers
        while (integersNeeded > 0) {
            index = isIndex ? 1 : 2;
            password.append(index);
            isIndex = !isIndex;
            integersNeeded--;
            totalNeeded--;
        }

        // check to make sure there are enough characters
        while (totalNeeded > 0) {
            index = isIndex ? 0 : 1;
            password.append(uppercase[index]);
            isIndex = !isIndex;
            totalNeeded--;
        }

        System.out.println(password);

    }
}