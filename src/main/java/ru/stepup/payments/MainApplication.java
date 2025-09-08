package ru.stepup.payments;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        int y = 0;
        int x = 10;
        File file = null;
        while (x >= 10) {
            String path = new Scanner(System.in).nextLine();
            file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if ((!fileExists) || (isDirectory)) {
                System.out.println("указанный файл не существует или указанный путь является путём к папке");
                continue;
            } else {
                if ((!isDirectory) && (fileExists)) {
                    y++;
                    System.out.println("Путь указан верно");
                    System.out.println("Это файл номер " + y);
                    break;
                }
            }
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        /*
        int count = 0;
        int min = 1025, max = 0;
        while ((line = reader.readLine()) != null) {
            count++;
            int length = line.length();
            if (length >= 1024) {
                throw new MyException("строка длиннее 1024 символов");
            }
            if (length >= max) {
                max = length;
            } else if (length < min) {
                min = length;
            }
        }

        System.out.println("Количество строк в файле " + count);
        System.out.println("длина самой длинной строки в файле " + max);
        System.out.println("длина самой короткой строки в файле " + min);
        */

        String fragment;
        int YandexBot = 0;
        int Googlebot = 0;
        int count = 0;
        String uagent;
        while ((line = reader.readLine()) != null) {            // startsWith('(')      substring(ot, do);
            count++;
            LogEntry logEntry = new LogEntry(line);
            String[] parts = line.split(" ");
            for (int i = 0; i < parts.length; i++) {
                fragment = parts[i].trim();
                if (fragment.contains("YandexBot")) {
                    YandexBot++;
                }
                if (fragment.contains("Googlebot")) {
                    Googlebot++;
                }
            }
            uagent= logEntry.getUserAgent();
            UserAgent agent = new UserAgent(uagent);

            LocalDateTime ldt = new LocalDateTime(16, 19);
            Statistics stat = new Statistics(logEntry, ldt);
            stat.addEntry(logEntry.getResponseSize());

            System.out.println("разница между maxTime и minTime "+ stat.getTotalTraffic()/ldt.getTrafficRate());
            System.out.println("**");
            System.out.println(logEntry);
            System.out.println(agent);
            System.out.println(stat);

        }

        double dol1 = (double) YandexBot / count;
        double dol2 = (double) Googlebot / count;

        System.out.println("равенство найденного фрагмента строкам YandexBot " + YandexBot);
        System.out.println("равенство найденного фрагмента строкам Googlebot " + Googlebot);
        System.out.println("доля запросов от YandexBot и Googlebot к веб-сайту относительно общего числа сделанных запросов " + dol1);
        System.out.println("доля запросов от YandexBot и Googlebot к веб-сайту относительно общего числа сделанных запросов " + dol2);

    }
}


/*
public class MainApplication {
    public static <string> void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int firstNumber = in1.nextInt();

        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите второе число:");
        int secondNumber = in2.nextInt();

        System.out.println("Сумма чисел: " + (firstNumber + secondNumber));
        System.out.println("Разность чисел: " + (firstNumber - secondNumber));
        System.out.println("Произведениеит889зщш чисел: " + (firstNumber * secondNumber));

        double quotient = (double) firstNumber / secondNumber;
        System.out.println("Частное чисел: " + quotient);
        }
    }
 */