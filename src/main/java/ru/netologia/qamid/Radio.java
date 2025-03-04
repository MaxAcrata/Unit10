package ru.netologia.qamid;

public class Radio {

    // Поля класса
    private int currentStation; // Номер текущей радиостанции (0-9)
    private int soundVolume;    // Громкость звука (0-100)

    // Конструктор по умолчанию
    public Radio() {
        this.currentStation = 0; // По умолчанию установлена первая станция
        this.soundVolume = 0;    // По умолчанию громкость равна 0
    }

    // Метод для получения текущей радиостанции
    public int getCurrentStation() {

        return currentStation;
    }

    // Метод для установки номера радиостанции вручную
    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {  // Если значение находится в допустимом диапазоне устанавливаем его
            currentStation = station;
        } else if (station < 0) {
            currentStation = 0; // Если значение меньше 0, устанавливаем минимальное значение (0)
        } else {
            currentStation = 9; // Если значение больше 9, устанавливаем минимальное значение (9)
        }
    }


    // Метод для переключения на следующую радиостанцию
    public void nextStation() {
        if (currentStation == 9) {
            currentStation = 0; // Если достигнута последняя станция, переходим на первую
        } else {
            currentStation++; // Иначе переключаемся на следующую станцию
        }
    }

    // Метод для переключения на предыдущую радиостанцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = 9; // Если достигнута первая станция, переходим на последнюю
        } else {
            currentStation--; // Иначе переключаемся на предыдущую станцию
        }
    }


    // Метод для получения текущего уровня громкости
    public int getSoundVolume() {

        return soundVolume;
    }

    // Метод для установки уровня громкости вручную
    public void setSoundVolume(int volume) {
        if (volume >= 0 && volume <= 100) { // Если значение находится в допустимом диапазоне устанавливаем его
            soundVolume = volume;
        } else if (volume < 0) {
            soundVolume = 0; // Если значение меньше 0, устанавливаем минимальное значение (0)
        } else {
            soundVolume = 100; // Если значение больше 100, устанавливаем минимальное значение (100)
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

