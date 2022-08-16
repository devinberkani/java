package com.example;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        while (n != -1) {
//            collatz(n, 0);
//            n = scanner.nextInt();
//        }

        System.out.println(method(129));

    }

    public static long method(long n) {
        if (n == 1) {
            return 0;
        }
        return method(n / 2) + 1;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 2 || s.length() == 1) { // (1)
            return true; // (2)
        }

        int lastIndex = s.length() - 1; // (3)
        boolean r = s.charAt(0) == s.charAt(lastIndex); // (4)

        return r || isPalindrome(s.substring(1, lastIndex)); // (5)
    }

    // 1. what's the simples possible input?

    // example 1 from video
    public static int collatz(int n, int counter) {

        if (n == 0 || n == 1) {
            System.out.println(counter);
            return 1;
        }
        if (n % 2 == 0) {
            counter++;
            return collatz(n / 2, counter);
        } else {
            counter++;
            return collatz((3 * n) + 1, counter);
        }

    }
}
