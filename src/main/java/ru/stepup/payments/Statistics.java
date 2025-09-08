package ru.stepup.payments;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private Integer totalTraffic;
    LogEntry logEntry;
    LocalDateTime ldt;
    //private List<Integer> stat=new ArrayList<>();

    public Statistics(LogEntry logEntry, LocalDateTime ldt) {
        this.logEntry = logEntry;
        this.ldt = ldt;
    }

    public void addEntry(int totalTraffic) {
        this.totalTraffic = totalTraffic;
    }

    @Override
    public String toString() {
        return "Statistica " + "{" + this.logEntry + " " + this.totalTraffic + " " + this.ldt + "}";
    }

    public Integer getTotalTraffic() {
        return totalTraffic;
    }
}
