public class Radio {
    // Приватные поля — инкапсуляция (доступ только через геттеры/сеттеры)
    private String brand;      // Бренд радиостанции
    private double maxRange;   // Максимальная дальность сигнала, км

    // Конструктор по умолчанию — создаёт «пустую» радиостанцию
    public Radio() {
        this.brand = "Без названия";
        this.maxRange = 10.0;
    }

    // Параметризованный конструктор — задаёт бренд и дальность
    public Radio(String brand, double maxRange) {
        this.brand = brand;
        this.maxRange = maxRange;
    }

    // МЕТОД 1: Теперь он используется в меню (пункт 6)
    // Увеличивает дальность на amount (только если значение положительное — защита от уменьшения)
    public void boostRange(double amount) {
        if (amount > 0) {
            this.maxRange += amount;
        }
    }

    // МЕТОД 2: Теперь он используется внутри toString() для вывода статуса
    // Возвращает true, если дальность превышает 50 км (порог «дальнобойности»)
    public boolean isLongRange() {
        return this.maxRange > 50.0;
    }

    // Геттер для бренда — используется в пункте 5 меню для вывода лучшего радио
    public String getBrand() {
        return brand;
    }

    // Сеттер для бренда — используется в пункте 3 меню при редактировании
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Геттер для дальности — используется в аналитике (пункт 5)
    public double getMaxRange() {
        return maxRange;
    }

    // Сеттер для дальности — используется в пункте 3 меню при редактировании
    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    // Переопределение toString(): форматированный вывод объекта
    @Override
    public String toString() {
        // ВЫЗОВ МЕТОДА 2: Проверяем, дальнобойное ли радио, и добавляем метку
        String status = isLongRange() ? " [Дальнобойное]" : "";
        // %-10s — выравнивание строки по левому краю до 10 символов
        // %6.1f — число с 1 знаком после точки, ширина 6 символов
        return String.format("Радио [Бренд: %-10s | Макс. дальность: %6.1f км]%s", brand, maxRange, status);
    }
}
