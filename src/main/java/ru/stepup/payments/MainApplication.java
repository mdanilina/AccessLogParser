package ru.stepup.payments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

        String fragment;
        int YandexBot = 0;
        int Googlebot = 0;
        int count = 0;
        String uagent;

        Statistics stat = new Statistics();
        UserAgent agent = null;

        while ((line = reader.readLine()) != null) {            // startsWith('(')      substring(ot, do);
            count++;

            int length = line.length();
            if (length >= 1024) {
                throw new MyException("строка длиннее 1024 символов");
            }

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

            LogEntry logEntry = new LogEntry(line);
            agent = new UserAgent(logEntry.getUserAgent());
            stat.addEntry(logEntry);
        }

        double dol1 = (double) YandexBot / count;
        double dol2 = (double) Googlebot / count;

        System.out.println("равенство найденного фрагмента строкам YandexBot " + YandexBot);
        System.out.println("равенство найденного фрагмента строкам Googlebot " + Googlebot);
        System.out.println("доля запросов от YandexBot и Googlebot к веб-сайту относительно общего числа сделанных запросов " + dol1);
        System.out.println("доля запросов от YandexBot и Googlebot к веб-сайту относительно общего числа сделанных запросов " + dol2);

        System.out.println("Средний объем трафика в час " + stat.getTrafficRate() / 1_048_576 + " МБ");

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