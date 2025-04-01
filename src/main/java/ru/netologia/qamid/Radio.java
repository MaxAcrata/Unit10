package ru.netologia.qamid;

public class Radio {
    // Границы диапазона станций
    private final int minStation = 0;    // Минимальный номер станции
    private final int maxStation = 9;    // Максимальный номер станции
    private int currentStation;          // Текущая выбранная станция

    /**
     * Конструктор по умолчанию.
     * Инициализирует радио с минимальной станцией (0).
     */
    public Radio() {
        this.currentStation = minStation;
    }

    /**
     * Конструктор с установкой начальной станции.
     * @param currentStation номер станции для инициализации
     */
    public Radio(int currentStation) {
        setCurrentStation(currentStation);
    }

    /**
     * Получить текущую станцию
     * @return номер текущей станции
     */
    public int getCurrentStation() {
        return currentStation;
    }

    /**
     * Установить текущую станцию с проверкой границ
     * @param station номер станции для установки
     */
    public void setCurrentStation(int station) {
        // В пределах диапазона - устанавливаем как есть
        if (station < minStation) {
            this.currentStation = minStation;  // Если меньше минимума - ставим минимум
        } else this.currentStation = Math.min(station, maxStation);  // Если больше максимума - ставим максимум
    }

    /**
     * Переключиться на следующую станцию.
     * При достижении максимума переходит на минимальную станцию.
     */
    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = minStation;  // Циклическое переключение с max на min
        } else {
            currentStation++;             // Обычное увеличение на 1
        }
    }

    /**
     * Переключиться на предыдущую станцию.
     * При достижении минимума переходит на максимальную станцию.
     */
    public void prevStation() {
        if (currentStation == minStation) {
            currentStation = maxStation;  // Циклическое переключение с min на max
        } else {
            currentStation--;            // Обычное уменьшение на 1
        }
    }
}