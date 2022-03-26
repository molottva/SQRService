package ru.netology.sqr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SQRServiceTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Max amount, 100, 9801, 90",
            "Min amount, 2501, 2600, 0",
            "Reverse under/upper limits, 9801, 100, 0",
            "'Min interval, amount 1', 6400, 6400, 1",
            "'Min interval, amount 0', 6401, 6401, 0",
            "Interval under 99, 1, 99, 0",
            "Interval upper 9802, 9802, 99999, 0",
            "Critical path, 200, 300, 3",
            })
    void shouldCalculate(String testName, int underLimit, int upperLimit, int expected){
        SQRService service = new SQRService();

        int actual = service.calculate(underLimit, upperLimit);

        assertEquals(expected, actual);
    }
}