public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double numberOne, double numberTwo) {
        return (int) (numberOne * 1000) == (int) (numberTwo * 1000);
    }
}
