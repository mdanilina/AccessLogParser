package ru.stepup.payments;

import lombok.Data;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Statistics {
    private Long totalTraffic = 0L;
    private List<LogEntry> logEntry = new ArrayList<>();
    private LocalDateTime minTime, maxTime;
    private Integer totalRequests = 0;

    public void addEntry(LogEntry logEntry) {
        LocalDateTime time = logEntry.getTime();
        if (minTime == null || time.isBefore(minTime)) {
            minTime = time;
        }
        if (maxTime == null || time.isAfter(maxTime)) {
            maxTime = time;
        }
        totalRequests++;
        if (logEntry.getResponseSize() != null && logEntry.getResponseSize() > 0) {
            totalTraffic += logEntry.getResponseSize();
        }
        this.logEntry.add(logEntry);
    }

    public Long getTrafficRate() {
        if (minTime == null || maxTime == null) {
            return 0L;
        }
        long hours = Duration.between(minTime, maxTime).toHours();
        if (hours == 0) {
            return totalTraffic;
        }
        return totalTraffic / hours;
    }
}
