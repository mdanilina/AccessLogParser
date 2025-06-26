package ru.stepup.payments;

import java.util.Scanner;

public class MainApplication {
    public static <string> void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        System.out.println("введите первое число:");
        int firstNumber = in1.nextInt();

        Scanner in2 = new Scanner(System.in);
        System.out.println("введите второе число:");
        int secondNumber = in2.nextInt();

        System.out.println("сумма чисел: " + (firstNumber + secondNumber));
        System.out.println("разность чисел: " + (firstNumber - secondNumber));
        System.out.println("произведение чисел: " + (firstNumber * secondNumber));

        double quotient = (double) firstNumber / secondNumber;
        System.out.println("частное чисел: " + quotient);
        }
    }
