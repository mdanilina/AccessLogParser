package ru.stepup.payments;

import java.io.File;
import java.util.Scanner;

public class MainApplication {
    public static <string> void main(String[] args) {
        int y = 0;
        int x = 10;
        while (x >= 10){
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if ((!fileExists) || (isDirectory)) {
                System.out.println("указанный файл не существует или указанный путь является путём к папке");
                continue;
            }
            else {
                if ((!isDirectory) && (fileExists)) {
                    y++;
                    System.out.println("Путь указан верно");
                    System.out.println("Это файл номер "+y);
                }
            }
        }
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