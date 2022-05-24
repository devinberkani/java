package com.example;

import java.util.Scanner;

public class Main {

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers would you like in your array?\r");
        int count = scanner.nextInt();
        scanner.close();
        return count;
    }

    private static int[] readElements(int count) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + count + " numbers:\r");
        int[] myArray = new int [count];
        for(int i = 0; i < count; i++) {
            myArray[i] = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
        return myArray;
    }

    private static int findMin(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}
