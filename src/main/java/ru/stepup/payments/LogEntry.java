package ru.stepup.payments;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class LogEntry {

    private final String ipAddr, str, referer, userAgent;
    private final String path;
    private final Integer responseCode;
    private final Long responseSize;

    //private final Integer responseSize;
    private final LocalDateTime time;
    private final Method method;

    //211.71.205.41 - - [25/Sep/2022:06:25:08 +0300] "GET /november-reports/estimation/decisions/6373/67 HTTP/1.0" 200 9273 "-" "Mozilla/5.0 (compatible; MegaIndex.ru/2.0; +http://megaindex.com/crawler)"
    private final String DELEMETER = " ";
    private final int ipAddr_index = 0;
    private final int str_index1 = 1;
    private final int str_index2 = 2;
    private final int time_index = 3;
    private final int time_index1 = 4;
    private final int method_index = 5;
    private final int path_index = 6;
    private final int responseCode_index = 8;
    private final int responseSize_index = 9;
    private final int referer_index = 10;
    private final int userAgent_index = 11;
    private final int userAgent_index1 = 12;
    private final int userAgent_index2 = 13;
    private final int userAgent_index3 = 14;


    public LogEntry(String line) {

        String[] parts = line.split(DELEMETER);

        this.ipAddr = parts[ipAddr_index];
        this.str = parts[str_index1] + " " + parts[str_index2];
        this.time = get_time(parts[time_index] + " " + parts[time_index1]);
        this.method = Method.valueOf(parts[method_index].replace("\"",""));//parts[method_index].length()+1));
        //this.path = Path.of(parts[path_index]);
        this.path = parts[path_index];
        this.responseCode = Integer.parseInt(parts[responseCode_index]);
        this.responseSize = Long.valueOf(parts[responseSize_index]);
        this.referer = parts[referer_index];
        //System.out.println(parts.length);

        String str = "";
        for (int i = 11; i < parts.length; i++) {
            str += parts[i];
        }
        this.userAgent = str;

    }

    //Передаем дататайм в кв скобках [25/Sep/2022:06:25:08 +0300]
    private LocalDateTime get_time(String str) {
        String str_new = str.substring(1, str.length() - 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        return formatter.parse(str_new, LocalDateTime::from);
    }
}