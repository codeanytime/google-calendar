package com.thanhch.service.impl;

import com.google.api.client.googleapis.testing.services.MockGoogleClient;
import com.google.api.client.googleapis.testing.services.MockGoogleClientRequest;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonParser;
import com.google.api.client.testing.http.MockHttpTransport;
import com.thanhch.request.CalendarRequest;
import com.thanhch.response.CalendarResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalendarServiceImplTest {

    CalendarServiceImpl calendarServiceImplUnderTest;

    CalendarServiceImpl calendarService;

    @BeforeEach
    void setUp() {
        calendarServiceImplUnderTest = new CalendarServiceImpl();
        calendarService = Mockito.spy(calendarServiceImplUnderTest);
    }

    @Test
    void testAddEvent() throws Exception {
        // Setup
        final CalendarRequest request = new CalendarRequest("nameEvent", "description",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Arrays.asList("value"));
        // Run the test
        final CalendarResponse result = calendarService.addEvent(request);

        // Verify the results
    }

    @Test
    void testAddEvent_ThrowsGeneralSecurityException() {
        // Setup
        final CalendarRequest request = new CalendarRequest("nameEvent", "description",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), Arrays.asList("value"));

        // Run the test
        assertThatThrownBy(() -> calendarServiceImplUnderTest.addEvent(request))
                .isInstanceOf(GeneralSecurityException.class);
    }

    @Test
    void testAddEvent_ThrowsIOException() {
        // Setup
        final CalendarRequest request = new CalendarRequest("nameEvent", "description",
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), Arrays.asList("value"));

        // Run the test
        assertThatThrownBy(() -> calendarServiceImplUnderTest.addEvent(request)).isInstanceOf(IOException.class);
    }
}
