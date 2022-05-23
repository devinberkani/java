package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //write code below
        int[] myArray = getIntegers(5);
        sortIntegers(myArray);
    }

    public static int[] getIntegers(int number) {
        Scanner scanner = new Scanner(System.in);
        int[] enteredValues = new int[number];
        System.out.println("Enter " + number + " numbers below\r");
        for(int i = 0; i < number; i++) {
            enteredValues[i] = scanner.nextInt();
        }
        return enteredValues;
    }


    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array){
        int[] sortedValues = array.clone();
        Arrays.sort(sortedValues);
        int[] descendingArray = new int[sortedValues.length];
        //REVERSE ARRAY HERE -- THIS IS THE LAST STEP*********************
        int count = 0;
        for(int i = (sortedValues.length - 1); i >= 0; i--) {
            descendingArray[count] = sortedValues[i];
            count++;
        }
        printArray(descendingArray);
        return descendingArray;
    }

}
