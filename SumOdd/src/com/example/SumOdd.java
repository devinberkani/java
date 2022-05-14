package com.example;

public class SumOdd {
    public static boolean isOdd (int number) {
        if (number <= 0) {
            return false;
        } else {
            if (number % 2 == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static int sumOdd(int start, int end) {
        if((start > end) || (start <= 0) || (end <= 0)) {
            return -1;
        } else {
            int sum = 0;
            for(int i=start; i<=end; i++) {
                if (isOdd(i)) {
                    sum+=i;
                }
            }
            System.out.println(sum);
            return sum;
        }
    }
}
