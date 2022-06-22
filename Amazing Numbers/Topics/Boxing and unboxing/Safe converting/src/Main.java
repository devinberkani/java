import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        int defaultInt = 0;
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        if (val == null) {
            return defaultInt;
        } else if (val > maxInt) {
            return maxInt;
        } else if (val < minInt) {
            return minInt;
        } else {
            return val.intValue();
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}