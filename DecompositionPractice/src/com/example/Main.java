package com.example;

class DecompositionPractice {
    public static void main(String[] args) {
        System.out.println(method(29815));
    }

    public static long method(long n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + method(n / 10);
    }
}