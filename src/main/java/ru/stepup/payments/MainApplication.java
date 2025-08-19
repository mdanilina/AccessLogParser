package ru.stepup.payments;

import java.io.*;
import java.util.Scanner;

public class MainApplication {
    public static <string> void main(String[] args) throws MyException, IOException {
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
        int count = 0;
        int min = 0, max = 0;
        while ((line = reader.readLine()) != null) {
            count++;
            try {
                int length = line.length();
                if (length >= 1024) {
                    throw new MyException("строка длиннее 1024 символов");
                }
                if ((length >= max) && (length < 1024)) {
                    max = length;
                } else {
                    min = length;
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }

        System.out.println("Количество строк в файле " + count);
        System.out.println("длина самой длинной строки в файле " + max);
        System.out.println("длина самой короткой строки в файле " + min);
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