package com.example;

public class Main {
    public static void main(String[] args) {

//        int highScore = calculateScore(true, 800, 5, 100);
//        System.out.println("Your final score was " + highScore);
//
//
//        highScore = calculateScore(true, 10000, 8, 200);
//        System.out.println("Your final score was " + highScore);

        displayHighScorePosition("Devin", calculateHighScorePosition(1500));

        displayHighScorePosition("Carrie", calculateHighScorePosition(900));

        displayHighScorePosition("Cam", calculateHighScorePosition(400));

        displayHighScorePosition("Nate", calculateHighScorePosition(50));

    }

    // must include type of variable
    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = (score + (levelCompleted * bonus));
            finalScore += 2000;
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String playersName, int highScorePosition) {
        System.out.println(playersName + " managed to get into position " + highScorePosition + " on the high score table.");
    }

    public static int calculateHighScorePosition(int playerScore) {
//        if (playerScore >= 1000) {
//            return 1;
//        } else if (playerScore >= 500) {
//            return 2;
//        } else if (playerScore >= 100) {
//            return 3;
//        }
//        return 4;
        int position = 4; // assuming position 4 will be returned

        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100); {
            position = 3;
        }
        return position;
    }
}


