public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            double mph = kilometersPerHour / 1.609;
            long roundedMph = Math.round(mph);
//            System.out.println(mph);
            return roundedMph;
        }
    }
    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long mph = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " km/h = " + mph + " mi/h");
        }
    }
}
// 1mph is 1.609kph