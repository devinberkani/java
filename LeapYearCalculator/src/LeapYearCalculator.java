public class LeapYearCalculator {
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            System.out.println(("false"));
            return false;
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(("true"));
                    return true;
                }
            } else {
                System.out.println(("true"));
                return true;
            }
        }
        System.out.println(("false"));
        return false;
    }
}
