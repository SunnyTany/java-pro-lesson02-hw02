package app;
import java.util.Scanner;

public class Converter {
    private static final double MILES_TO_KM = 1.60934;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Конвертер дистанції ---");
        System.out.println("1. Милі -> Кілометри");
        System.out.println("2. Кілометри -> Милі");
        System.out.print("Оберіть опцію (1 або 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Введіть відстань у милях: ");
            double miles = scanner.nextDouble();
            double km = miles * MILES_TO_KM;
            System.out.printf("%.2f миль = %.2f км%n", miles, km);
        } else if (choice == 2) {
            System.out.print("Введіть відстань у кілометрах: ");
            double km = scanner.nextDouble();
            double miles = km / MILES_TO_KM;
            System.out.printf("%.2f км = %.2f миль%n", km, miles);
        } else {
            System.out.println("Помилка: невірна опція.");
        }

        scanner.close();
    }
}
