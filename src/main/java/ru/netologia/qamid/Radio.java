package ru.netologia.qamid;

public class Radio {
    // Границы диапазона станций
    private final int minStation = 0;    // Минимальный номер станции
    private final int maxStation = 9;    // Максимальный номер станции
    private int currentStation;          // Текущая выбранная станция
    private final int minSoundVolume = 0;      // Минимальная Громкость звука
    private final int maxSoundVolume = 100;    // Максимальная Громкость звука
    private int soundVolume;            // Текущая Громкость звука

    /**
     * Конструктор по умолчанию. Инициализирует радио с минимальной станцией (0).
     */
    public Radio() {

        this.currentStation = minStation;
    }

    /**
     * Конструктор с установкой начальной станции.
     *
     * @param currentStation Номер станции для инициализации.
     */
    public Radio(int currentStation) {

        setCurrentStation(currentStation); // Используем сеттер для валидации
    }

    /**
     * Получить текущую станцию.
     *
     * @return Номер текущей станции.
     */
    public int getCurrentStation() {

        return currentStation;
    }

    /**
     * Установить текущую станцию с проверкой границ.
     *
     * @param station Номер станции для установки.
     */
    public void setCurrentStation(int station) {
        if (station < minStation) {
            this.currentStation = minStation;
        } else if (station > maxStation) {
            this.currentStation = maxStation;
        } else {
            this.currentStation = station;
        }
    }

    /**
     * Переключиться на следующую станцию.
     * При достижении максимума переходит на минимальную станцию.
     */
    public void nextStation() {
        if (currentStation == maxStation) {
            currentStation = minStation;
        } else {
            currentStation++;
        }
    }

    /**
     * Переключиться на предыдущую станцию.
     * При достижении минимума переходит на максимальную станцию.
     */
    public void prevStation() {
        if (currentStation == minStation) {
            currentStation = maxStation;
        } else {
            currentStation--;
        }
    }

    /**
     * Получить текущий уровень громкости.
     *
     * @return Текущая громкость (0-100).
     */
    public int getSoundVolume() {
        return soundVolume;
    }

    /**
     * Установить уровень громкости.
     *
     * @param volume Значение громкости (автоматически ограничивается диапазоном 0-100).
     */
    public void setSoundVolume(int volume) {
        if (volume < minSoundVolume) {
            soundVolume = minSoundVolume;
        } else soundVolume = Math.min(volume, maxSoundVolume);
    }

    /**
     * Увеличить громкость на 1. Максимальное значение — 100.
     */
    public void increaseVolume() {
        if (soundVolume < maxSoundVolume) {
            soundVolume++;
        }
    }

    /**
     * Уменьшить громкость на 1. Минимальное значение — 0.
     */
    public void decreaseVolume() {
        if (soundVolume > minSoundVolume) {
            soundVolume--;
        }
    }
}