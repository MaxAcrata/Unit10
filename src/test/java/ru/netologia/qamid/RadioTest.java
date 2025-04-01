package ru.netologia.qamid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    //@ TODO Тесты для стандартного конструктора (станции 0-9)

    /**
     * Тестирование переключения на следующую станцию.
     */
    @ParameterizedTest
    @CsvSource({
            "0, 1",   // Стандартное переключение с 0 на 1
            "5, 6",    // Стандартное переключение с 5 на 6
            "9, 0",    // Циклическое переключение с 9 на 0
            "-1, 1",   // Некорректная станция (-1 → 0) → next → 1
            "10, 0"    // Некорректная станция (10 → 9) → next → 0
    })
    public void testNextStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    /**
     * Тестирование переключения на предыдущую станцию.
     */
    @ParameterizedTest
    @CsvSource({
            "0, 9",   // Циклическое переключение с 0 на 9
            "5, 4",    // Стандартное переключение с 5 на 4
            "9, 8",    // Стандартное переключение с 9 на 8
            "-1, 9",   // Некорректная станция (-1 → 0) → prev → 9
            "10, 8"    // Некорректная станция (10 → 9) → prev → 8
    })
    public void testPrevStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    //@ TODO Тесты для конструктора с установкой начальной станции

    @ParameterizedTest
    @CsvSource({
            "0, 1",   // Стандартное переключение вперед
            "5, 6",    // Среднее значение
            "9, 0",    // Циклическое переключение
            "-1, 1",   // Некорректное значение (ниже минимума)
            "10, 0"    // Некорректное значение (выше максимума)
    })
    public void testNextStationWithParam(int station, int expected) {
        Radio radio = new Radio(station);
        radio.nextStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 9",   // Циклическое переключение назад
            "5, 4",    // Среднее значение
            "9, 8",    // Стандартное переключение назад
            "-1, 9",   // Некорректное значение (ниже минимума)
            "10, 8"    // Некорректное значение (выше максимума)
    })
    public void testPrevStationWithParam(int station, int expected) {
        Radio radio = new Radio(station);
        radio.prevStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }


}