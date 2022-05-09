package com.example;

public class Main {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 0;
        int levelCompleted = 0;
        int bonus = 0;
        int finalScore = 0;

//        if (score < 5000 && score > 1000) {
//            System.out.println("Your score was less than 5000 but greater than 1000");
//        } else if (score < 1000) {
//            System.out.println("Your score was less than 1000");
//        } else {
//            System.out.println("Got here");
//        }

        if (gameOver == true) {
            score = 800;
            levelCompleted = 5;
            bonus = 100;
            finalScore = (score + (levelCompleted * bonus));
            System.out.println("Your final score was " + finalScore);
        }

        if (gameOver == true) {
            score = 10000;
            levelCompleted = 8;
            bonus = 200;
            finalScore = (score + (levelCompleted * bonus));
            System.out.println("Your final score was " + finalScore);
        }


    }
}
