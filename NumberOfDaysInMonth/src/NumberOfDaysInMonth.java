public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            System.out.println("false");
            return false;
        } else {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("true");
                return true;
            } else {
                System.out.println("false");
                return false;
            }
        }
    }

    public static int getDaysInMonth (int month, int year) {
        boolean leapYear = isLeapYear(year);
        if ((month < 1 || month > 12) || ((year < 1) || (year > 9999))) {
            return -1;
        } else {
            if (leapYear) {
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        System.out.println("31");
                        return 31;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        System.out.println("30");
                        return 30;

                    case 2:
                        System.out.println("29");
                        return 29;

                    default:
                        System.out.println("-1");
                        return -1;
                }
            } else {
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        System.out.println("31");
                        return 31;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        System.out.println("30");
                        return 30;

                    case 2:
                        System.out.println("28");
                        return 28;

                    default:
                        System.out.println("-1");
                        return -1;
                }
            }
        }
    }
}
