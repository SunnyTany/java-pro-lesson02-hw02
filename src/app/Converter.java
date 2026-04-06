package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Converter {
    private static final double MILES_TO_KM = 1.60934;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>(); // Список для збереження історії

        while (true) {
            System.out.println("\n--- Меню конвертера ---");
            System.out.println("1. Милі -> Кілометри");
            System.out.println("2. Кілометри -> Милі");
            System.out.println("3. Переглянути історію");
            System.out.println("0. Вихід");
            System.out.print("Оберіть опцію: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Помилка: введіть число.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) break;

            if (choice == 1) {
                System.out.print("Введіть милі: ");
                double miles = scanner.nextDouble();
                double km = miles * MILES_TO_KM;
                String res = String.format("%.2f mi = %.2f km", miles, km);
                System.out.println("Результат: " + res);
                history.add(res); // Додаємо в історію
            } else if (choice == 2) {
                System.out.print("Введіть кілометри: ");
                double km = scanner.nextDouble();
                double miles = km / MILES_TO_KM;
                String res = String.format("%.2f km = %.2f mi", km, miles);
                System.out.println("Результат: " + res);
                history.add(res); // Додаємо в історію
            } else if (choice == 3) {
                System.out.println("\n--- Історія операцій ---");
                if (history.isEmpty()) {
                    System.out.println("Історія порожня.");
                } else {
                    for (int i = 0; i < history.size(); i++) {
                        System.out.println((i + 1) + ". " + history.get(i));
                    }
                }
            } else {
                System.out.println("Невірна опція.");
            }
        }
        System.out.println("Програму завершено.");
        scanner.close();
    }
}
