package com.java.engineering.junit5example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class DisabledTests {


    @Test
    @Disabled("Not implemented yet.")
    void disabledTest() {
    }

    @Test
    void sampleTestToBeExecuted() {

    }

    @Test
    @EnabledOnOs({ OS.LINUX, OS.MAC })
    void onLinuxOrMac() {
        // ...
    }

    @Test
    @EnabledOnOs({ OS.WINDOWS, OS.MAC })
    void onWindows() {
        // ...
    }

    @Test
    @EnabledOnJre(JRE.JAVA_10)
    void onJava10() {
        // ...
    }
}
