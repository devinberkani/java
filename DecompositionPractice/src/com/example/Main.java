package com.example;

public class Main {
    public static void main(String[] args) {
        decompose(5);
    }

    public static void decompose(int number) {
        if (number < 1) {
            System.out.println("done");
        } else {
            int i = number;
            while (i > 0) {
                System.out.print(1);
                i--;
            }
            System.out.println();
            decompose(number - 1);
        }
    }
}
