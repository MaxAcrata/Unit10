package ru.netologia.qamid;

public class Radio {

    // Поля класса
    private int minStation = 0; // Минимальный номер радиостанции
    private int maxStation = 9; // Максимальный номер радиостанции
    private int currentStation = minStation; // Текущая радиостанция


    // Конструктор по умолчанию
    public Radio() {

    }

    // Конструктор установкой количества
    public Radio(int setAmountOfStation) {
        setCurrentStation(setAmountOfStation);

    }

    // Метод для получения текущей радиостанции
    public int getCurrentStation() {
        return currentStation;
    }

    // Метод для установки текущей радиостанции
    public void setCurrentStation(int station) {
        if (station >= minStation && station <= maxStation) {
            currentStation = station;
        } else if (station < minStation) {
            currentStation = minStation; // Если меньше минимума, устанавливаем минимум
        } else {
            currentStation = maxStation; // Если больше максимума, устанавливаем максимум
        }
    }

    // Метод для переключения на следующую радиостанцию
    public void nextStation() {
        if (currentStation < maxStation) {
            // Если текущая станция не является последней, увеличиваем её на 1
            currentStation++;
        } else {
            // Если текущая станция последняя, переключаемся на первую
            currentStation = minStation;
        }
    }
    // Метод для переключения на следующую радиостанцию
    public void prevStation() {
        if (currentStation > minStation) {
            // Если текущая станция не является первой, уменьшаем её на 1
            currentStation--;
        } else {
            // Если текущая станция первая, переключаемся на последнюю
            currentStation = maxStation;
        }
    }

}


