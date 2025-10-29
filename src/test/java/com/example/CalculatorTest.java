package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * JUnit 5 Jupiter unit test of the Calculator class.
 */
@DisplayName("Testing Calculator class")
public class CalculatorTest {

    @BeforeAll
    static void initAll() {
        System.out.println("Before all test methods");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all test methods");
    }

    @BeforeEach
    void init() {
        System.out.println("Before each test method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test method");
    }

    @Test
    @DisplayName("Testing add method")
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @DisplayName("Paramaterized testing add method")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "0,    1,   1",
        "1,    2,   3",
        "49,  51, 100",
        "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
            () -> first + " + " + second + " should equal " + expectedResult);
    }
}