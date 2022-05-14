public class DigitSumChallenge {
    public static int sumDigits(int number) {
        if (number < 10) {
            return -1;
        }
        int sum = 0;
        while (number >= 1) {
            int extractedLastNumber = number % 10;
            sum+=extractedLastNumber;
            number /= 10;
        }
        System.out.println(sum);
        return sum;
    }
}
