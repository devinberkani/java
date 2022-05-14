public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            System.out.println("-1");
            return -1;
        }
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                sum += lastDigit;
            }
            number /= 10;
        }
        System.out.println(sum);
        return sum;
    }
}
