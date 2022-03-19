package com.cw1;

import java.util.Scanner;

public class Zad2 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int a, b, c;

        System.out.print("Podaj a:");
        a = s1.nextInt();
        System.out.print("Podaj b:");
        b = s1.nextInt();
        System.out.print("Podaj c:");
        c = s1.nextInt();
        s1.close();

        if (a > b && a > c) {
            int tmp = c;
            c = a;
            a = tmp;
        }
        if (b > a && b > c) {
            int tmp = c;
            c = b;
            b = tmp;
        }
        if(a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        System.out.print(a + " " + b + " " + c );
    }
}