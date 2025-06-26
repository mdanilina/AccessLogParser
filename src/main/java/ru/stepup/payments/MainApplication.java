package ru.stepup.payments;

import java.util.Scanner;

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
        System.out.println("Произведение чисел: " + (firstNumber * secondNumber));

        double quotient = (double) firstNumber / secondNumber;
        System.out.println("Частное чисел: " + quotient);
        }
    }
