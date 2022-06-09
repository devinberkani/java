package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        // prompt user for row and seat numbers
        System.out.println("Enter the number of rows:");

        int numOfRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");

        int numOfSeats = scanner.nextInt();

        // array for initial seating arrangement
        char[][] seatingArrangement = new char[7][8];

        // calculate and print profit
        int totalSeats = numOfRows * numOfSeats;
        int ticketPrice = 0;
        int totalProfit = 0;

        if (totalSeats <= 60) {
            ticketPrice = 10;
            totalProfit = totalSeats * ticketPrice;
        } else {
            if (numOfRows % 2 == 0) {
                int frontHalfTicketPrice = (totalSeats / 2) * 10;
                int backHalfTicketPrice = (totalSeats / 2) * 8;
                ticketPrice = (frontHalfTicketPrice + backHalfTicketPrice) / totalSeats;
                totalProfit = totalSeats * ticketPrice;
            } else {
                int frontHalfRows = (numOfRows / 2);
                int backHalfRows = numOfRows - frontHalfRows;
                int frontHalfTicketPrice = (frontHalfRows * numOfSeats) * 10;
                int backHalfTicketPrice = (backHalfRows * numOfSeats) * 8;
                totalProfit = (frontHalfTicketPrice + backHalfTicketPrice);
            }
        }

        System.out.println("Total income:");
        System.out.println("$" + totalProfit);

        System.out.println("Cinema:");

        // fill the array
        for (int i = 0; i < seatingArrangement.length; i++) {
            for (int j = 0; j < seatingArrangement[i].length; j++) {
                seatingArrangement[i][j] = 'S';
            }
        }

        // top line of seating arrangement printout
        System.out.print("  "); // initial spaces for alignment
        for (int i = 1; i <= seatingArrangement[0].length; i++) {
            System.out.print(i + " ");
        }

        // rest of seating arrangement printout
        System.out.println(); //initial new line
        for (int i = 0; i < seatingArrangement.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seatingArrangement[i].length; j++) {
                System.out.print(seatingArrangement[i][j] + " ");
            }
            System.out.println();
        }

    }

}