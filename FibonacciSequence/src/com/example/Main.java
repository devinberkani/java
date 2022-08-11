package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));

        System.out.println(method(7));
    }

    public static long method(long n) {
        if (n <= 1) {
            return n;
        }
        return n + method(n - 1) - 1;
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //4 logic
    // | = separator

    // fib(3) + fib(2)
    // fib(2) + fib(1) | fib(1) + fib(0)
    // fib(1) + fib(0) | + 1 | + 1
    // 1 + 0 + 1 + 1
    // 3

    //3 logic

    // fib(2) + fib(1)
    // fib(1) + fib(0) | + 1
    // 1 + 0 + 1
    // 2

}
