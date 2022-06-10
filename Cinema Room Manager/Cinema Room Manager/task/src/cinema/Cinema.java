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
        char[][] seatingArrangement = new char[numOfRows][numOfSeats];

        // ***** INITIAL EMPTY SEATING PRINTOUT *****

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

        // print total income if all seats are sold out
//        System.out.println("Total income:");
//        System.out.println("$" + totalProfit);

        // prompt user for row and seat numbers

        System.out.println("Enter a row number:");

        int userRowNumber = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");

        int userSeatNumber = scanner.nextInt();

        // ticket price for this selection

        int individualTicketPrice = 10;
        int frontHalfRows = 0;
        int backHalfRows = 0;

        if (numOfRows % 2 == 0) {
            frontHalfRows = (numOfRows / 2);
            backHalfRows = (numOfRows / 2);
        } else {
            frontHalfRows = (numOfRows / 2);
            backHalfRows = numOfRows - frontHalfRows;
        }

        if (userRowNumber <= 4) {
            individualTicketPrice = 10;
        } else if (userRowNumber >= backHalfRows) {
            individualTicketPrice = 8;
        }

        System.out.println("Ticket price: $" + individualTicketPrice);

        // ***** PRINTOUT AFTER USER SEAT SELECTION *****

        System.out.println("Cinema:");

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
                if (userRowNumber - 1 == i && userSeatNumber - 1 == j) {
                    seatingArrangement[i][j] = 'B';
                }
                System.out.print(seatingArrangement[i][j] + " ");
            }
            System.out.println();
        }

    }

}