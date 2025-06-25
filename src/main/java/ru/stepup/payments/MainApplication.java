package ru.stepup.payments;

import java.io.InputStream;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Text;

public class MainApplication {
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public static <string> void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.println("ведите текст и нажмите <Enter>: " + Math.random());

        Scanner input = new Scanner(System.in);
        System.out.println("ведите текст и нажмите <Enter>: ");
        String text = input.nextLine(); // здесь идет считывание текста
        System.out.println("Длина текста: " + text.length());
    }

    private static class scanner {
        public scanner(InputStream in) {

        }
    }
}
