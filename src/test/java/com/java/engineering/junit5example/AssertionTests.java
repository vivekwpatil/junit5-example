package com.java.engineering.junit5example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssertionTests {

    @Test
    void ungroupedAssertions() {
        assertTrue(false, "this test fails here");
        assertTrue(true, "so we never perform this assertion");
    }

    @Test
    void groupedAssertions() {
        assertAll(
            "all of these assertions",
            () -> assertTrue(true, "condition 1"),
            () -> assertTrue(false, "Condition 2 "),
            () -> assertTrue(false, "Condition 3")
        );

    }


}
