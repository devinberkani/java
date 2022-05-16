public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        }
        int i = 0;
        int j = 0;
        //all columns
        while(i < number) {
            //first row
            while (j < number) {
                System.out.print("*");
                j++;
            }
            i++;
            //new line
            System.out.println();
        }
    }
}
