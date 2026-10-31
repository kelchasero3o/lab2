import java.util.Scanner;

// Java 25+
void main() {
    Scanner scanner = new Scanner(System.in);

    Radio[] radios = new Radio[10];
    int count = 0;

    System.out.println("Система управления радиостанциями (Вариант 22)");

    while (true) {
        System.out.println("\n ГЛАВНОЕ МЕНЮ ");
        System.out.println("1. Создать / добавить объект");
        System.out.println("2. Показать все объекты");
        System.out.println("3. Изменить объект по индексу");
        System.out.println("4. Удалить объект из массива");
        System.out.println("5. Вычислить заданный параметр (Макс. дальность)");
        System.out.println("6. Усилить сигнал (Увеличить дальность)");
        System.out.println("0. Выход");

        int choice = readInt(scanner, "Выберите действие: ");

        switch (choice) {
            case 1:
                if (count >= radios.length) {
                    System.out.println("Ошибка: Массив заполнен!");
                    break;
                }

                System.out.println("Выберите тип конструктора:");
                System.out.println("1. По умолчанию");
                System.out.println("2. С параметрами");
                int constrType = readInt(scanner, "Ваш выбор: ");

                if (constrType == 1) {
                    radios[count] = new Radio();
                } else {
                    System.out.print("Введите бренд: ");
                    String brand = scanner.nextLine();
                    double range = readDouble(scanner, "Введите макс. дальность (км): ");
                    radios[count] = new Radio(brand, range);
                }

                count++;
                System.out.println("Объект успешно добавлен под индексом " + (count - 1));
                break;

            case 2:
                if (count == 0) {
                    System.out.println("Список пуст.");
                } else {
                    System.out.println("Список радиостанций");
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
                int modIndex = readInt(scanner, "Введите индекс для изменения (0-" + (count - 1) + "): ");

                if (modIndex >= 0 && modIndex < count) {
                    System.out.print("Введите новый бренд: ");
                    radios[modIndex].setBrand(scanner.nextLine());
                    double newRange = readDouble(scanner, "Введите новую макс. дальность: ");
                    radios[modIndex].setMaxRange(newRange);
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
                int delIndex = readInt(scanner, "Введите индекс для удаления (0-" + (count - 1) + "): ");

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

                System.out.println("\n Аналитика ");
                System.out.printf("Средняя макс. дальность по всем радио: %.2f км\n", averageRange);
                System.out.printf("Абсолютный максимум дальности: %.2f км (Бренд: %s)\n", absoluteMaxRange, bestRadio);
                break;

            case 6:
                if (count == 0) {
                    System.out.println("Список пуст.");
                    break;
                }
                int boostIndex = readInt(scanner, "Введите индекс радио для усиления (0-" + (count - 1) + "): ");

                if (boostIndex >= 0 && boostIndex < count) {
                    double amount = readDouble(scanner, "На сколько км увеличить дальность? ");

                    radios[boostIndex].boostRange(amount);

                    System.out.println("Дальность успешно увеличена!");
                } else {
                    System.out.println("Неверный индекс!");
                }
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

        // Безопасное чтение целого числа: при неверном вводе просит повторить.
        int readInt(Scanner scanner, String prompt) {
            while (true) {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                if (line.matches("-?\\d+")) {
                    return Integer.parseInt(line);
                }
                System.out.println("Ошибка ввода: нужно целое число. Попробуйте снова.");
            }
        }

        // Безопасное чтение вещественного числа (запятая и точка равнозначны).
        double readDouble(Scanner scanner, String prompt) {
            while (true) {
                System.out.print(prompt);
                String line = scanner.nextLine().trim().replace(',', '.');
                if (line.matches("-?\\d+(\\.\\d+)?")) {
                    return Double.parseDouble(line);
                }
                System.out.println("Ошибка ввода: нужно число. Попробуйте снова.");
            }
        }