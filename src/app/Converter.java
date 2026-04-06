package app;
import java.util.Scanner;

public class Converter {
    private static final double MILES_TO_KM = 1.60934;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Конвертер дистанції ---");
            System.out.println("1. Милі -> Кілометри");
            System.out.println("2. Кілометри -> Милі");
            System.out.println("0. Вихід");
            System.out.print("Оберіть опцію: ");

            // Перевірка, чи ввів користувач саме число
            if (!scanner.hasNextInt()) {
                System.out.println("Помилка: введіть число (1, 2 або 0).");
                scanner.next(); // Очищення буфера від некоректного введення
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Завершення роботи. Бувай!");
                break; // Вихід з циклу
            }

            if (choice == 1) {
                System.out.print("Введіть милі: ");
                double miles = scanner.nextDouble();
                System.out.printf("Результат: %.2f км%n", miles * MILES_TO_KM);
            } else if (choice == 2) {
                System.out.print("Введіть кілометри: ");
                double km = scanner.nextDouble();
                System.out.printf("Результат: %.2f миль%n", km / MILES_TO_KM);
            } else {
                System.out.println("Невірна опція. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }
}
