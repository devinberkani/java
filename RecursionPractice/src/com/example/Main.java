package com.example;

public class Main {
    public static void main(String[] args) {
        printNumber(1);
    }

    // 1. what's the simples possible input?

    // example 1 from video
    public static void printNumber(int n) {
        if (n > 5) {
            return;
        }
        System.out.println(n);
        printNumber(n + 1);

    }
}
