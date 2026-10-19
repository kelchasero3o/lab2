public class Radio {
    // Свойство 1: Бренд радиоприемника
    private String brand;
    // Свойство 2: Максимальная дальность работы (в км)
    private double maxRange;

    // Конструктор по умолчанию
    public Radio() {
        this.brand = "Без названия";
        this.maxRange = 10.0;
    }

    // Конструктор с параметрами
    public Radio(String brand, double maxRange) {
        this.brand = brand;
        this.maxRange = maxRange;
    }

    // Метод 1: Увеличение дальности работы
    public void boostRange(double amount) {
        if (amount > 0) {
            this.maxRange += amount;
        }
    }

    // Метод 2: Проверка, является ли радио дальнобойным
    public boolean isLongRange() {
        return this.maxRange > 50.0;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    // Вывод информации об объекте
    @Override
    public String toString() {
        return String.format("Радио [Бренд: %-10s | Макс. дальность: %6.1f км]", brand, maxRange);
    }
}