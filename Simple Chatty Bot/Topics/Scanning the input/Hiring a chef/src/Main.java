import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String firstName = scanner.nextLine();
        String yearsOfExperience = scanner.nextLine();
        String cuisinePreference = scanner.nextLine();
        System.out.print("The form for " + firstName + " is completed.");
        System.out.print(" We will contact you if we need a chef who cooks ");
        System.out.print(cuisinePreference + " dishes and has " + yearsOfExperience + " years of experience.");

    }
}