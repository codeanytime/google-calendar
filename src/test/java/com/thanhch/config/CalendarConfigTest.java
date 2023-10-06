package com.thanhch.config;

import com.google.api.services.calendar.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalendarConfigTest {

    private CalendarConfig calendarConfigUnderTest;

    @BeforeEach
    void setUp() {
        calendarConfigUnderTest = new CalendarConfig();
    }

    @Test
    void testConfigure() throws Exception {
        // Setup
        // Run the test
        final Calendar result = calendarConfigUnderTest.configure();

        // Verify the results
    }

    @Test
    void testConfigure_ThrowsIOException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> calendarConfigUnderTest.configure()).isInstanceOf(IOException.class);
    }

    @Test
    void testConfigure_ThrowsGeneralSecurityException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> calendarConfigUnderTest.configure()).isInstanceOf(GeneralSecurityException.class);
    }
}
