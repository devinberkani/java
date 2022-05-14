public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
        int smallestNumber;
        int biggestNumber;
        if(first > second) {
            smallestNumber = second;
            biggestNumber = first;
        } else {
            smallestNumber = first;
            biggestNumber = second;
        }
        int divisor = 0;
        int i = 1;
        while(i <= smallestNumber) {
            if ((smallestNumber % i == 0) && (biggestNumber % i == 0)) {
                divisor = i;
            }
            i++;
        }
        System.out.println(divisor);
        return divisor;
    }
}
