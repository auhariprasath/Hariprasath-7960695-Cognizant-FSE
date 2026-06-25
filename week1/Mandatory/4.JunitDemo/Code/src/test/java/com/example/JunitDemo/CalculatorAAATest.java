package com.example.JunitDemo;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorAAATest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println("Setup Executed");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Teardown Executed");
        calculator = null;
    }

    @Test
    void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }
}