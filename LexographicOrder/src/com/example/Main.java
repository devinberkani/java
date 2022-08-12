package com.example;

public class Main {
    public static void main(String[] args) {

        int[] listOne = {1, 2, 3, 4, 5};
        int[] listTwo = {1, 2, 3, 4, 5};




        int start = 1;
        int max = 5;
        while (start <= max) {
            decompose(start, max);
            System.out.println();
            start++;
        }
//        countDown(5);

//        ArrayList<String> numbers = new ArrayList<>();
//
//        for (int i = 0; i < 30; i ++) {
//            numbers.add(Integer.toString(i));
//        }
//
//        System.out.println(numbers);
//
//        Collections.sort(numbers);
//
//        System.out.println(numbers);
//
    }

    public static void decompose(int start, int max) {
        if (start == max) {
            System.out.println(start);
        } else {
            int accumulator = 0;
            while (accumulator < max) {
                while (accumulator + start > max) {
                    start--;
                }
                accumulator += start;
                System.out.print(start + " ");
            }
        }
    }

    public static void countDown(int number) {
        if (number <= 1) {
            System.out.println(number);
        } else {
            for (int i = number; i > 0; i--) {
                System.out.println(i);
            }
            countDown(number - 1);
        }
    }

}
