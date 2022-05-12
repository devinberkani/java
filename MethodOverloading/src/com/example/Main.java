package com.example;

public class Main {
    public static void main(String[] args) {
//        int newScore = calculateScore("Tim", 500);
//        System.out.println("New score is " + newScore);
//        calculateScore(75);
//        calculateScore();
        calcFeetAndInchesToCentimeters(-1);

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet >= 0 && inches >=0 && inches <= 12) {
            double totalInches = (feet * 12) + inches;
            double centimeters = totalInches * 2.54;
            System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " centimeters");
            return centimeters;
        } else {
            return -1;
        }
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches >= 0) {
            double feet = inches / 12;
            double remainderInches = inches % 12;
            feet = (int) feet;
//            System.out.println(feet + " feet and " + remainderInches + " inches");
            return calcFeetAndInchesToCentimeters(feet, remainderInches);
        } else {
            System.out.println("Invalid input");
            return -1;
        }
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }
}
