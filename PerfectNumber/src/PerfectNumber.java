public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            System.out.println("false");
            return false;
        }
        int i = 1;
        int sum = 0;
        while (i < number) {
            if (number % i == 0) {
                sum += i;
            }
            i++;
        }
        if(number == sum) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
}
