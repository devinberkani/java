public class SharedDigit {
    public static boolean hasSharedDigit(int num1, int num2) {
        if(num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            System.out.println("false");
            return false;
        }
        int num1LastDigit = num1 % 10;
        int num1FirstDigit = 0;
        do {
            num1FirstDigit = num1 % 10;
            num1 /= 10;
        } while(num1 > 0);

        int num2LastDigit = num2 % 10;
        int num2FirstDigit = 0;
        do {
            num2FirstDigit = num2 % 10;
            num2 /= 10;
        } while(num2 > 0);
        if((num1FirstDigit == num2FirstDigit) || (num1LastDigit == num2FirstDigit) || (num1LastDigit == num2LastDigit) || (num1FirstDigit == num2LastDigit)) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
}
