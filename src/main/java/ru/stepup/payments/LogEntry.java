package ru.stepup.payments;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogEntry {

    private final String ipAddr, str, method, path, responseCode, referer, userAgent;
    private final Integer responseSize;
    //private final Integer responseSize;
    private final Instant time;

    //211.71.205.41 - - [25/Sep/2022:06:25:08 +0300] "GET /november-reports/estimation/decisions/6373/67 HTTP/1.0" 200 9273 "-" "Mozilla/5.0 (compatible; MegaIndex.ru/2.0; +http://megaindex.com/crawler)"
    private final static String DELEMETER = " ";
    private final static int ipAddr_index=0;
    private final static int str_index1=1;
    private final static int str_index2=2;
    private final static int time_index=3;
    private final static int time_index1=4;
    private final static int method_index=5;
    private final static int path_index=6;
    private final static int responseCode_index=8;
    private final static int responseSize_index=9;
    private final static int referer_index=10;
    private final static int userAgent_index=11;
    private final static int userAgent_index1=12;
    private final static int userAgent_index2=13;



    public LogEntry(String line) {

        String[] parts = line.split(DELEMETER);

        this.ipAddr = parts[ipAddr_index];
        this.str = parts[str_index1]+ " " +parts[str_index2];
        this.time = gettime(parts[time_index]+" " + parts[time_index1]);
        this.method = parts[method_index].substring(1,parts[method_index].length());
        this.path = parts[path_index];
        this.responseCode = parts[responseCode_index];
        this.responseSize = Integer.parseInt(parts[responseSize_index]);
        this.referer = parts[referer_index];
        //System.out.println(parts.length);

        String str="";
        for(int i=11;i<parts.length;i++){
            str+=parts[i];
        }
        this.userAgent = str;
        /*if (parts.length == 15 ) {
            this.userAgent = parts[userAgent_index] + parts[userAgent_index1] + parts[userAgent_index2];
        }
        else if (parts.length == 14 ) {
            this.userAgent = parts[userAgent_index] + parts[userAgent_index1];
        }
        else {
            this.userAgent = parts[userAgent_index];
        }*/

    }

    //Передаем дататайм в кв скобках [25/Sep/2022:06:25:08 +0300]
    private static Instant gettime(String str) {
        String str_new = str.substring(1,str.length()-1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        Instant instant1 = formatter.parse(str_new, Instant::from);
        return instant1;
    }
    public String getIP() {
        return ipAddr;
    }

    public String getStr() {
        return str;
    }

    public Instant getDatetime() {
        return time;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString(){
        return "Log Entry "+ "{"+this.ipAddr + " " + this.str +" "+  this.time + " " + this.method + " " + this.path + " " + this.responseCode + " " + this.responseSize
        + " " + this.referer + " " + this.userAgent + "}";
    }

    public String getPath() {
        return path;
    }

    public String getCode() {
        return responseCode;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public Integer getResponseSize() {
        return responseSize;
    }
}
