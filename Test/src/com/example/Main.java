package com.example;

public class Main {
    public static void main(String[] args) {
        long userNumber = 132;
        String[] userNumberArr = Long.toString(userNumber).split("");
        int userNumberLength = userNumberArr.length;

        // get first and last number and put them together
        String firstNumber = userNumberArr[0];
        String lastNumber = userNumberArr[userNumberLength - 1];

        String firstAndLast = firstNumber + lastNumber;
        System.out.println(firstAndLast);
    }
}
