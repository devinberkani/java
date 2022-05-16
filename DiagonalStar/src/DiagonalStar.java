public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            int i = 0;
            int j = 0;
            //all columns
            while(i < number) {
                while (j < number) {
                    //first or last row
                    if(i == 0 || i == number - 1) {
                        System.out.print("*");
                        //first or last column
                    } else if(j == 0 || j == number - 1) {
                        System.out.print("*");
                        //if row == column
                    } else if (j == i) {
                        System.out.print("*");
                        //if column == rowCount - currentRow + 1
                    } else if (j == (number - 2) - i + 1) {
                        System.out.print("*");
                        //print empty space
                    } else {
                        System.out.print(" ");
                    }
                    j++;
                }
                j=0;
                i++;
                //new line
                System.out.println();
            }
        }
    }
}
