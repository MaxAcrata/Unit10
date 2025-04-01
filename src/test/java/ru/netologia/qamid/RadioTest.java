package ru.netologia.qamid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    private Radio radio;

    // Метод будет выполняться перед каждым тестом
    @BeforeEach
    public void setUp() {
        radio = new Radio(); // Создаем новый объект Radio перед каждым тестом
    }

    // Параметризованный тест с использованием @CsvSource
    @ParameterizedTest
    @CsvSource({"0, 1", // Если текущая станция 0, то nextStation 1
            "5, 6", // Если текущая станция 5, то nextStation 6
            "9, 0",// Если текущая станция 9, то nextStation 0
            "-1, 1", // Если текущая станция -1, то nextStation 1
            "10, 0"  // Если текущая станция 10, то nextStation 0
    })
    public void testNextStation(int currentStation, int expected) {
        // Устанавливаем начальную станцию
        radio.setCurrentStation(currentStation);

        // Вызываем метод nextStation
        radio.nextStation();

        // Получаем фактическое значение текущей станции
        int actual = radio.getCurrentStation();

        // Сравниваем ожидаемое и фактическое значение
        Assertions.assertEquals(expected, actual);
    }

    // Параметризованный тест с использованием @CsvSource
    @ParameterizedTest
    @CsvSource({"0, 9", // Если текущая станция 0, то prevStation 9
            "5, 4", // Если текущая станция 5, то prevStation 4
            "9, 8"  // Если текущая станция 9, тo prevStation 8
    })
    public void testPrevStation(int currentStation, int expected) {
        // Устанавливаем начальную станцию
        radio.setCurrentStation(currentStation);

        // Вызываем метод nextStation
        radio.prevStation();

        // Получаем фактическое значение текущей станции
        int actual = radio.getCurrentStation();

        // Сравниваем ожидаемое и фактическое значение
        Assertions.assertEquals(expected, actual);
    }

    // Параметризованный тест с использованием @CsvSource
    @ParameterizedTest
    @CsvSource({"0, 1", // Если громкость 0, то после увеличения должна быть 1
            "50, 51", // Если громкость 50, то после увеличения должна быть 51
            "100, 100", // Если громкость 100, то она не должна увеличиваться
            "-1, 1", // Если громкость 50, то после увеличения должна быть 51
            "101, 100", // Если громкость 50, то после увеличения должна быть 51
    })
    public void testIncreaseVolume(int currentVolume, int expected) {
        // Устанавливаем начальную громкость
        radio.setSoundVolume(currentVolume);

        // Вызываем метод increaseVolume
        radio.increaseVolume();

        // Получаем фактическое значение текущей станции
        int actual = radio.getSoundVolume();

        // Сравниваем ожидаемое и фактическое значение
        Assertions.assertEquals(expected, actual);
    }

    // Параметризованный тест с использованием @CsvSource
    @ParameterizedTest
    @CsvSource({"0, 0", // Если громкость 0, то она не должна уменьшаться
            "50, 49", // Если громкость 50, то после уменьшения должна быть 49
            "100, 99" // Если громкость 100, то после уменьшения должна быть 99
    })
    public void testDecreaseVolume(int currentVolume, int expected) {
        // Устанавливаем начальную громкость
        radio.setSoundVolume(currentVolume);

        // Вызываем метод increaseVolume
        radio.decreaseVolume();

        // Получаем фактическое значение текущей станции
        int actual = radio.getSoundVolume();

        // Сравниваем ожидаемое и фактическое значение
        Assertions.assertEquals(expected, actual);
    }

}