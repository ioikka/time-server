package io.ikka.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeController {

    @GetMapping("/time")
    public Map<String, String> getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        Map<String, String> response = new HashMap<>();
        response.put("serverTime", now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return response;
    }
}