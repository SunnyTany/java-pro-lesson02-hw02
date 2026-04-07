package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Converter {
    private static final double MILES_TO_KM = 1.60934;
    private static final int HISTORY_LIMIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Distance Converter Menu ---");
            System.out.println("1. Miles to Kilometers");
            System.out.println("2. Kilometers to Miles");
            System.out.println("3. View History");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid number.");
                scanner.next(); // Clear buffer
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting the application. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter miles: ");
                    double miles = scanner.nextDouble();
                    double kmResult = miles * MILES_TO_KM;
                    saveToHistory(history, String.format("%.2f mi = %.2f km", miles, kmResult));
                    System.out.printf("Result: %.2f km%n", kmResult);
                    break;

                case 2:
                    System.out.print("Enter kilometers: ");
                    double km = scanner.nextDouble();
                    double milesResult = km / MILES_TO_KM;
                    saveToHistory(history, String.format("%.2f km = %.2f mi", km, milesResult));
                    System.out.printf("Result: %.2f miles%n", milesResult);
                    break;

                case 3:
                    printHistory(history);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void saveToHistory(List<String> history, String entry) {
        // Prevent OutOfMemory by limiting history size
        if (history.size() >= HISTORY_LIMIT) {
            history.remove(0); // Remove the oldest entry
        }
        history.add(entry);
    }

    private static void printHistory(List<String> history) {
        System.out.println("\n--- Operation History ---");
        if (history.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }
}
