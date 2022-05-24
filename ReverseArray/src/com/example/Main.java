package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        reverse(testArray);
    }

    private static void reverse(int[] array) {
        String passedArray = Arrays.toString(array);
        System.out.println("Array = " + passedArray);
        int[] newArray = new int [array.length];
        int count = 0;
        for(int i = array.length - 1; i >= 0; i--) {
            newArray[count] = array[i];
            count++;
        }
        String myArray = Arrays.toString(newArray);
        System.out.println("Reversed array = " + myArray);
    }

}
