public class Radio {
    private String brand;
    private double maxRange;

    public Radio() {
        this.brand = "Без названия";
        this.maxRange = 10.0;
    }

    public Radio(String brand, double maxRange) {
        this.brand = brand;
        this.maxRange = maxRange;
    }

    // МЕТОД 1: Теперь он используется в меню (пункт 6)
    public void boostRange(double amount) {
        if (amount > 0) {
            this.maxRange += amount;
        }
    }

    // МЕТОД 2: Теперь он используется внутри toString() для вывода статуса
    public boolean isLongRange() {
        return this.maxRange > 50.0;
    }

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

    @Override
    public String toString() {
        // ВЫЗОВ МЕТОДА 2: Проверяем, дальнобойное ли радио, и добавляем метку
        String status = isLongRange() ? " [Дальнобойное]" : "";
        return String.format("Радио [Бренд: %-10s | Макс. дальность: %6.1f км]%s", brand, maxRange, status);
    }
}