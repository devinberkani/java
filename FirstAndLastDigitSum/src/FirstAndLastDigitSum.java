public class FirstAndLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }
        int originalNumber = number;
        int firstDigit = 0;
        int lastDigit = number % 10;
        while (number > 0) {
            int variableDigit = number % 10;
            number /= 10;
            if (number == 0) {
                firstDigit = variableDigit;
            }
        }
        System.out.println(firstDigit);
        System.out.println(lastDigit);
        int sum = firstDigit + lastDigit;
        System.out.println(sum);
        return sum;
    }
}
