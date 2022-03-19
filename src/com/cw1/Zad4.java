package com.cw1;

public class Zad4 {
    public static void forMethod(int counter) {
        for (counter = 0; counter < 10; counter++) {
            System.out.println("Hello World");
        }
    }

    public static void whileMethod(int counter) {
        while (counter < 10) {
            System.out.println("Hello World");
            counter++;
        }
    }

    public static void doWhileMethod(int counter) {
        do {
            System.out.println("Hello World");
            counter++;
        }
        while (counter < 10);
    }

    public static void main(String[] args) {
        int counter = 0;
        System.out.println("Metoda For: ");
        forMethod(counter);
        System.out.println("Metoda While: ");
        whileMethod(counter);
        System.out.println("Metoda Do-While: ");
        doWhileMethod(counter);
    }
}
