package com.cw1;

import java.util.Scanner;

public class Zad7 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int n = 0;
        System.out.print("Podaj wielkość rysunku (wartość nie może być mniejsza niż 5 i musi być nieparzysta): ");
        while(true) {
            n = s1.nextInt();
            if(n < 6 || n % 2 == 0) {
                System.out.print("Wprowadzono nieprawidłową wartość, proszę spróbować ponownie: ");
            }
            else break;
        }
        s1.close();

        String bar = "";
        for(int i = 0; i < n; ++i){
            bar = bar + "*";
        }
        int skos=0;

        System.out.println(bar);
        for(int i = 1; i < n - 1; ++i) {
            skos++;
            for(int j = 0; j < n; ++j) {
                if(j == 0 || j == skos || j == n - 1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println(bar);
    }
}
