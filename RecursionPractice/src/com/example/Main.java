package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n != -1) {
            collatz(n, 0);
            n = scanner.nextInt();
        }
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
