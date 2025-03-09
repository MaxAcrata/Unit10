package ru.netologia.qamid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class RadioTest {


    // Параметризованный тест с использованием @CsvSource
    @ParameterizedTest
    @CsvSource({
            "0, 1",  // Если текущая станция 0, результат 1
            "5, 6",  // Если текущая станция 5, результат 6
            "9, 0",  // Если текущая станция 9, результат 0 (переход на первую станцию)
            "-1, 1", // Если текущая станция -1 (недопустимое значение), результат 1
            "10, 0"  // Если текущая станция 10 (недопустимое значение), результат 0
    })
    public void testNextStation(int currentStation, int expected) {
        Radio radio = new Radio();
        // Устанавливаем начальную станцию
        radio.setCurrentStation(currentStation);
        radio.nextStation();

        // Получаем фактическое значение текущей станции
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    // Параметризованный тест с использованием @CsvSource
    @ParameterizedTest
    @CsvSource({
            "0, 9",  // Если текущая станция 0, результат 9
            "5, 4",  // Если текущая станция 5, результат 4
            "9, 8",  // Если текущая станция 9, результат 8
            "-1, 9", // Если текущая станция -1 (недопустимое значение), результат 9
            "10, 8"  // Если текущая станция 10 (недопустимое значение), результат 8
    })
    public void testPrevStation(int currentStation, int expected) {
        Radio radio = new Radio();
        // Устанавливаем начальную станцию
        radio.setCurrentStation(currentStation);
        radio.prevStation();

        // Получаем фактическое значение текущей станции
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",  // Если установленная станция 2, результат 1
            "5,6",  // Если установленная станция 5, результат 6
            "9,0",  // Если текущая станция 9, результат (переход на первую станцию)
            "-1, 1", // Если установленная станция -1 (недопустимое значение), результат 1
            "10, 0"  // Если установленная станция 10 (недопустимое значение), результат 0
    })
    public void testNextStationWithValues(int setStation, int expected) {

        Radio radio = new Radio(setStation);

        // Запускаем функцию расчета следующей станции
        radio.nextStation();

        // Получаем фактическое значение текущей станции
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 9",  // Если текущая станция 0, результат 1
            "5, 4",  // Если текущая станция 5, результат 6
            "9, 8",  // Если текущая станция 9, результат 0 (переход на первую станцию)
            "-1, 9", // Если текущая станция -1 (недопустимое значение), результат 9
            "10, 8"  // Если текущая станция 10 (недопустимое значение), результат 8
    })
    public void testPrevStationWithValues(int setStation, int expected) {

        Radio radio = new Radio(setStation);

        // Запускаем функцию расчета предыдущей станции
        radio.prevStation();

        // Получаем фактическое значение текущей станции
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }
}