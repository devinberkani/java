package cinema;

import java.util.Scanner;

public class Cinema {

    public static void printMenu(char[][] seatingArrangement, int numOfRows, int numOfSeats) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
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

                case 3:
                    showStatistics(seatingArrangement, numOfRows, numOfSeats);
                    break;
            }
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");

            userEntry = scanner.nextInt();
        }
    }

    public static void showStatistics(char[][] seatingArrangement, int numOfRows, int numOfSeats) {

        int ticketsPurchased = 0; // show number of purchased tickets
        int currentIncome = 0; // show current income
        int totalIncome = 0; //show total potential income
        int ticketPrice;
        for (int i = 0; i < seatingArrangement.length; i++) {
            for (int j = 0; j < seatingArrangement[i].length; j++) {
                ticketPrice = getTicketPrice(numOfRows, numOfSeats, i + 1);
                totalIncome += ticketPrice;
                if (seatingArrangement[i][j] == 'B') {
                    ticketsPurchased++;
                    currentIncome += ticketPrice;
                }
            }
        }

        // show number of purchased tickets represented as a percentage logic
        float totalSeatsFloat = numOfRows * numOfSeats; // get total seats
        float ticketsPurchasedFloat = ticketsPurchased;
        float purchasedPercentage = 100 * (ticketsPurchasedFloat / totalSeatsFloat);


        System.out.println("Number of purchased tickets: " + ticketsPurchased);
        System.out.print("Percentage: ");
        System.out.printf("%.2f%%", purchasedPercentage);
        System.out.println();
        System.out.println("Current income: " + "$" + currentIncome); // show current income
        System.out.println("Total income: " + "$" + totalIncome);
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

    public static int getTicketPrice(int numOfRows, int numOfSeats, int userRowNumber) {
        int totalSeats = numOfRows * numOfSeats;
        int ticketPrice = 0;
        int frontHalfRows = 0;

        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else {
            frontHalfRows = (numOfRows / 2);
            if (userRowNumber <= frontHalfRows) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        return ticketPrice;
    }

    public static boolean isTicketPurchased(char[][] seatingArrangement, int userRowNumber, int userSeatNumber) {
        return seatingArrangement[userRowNumber - 1][userSeatNumber - 1] == 'B';
    }

    public static boolean isInputWrong(char[][] seatingArrangement, int userRowNumber, int userSeatNumber) {
        userRowNumber -= 1;
        userSeatNumber -= 1;
        return (userRowNumber < 0 || userRowNumber > seatingArrangement.length - 1) || (userSeatNumber < 0 || userSeatNumber > seatingArrangement.length - 1);
    }

    public static void buyTicket(char[][] seatingArrangement, int numOfRows, int numOfSeats) {
        Scanner scanner = new Scanner(System.in);

        boolean noErrors = false;
        int userRowNumber = 0;
        int userSeatNumber = 0;

        while(!noErrors) {
            // prompt user for row and seat numbers

            System.out.println("Enter a row number:");

            userRowNumber = scanner.nextInt();

            System.out.println("Enter a seat number in that row:");

            userSeatNumber = scanner.nextInt();

            // check for errors

            //check for wrong input
            boolean isInputWrong = isInputWrong(seatingArrangement, userRowNumber, userSeatNumber);

            if (isInputWrong) {
                System.out.println("Wrong input!");
            } else {
                // check if this seat is taken
                boolean isTicketPurchased = isTicketPurchased(seatingArrangement, userRowNumber, userSeatNumber);
                if (isTicketPurchased) {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    noErrors = true;
                }
            }
        }

        // ticket price for this selection

        int ticketPrice = getTicketPrice(numOfRows, numOfSeats, userRowNumber);

        System.out.println("Ticket price: $" + ticketPrice);

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