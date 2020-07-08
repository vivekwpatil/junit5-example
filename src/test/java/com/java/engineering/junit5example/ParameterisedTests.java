package com.java.engineering.junit5example;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterisedTests {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void withValueSource(String word) {
        assertNotNull(word);
    }

    @ParameterizedTest
    @MethodSource("createWords")
    void withMethodSource(String word) { }

    private static Stream<String> createWords() {
        return Stream.of("Hello", "Junit");
    }


    @ParameterizedTest
    @EnumSource(
        value = TimeUnit.class,
        names = {"NANOSECONDS", "MICROSECONDS"})
    void withSomeEnumValues(TimeUnit unit) {
        // executed once for TimeUnit.NANOSECONDS
        // and once for TimeUnit.MICROSECONDS
    }


    @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvFileSource(resources = "/test-data.csv")
    void sum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertTrue(Strings.isBlank(input));
    }

}
