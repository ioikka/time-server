package io.ikka.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeController {

    @GetMapping("/time")
    public Map<String, String> getCurrentTime() {
        ZonedDateTime now = ZonedDateTime.now();
        Map<String, String> response = new HashMap<>();
        response.put("serverTime", now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));
        response.put("timezone", now.getZone().toString());
        return response;
    }
}