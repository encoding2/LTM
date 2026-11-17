package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class DayNineTest {

    @Test
    void testMediConnectApplicationConfiguration() {

        assertNotNull(MediConnectApplication.class);

        assertNotNull(
                MediConnectApplication.class
                        .getAnnotation(SpringBootApplication.class));

        assertDoesNotThrow(() -> MediConnectApplication.class
                .getDeclaredMethod("main", String[].class));
    }
}