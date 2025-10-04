package io.ikka.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TimeControllerTest {
    private static final String SERVER_TIME = "serverTime";
    private static final String TIMESTAMP = "timestamp";
    private static final String TIMEZONE = "timezone";

    @InjectMocks
    private TimeController timeController;

    @Test
    void getCurrentTime_ReturnsValidResponseStructure() {
        // When
        Map<String, String> response = timeController.getCurrentTime();

        // Then
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertTrue(response.containsKey(SERVER_TIME));
        assertTrue(response.containsKey(TIMESTAMP));
        assertTrue(response.containsKey(TIMEZONE));

        // Verify values are not null or empty
        assertNotNull(response.get(SERVER_TIME));
        assertNotNull(response.get(TIMESTAMP));
        assertNotNull(response.get(TIMEZONE));
        assertFalse(response.get(SERVER_TIME).isEmpty());
        assertFalse(response.get(TIMESTAMP).isEmpty());
        assertFalse(response.get(TIMEZONE).isEmpty());
    }

    @Test
    void getCurrentTime_ServerTimeIsValidISOFormat() {
        // When
        Map<String, String> response = timeController.getCurrentTime();
        String serverTime = response.get(SERVER_TIME);

        // Then - should parse as ISO offset date time
        assertDoesNotThrow(() -> {
            ZonedDateTime.parse(serverTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        });
    }

    @Test
    void getCurrentTime_TimestampIsValidLong() {
        // When
        Map<String, String> response = timeController.getCurrentTime();
        String timestamp = response.get(TIMESTAMP);

        // Then
        assertDoesNotThrow(() -> Long.parseLong(timestamp));
        long timestampLong = Long.parseLong(timestamp);
        assertTrue(timestampLong > 0); // Should be a positive timestamp
    }
}