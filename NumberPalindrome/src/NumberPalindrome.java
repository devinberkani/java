public class NumberPalindrome {
    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int originalNumber = number;
        //111
        if (number < 0) {
            number *= -1;
        }
        while (number > 0) {
            int lastDigit = number % 10; // 7, 0, 7
            reverse *= 10; // 0, 70, 700
            reverse += lastDigit; // 7, 70, 707
            number /= 10; // 70, 7, 0
        }
        if (originalNumber < 0) {
            reverse *= -1;
        }
        if(reverse == originalNumber) {
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }
}