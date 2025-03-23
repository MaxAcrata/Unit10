package ru.netologia.qamid;

public class Radio {

   // Поля класса
    private int minStation = 0; // Минимальный номер радиостанции
    private int maxStation = 9; // Максимальный номер радиостанции
    private int currentStation = minStation; // Текущая радиостанция (инициализирована значением minStation)
    private int soundVolume = 0; // Громкость звука (инициализирована значением 0)

    // Конструктор по умолчанию
    public Radio() {
        // Нет необходимости инициализировать currentStation и soundVolume, так как они уже инициализированы при объявлении
    }

    // Метод для получения текущей радиостанции
    public int getCurrentStation() {
        return currentStation;
    }

    // Метод для установки номера радиостанции вручную
    public void setCurrentStation(int station) {
        if (station >= minStation && station <= maxStation) {  // Если значение находится в допустимом диапазоне, устанавливаем его
            currentStation = station;
        } else if (station < minStation) {
            currentStation = minStation; // Если значение меньше минимума, устанавливаем минимальное значение
        } else {
            currentStation = maxStation; // Если значение больше максимума, устанавливаем максимальное значение
        }
    }

    // Метод для переключения на следующую радиостанцию
    public void nextStation() {
        if (currentStation < maxStation) {
            currentStation++; // Увеличиваем станцию на 1, если она меньше максимума
        } else {
            currentStation = minStation; // Если текущая станция равна максимуму, переходим на минимум
        }
    }

    // Метод для переключения на предыдущую радиостанцию
    public void prevStation() {
        if (currentStation > minStation) {
            currentStation--; // Уменьшаем станцию на 1, если она больше минимума
        } else {
            currentStation = maxStation; // Если текущая станция равна минимуму, переходим на максимум
        }
    }

    // Метод для получения текущего уровня громкости
    public int getSoundVolume() {
        return soundVolume;
    }

    // Метод для установки уровня громкости вручную
    public void setSoundVolume(int volume) {
        if (volume >= 0 && volume <= 100) { // Если значение находится в допустимом диапазоне, устанавливаем его
            soundVolume = volume;
        } else if (volume < 0) {
            soundVolume = 0; // Если значение меньше 0, устанавливаем минимальное значение
        } else {
            soundVolume = 100; // Если значение больше 100, устанавливаем максимальное значение
        }
    }

    // Метод для увеличения громкости
    public void increaseVolume() {
        if (soundVolume < 100) { // Увеличиваем громкость, если она меньше максимального значения
            soundVolume++;
        }
    }

    // Метод для уменьшения громкости
    public void decreaseVolume() {
        if (soundVolume > 0) { // Уменьшаем громкость, если она больше минимального значения
            soundVolume--;
        }
    }

}


