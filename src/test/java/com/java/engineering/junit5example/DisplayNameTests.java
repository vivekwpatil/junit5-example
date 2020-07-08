package com.java.engineering.junit5example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Execution(ExecutionMode.CONCURRENT)
public class DisplayNameTests {

    @Test
    @DisplayName("Case covering true condition")
    void test1() {
        Assertions.assertTrue(true, "");
    }

    @Test
    @DisplayName("Case covering false condition")
    void test2() {
        Assertions.assertFalse(false, "");
    }

    @BeforeAll
    static void setup() {
        System.out
            .println("@BeforeAll - Execute once before all test methods in this class.");
    }

    @BeforeEach
    void init() {
        System.out
            .println("@BeforeEach - Executed before each test method in this class.");
    }

    @DisplayName("First Test")
    @Test
    void firstTest() {
        Assertions.assertEquals(1, 1);
    }



    @AfterEach
    void tearDown() {
        System.out
            .println("@AfterEach - This method is called after each test method.");
    }

    @AfterAll
    static void done() {
        System.out
            .println("@AfterAll - This method is called after all test methods.");
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
            () -> {
                throw new IllegalArgumentException("a message");
            });
        assertEquals("a message", exception.getMessage());
    }
}
