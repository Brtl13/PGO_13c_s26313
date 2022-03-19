package com.cw1;

import java.util.Scanner;

public class Zad3 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        int[] Array = new int[3];

        System.out.print("Podaj a:");
        Array[0] = s1.nextInt();
        System.out.print("Podaj b:");
        Array[1] = s1.nextInt();
        System.out.print("Podaj c:");
        Array[2] = s1.nextInt();
        s1.close();

        if (Array[0] > Array[1] && Array[0] > Array[2]) {
            int tmp = Array[2];
            Array[2] = Array[0];
            Array[0] = tmp;
        }
        if (Array[1] > Array[0] && Array[1] > Array[2]) {
            int tmp = Array[2];
            Array[2] = Array[1];
            Array[1] = tmp;
        }
        if(Array[0] > Array[1]) {
            int tmp = Array[1];
            Array[1] = Array[0];
            Array[0] = tmp;
        }
        System.out.print(Array[0] + " " + Array[1] + " " + Array[2]);

    }
}