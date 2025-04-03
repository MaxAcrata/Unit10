package ru.netologia.qamid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    private Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio(); // Используется для тестов с дефолтным конструктором
    }

    // Тесты для стандартного конструктора (станции 0-9)

    @ParameterizedTest
    @CsvSource({
            "0, 1",   // Стандартное переключение с 0 → 1
            "5, 6",   // Стандартное переключение с 5 → 6
            "9, 0",   // Циклическое переключение с 9 → 0
            "-1, 1",  // Некорректная станция (-1 → 0) → next → 1
            "10, 0"   // Некорректная станция (10 → 9) → next → 0
    })
    public void testNextStation(int currentStation, int expected) {
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 9",   // Циклическое переключение с 0 → 9
            "5, 4",   // Стандартное переключение с 5 → 4
            "9, 8",   // Стандартное переключение с 9 → 8
            "-1, 9",  // Некорректная станция (-1 → 0) → prev → 9
            "10, 8"   // Некорректная станция (10 → 9) → prev → 8
    })
    public void testPrevStation(int currentStation, int expected) {
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        Assertions.assertEquals(expected, radio.getCurrentStation());
    }

    // Тесты для конструктора с параметром

    @ParameterizedTest
    @CsvSource({
            "0, 1",   //  0 → next → 1
            "5, 6",   // 5 → next → 6
            "9, 0",   // 9 → next → 0
            "-1, 1",  // -1 → 0 → next → 1
            "10, 0"   // 10 → 9 → next → 0
    })
    public void testNextStationWithParam(int constructorStation, int expected) {
        Radio customRadio = new Radio(constructorStation);
        customRadio.nextStation();
        Assertions.assertEquals(expected, customRadio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 9",   //  0 → prev → 9
            "5, 4",   //  5 → prev → 4
            "9, 8",   // 9 → prev → 8
            "-1, 9",  // -1 → 0 → prev → 9
            "10, 8"   // 10 → 9 → prev → 8
    })
    public void testPrevStationWithParam(int constructorStation, int expected) {
        Radio customRadio = new Radio(constructorStation);
        customRadio.prevStation();
        Assertions.assertEquals(expected, customRadio.getCurrentStation());
    }

    // Тесты для громкости

    @ParameterizedTest
    @CsvSource({
            "0, 1",    // 0 → increase → 1
            "50, 51",   // 50 → increase → 51
            "100, 100", // 100 → increase → 100
            "-1, 1",    // -1 → set → 0 → increase → 1
            "101, 100"  // 101 → set → 100 → increase → 100
    })
    public void testIncreaseVolume(int currentVolume, int expected) {
        radio.setSoundVolume(currentVolume);
        radio.increaseVolume();
        Assertions.assertEquals(expected, radio.getSoundVolume());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",     // 0 → decrease → 0
            "50, 49",   // 50 → decrease → 49
            "100, 99"   // 100 → decrease → 99
    })
    public void testDecreaseVolume(int currentVolume, int expected) {
        radio.setSoundVolume(currentVolume);
        radio.decreaseVolume();
        Assertions.assertEquals(expected, radio.getSoundVolume());
    }

}