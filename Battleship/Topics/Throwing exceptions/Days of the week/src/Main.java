import java.util.*;

public class Main {

    public static String getDayOfWeekName(int number) {
        if (number < 1 || number > 7) {
            throw new IllegalArgumentException();
        } else if (number == 1) {
            return "Mon";
        } else if (number == 2) {
            return "Tue";
        } else if (number == 3) {
            return "Wed";
        } else if (number == 4) {
            return "Thu";
        } else if (number == 5) {
            return "Fri";
        } else if (number == 6) {
            return "Sat";
        } else {
            return "Sun";
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}