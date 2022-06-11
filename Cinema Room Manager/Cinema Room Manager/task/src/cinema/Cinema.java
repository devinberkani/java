package cinema;

import java.util.Scanner;

public class Cinema {

    public static void printMenu(char[][] seatingArrangement, int numOfRows, int numOfSeats) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit");

        int userEntry = scanner.nextInt();

        while(userEntry != 0) {

            switch (userEntry) {
                case 1:
                    showSeats(seatingArrangement);
                    break;

                case 2:
                    buyTicket(seatingArrangement, numOfRows, numOfSeats);
                    break;
            }
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");

            userEntry = scanner.nextInt();
        }
    }

    public static void updateSeats(char[][] seatingArrangement, int userRowNumber, int userSeatNumber) {

        // fill the array
        for (int i = 0; i < seatingArrangement.length; i++) {
            for (int j = 0; j < seatingArrangement[i].length; j++) {
                if (userRowNumber - 1 == i && userSeatNumber - 1 == j) {
                    seatingArrangement[i][j] = 'B';
                }
            }
        }
    }

    public static void showSeats(char[][] seatingArrangement) {

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
                System.out.print(seatingArrangement[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void buyTicket(char[][] seatingArrangement, int numOfRows, int numOfSeats) {
        Scanner scanner = new Scanner(System.in);

        // prompt user for row and seat numbers

        System.out.println("Enter a row number:");

        int userRowNumber = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");

        int userSeatNumber = scanner.nextInt();

        // ticket price for this selection

        int totalSeats = numOfRows * numOfSeats;
        int individualTicketPrice = 0;
        int frontHalfRows = 0;

        if (totalSeats <= 60) {
            individualTicketPrice = 10;
        } else {
            frontHalfRows = (numOfRows / 2);
            if (userRowNumber <= frontHalfRows) {
                individualTicketPrice = 10;
            } else {
                individualTicketPrice = 8;
            }
        }

        System.out.println("Ticket price: $" + individualTicketPrice);

        // update array with new seating

        updateSeats(seatingArrangement, userRowNumber, userSeatNumber);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt user for row and seat numbers
        System.out.println("Enter the number of rows:");

        int numOfRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");

        int numOfSeats = scanner.nextInt();

        // array for initial seating arrangement
        char[][] seatingArrangement = new char[numOfRows][numOfSeats];

        // fill the array
        for (int i = 0; i < seatingArrangement.length; i++) {
            for (int j = 0; j < seatingArrangement[i].length; j++) {
                seatingArrangement[i][j] = 'S';
            }
        }

        printMenu(seatingArrangement, numOfRows, numOfSeats);

    }

}