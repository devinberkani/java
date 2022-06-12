class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here

        int element;
        int square;

        if (array != null && index >= 0 && index <= array.length - 1) {
            element = array[index];
            square = element * element;
            System.out.println(square);
        } else {
            System.out.println("Exception!");
        }
    }
}