import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int hours1 = scanner.nextInt();
        int minutes1 = scanner.nextInt();
        int seconds1 = scanner.nextInt();

        int hours2 = scanner.nextInt();
        int minutes2 = scanner.nextInt();
        int seconds2 = scanner.nextInt();

        int hoursDif = hours2 - hours1;
        int minutesDif = minutes2 - minutes1;
        int secondsDif = seconds2 - seconds1;

        int hoursToSeconds = hoursDif * 3600;
        int minutesToSeconds = minutesDif * 60;

        int totalSeconds = secondsDif + hoursToSeconds + minutesToSeconds;

        System.out.println(totalSeconds);
    }
}