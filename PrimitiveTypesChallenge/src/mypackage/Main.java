package mypackage;

public class Main {
    public static void main(String[] args) {
        byte myChallengeByteVariable = 10;
        short myChallengeShortVariable = 20;
        int myChallengeIntVariable = 50;
        long myChallengeLongVariable = 50000 + (10 * (myChallengeByteVariable + myChallengeShortVariable + myChallengeIntVariable));

        short shortTotal = (short) (1000 + 10 * (myChallengeByteVariable + myChallengeShortVariable + myChallengeIntVariable));



        System.out.println(myChallengeLongVariable);
    }
}


