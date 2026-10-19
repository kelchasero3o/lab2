import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Массив фиксированного размера для хранения объектов
        Radio[] radios = new Radio[10];
        int count = 0;

        System.out.println("=== Система управления радиостанциями (Вариант 22) ===");

        while (true) {
            System.out.println("\n--- ГЛАВНОЕ МЕНЮ ---");
            System.out.println("1. Создать / добавить объект");
            System.out.println("2. Показать все объекты");
            System.out.println("3. Изменить объект по индексу");
            System.out.println("4. Удалить объект из массива");
            System.out.println("5. Вычислить заданный параметр (Макс. дальность)");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (count >= radios.length) {
                        System.out.println("Ошибка: Массив заполнен!");
                        break;
                    }

                    System.out.println("Выберите тип конструктора:");
                    System.out.println("1. По умолчанию");
                    System.out.println("2. С параметрами");
                    int constrType = scanner.nextInt();
                    scanner.nextLine();

                    if (constrType == 1) {
                        radios[count] = new Radio();
                    } else {
                        System.out.print("Введите бренд: ");
                        String brand = scanner.nextLine();
                        System.out.print("Введите макс. дальность (км): ");
                        double range = scanner.nextDouble();
                        radios[count] = new Radio(brand, range);
                    }

                    count++;
                    System.out.println("Объект успешно добавлен под индексом " + (count - 1));
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("--- Список радиостанций ---");
                        for (int i = 0; i < count; i++) {
                            System.out.println("[" + i + "] " + radios[i].toString());
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("Список пуст. Нечего изменять.");
                        break;
                    }
                    System.out.print("Введите индекс для изменения (0-" + (count - 1) + "): ");
                    int modIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (modIndex >= 0 && modIndex < count) {
                        System.out.print("Введите новый бренд: ");
                        radios[modIndex].setBrand(scanner.nextLine());
                        System.out.print("Введите новую макс. дальность: ");
                        radios[modIndex].setMaxRange(scanner.nextDouble());
                        System.out.println("Данные обновлены.");
                    } else {
                        System.out.println("Неверный индекс!");
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("Список пуст.");
                        break;
                    }
                    System.out.print("Введите индекс для удаления (0-" + (count - 1) + "): ");
                    int delIndex = scanner.nextInt();

                    if (delIndex >= 0 && delIndex < count) {
                        for (int i = delIndex; i < count - 1; i++) {
                            radios[i] = radios[i + 1];
                        }
                        radios[count - 1] = null;
                        count--;
                        System.out.println("Объект удален.");
                    } else {
                        System.out.println("Неверный индекс!");
                    }
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("Нет данных для вычисления.");
                        break;
                    }

                    double totalRange = 0;
                    double absoluteMaxRange = 0;
                    String bestRadio = "";

                    for (int i = 0; i < count; i++) {
                        totalRange += radios[i].getMaxRange();
                        if (radios[i].getMaxRange() > absoluteMaxRange) {
                            absoluteMaxRange = radios[i].getMaxRange();
                            bestRadio = radios[i].getBrand();
                        }
                    }

                    double averageRange = totalRange / count;

                    System.out.println("\n--- Аналитика ---");
                    System.out.printf("Средняя макс. дальность по всем радио: %.2f км\n", averageRange);
                    System.out.printf("Абсолютный максимум дальности: %.2f км (Бренд: %s)\n", absoluteMaxRange, bestRadio);
                    break;

                case 0:
                    System.out.println("Завершение работы программы.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
    }
}