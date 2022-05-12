public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        System.out.println(getDurationString(5678));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65, 9));
    }
    public static String getDurationString(int minutes, int seconds) {
        if ((minutes >= 0) && (seconds >= 0) && (seconds <= 59)) {
            int totalSeconds = seconds + (minutes * 60);
            int numHours = totalSeconds / 3600;
            totalSeconds = totalSeconds - (numHours * 3600);
            int numMinutes = totalSeconds / 60;
            totalSeconds = totalSeconds - (numMinutes * 60);
            int numSeconds = totalSeconds;
            String strHours = numHours + "h ";
            String strMinutes = numMinutes + "m ";
            String strSeconds = numSeconds + "s";
            if ((numHours < 10)) {
                strHours = "0" + strHours;
            }
            if ((numMinutes < 10)) {
                strMinutes = "0" + strMinutes;
            }
            if ((numSeconds < 10)) {
                strSeconds = "0" + strSeconds;
            }
            return strHours + strMinutes + strSeconds;
        } else {
            return INVALID_VALUE_MESSAGE;
        }
    }

    public static String getDurationString(int seconds) {
        if (seconds >= 0) {
            int numMinutes = seconds / 60;
            int numSeconds = seconds % 60;
//            System.out.println(numMinutes + " " + numSeconds);
            return getDurationString(numMinutes, numSeconds);
        } else {
            return INVALID_VALUE_MESSAGE;
        }
    }
}
