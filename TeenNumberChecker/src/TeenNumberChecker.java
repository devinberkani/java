public class TeenNumberChecker {

    public static boolean isTeen(int checkNum) {
        if (checkNum >= 13 && checkNum <= 19 ) {
            return true;
        }  else {
            return false;
        }
    }

    public static boolean hasTeen(int num1, int num2, int num3) {
        if (isTeen(num1) || isTeen(num2) || isTeen(num3)) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
}
