package ru.stepup.payments;

import lombok.Data;

@Data
public class UserAgent {

    private final String type_os, bro_name;

    public UserAgent(String userAgent) {
        this.type_os = detectOS(userAgent);
        this.bro_name = detectBrowser(userAgent);
    }

    private String detectOS(String ua) {
        String lower = ua.toLowerCase();
        if (lower.contains("windows")){
            return "Windows";
        }
        else if (lower.contains("mac os")|| lower.contains("macintosh")){
            return "MacOS";
        }
        else if (lower.contains("linux")){
            return "Linux";
        }
        return "Other";
    }

    private String detectBrowser(String ua) {
        String lower = ua.toLowerCase();
        if (lower.contains("edg")){
            return "EDGE";
        }
        else if (lower.contains("firefox")){
            return "FIREFOX";
        }
        else if (lower.contains("chrome") || lower.contains("chromium")){
            return "CHROME";
        }
        else if (lower.contains("opera") || lower.contains("opr")){
            return "OPERA";
        }
        else if (lower.contains("yandex")){
            return "YANDEX";
        }
        return "Other";
    }
}
