package com.cw6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static double f(double x) {
        return x;
    }

    private static final DecimalFormat df = new DecimalFormat("0.0");

    public static void main(String[] args) {
        List<Function> functions = new ArrayList<>();
        functions.add(new LinearFunction(2, 4));
        functions.add(new SquareFunction(2, 0, -2.5));
        functions.add(new AbsoluteLinearFunction(2, 4));

        List<Fun> funList = new ArrayList<>(functions);
        System.out.println("Original functions");
        funList.forEach(f -> System.out.println(df.format(Fun.minimum(f, -4, 0, 0.1))));

        functions.forEach(f -> f.increaseCoefficientsBy(1.2));
        System.out.println("Functions increased by 1.2");

        funList.forEach(f -> System.out.println(df.format(Fun.minimum(f, -4, 0, 0.1))));

        functions.forEach(f -> f.decreaseCoefficientsBy(1.2));
        System.out.println("Functions decreased by 1.2");
        funList.forEach(f -> System.out.println(df.format(Fun.minimum(f, -4, 0, 0.1))));

        // *** Five points reward ***
        System.out.println("\n*************************************");
        // Utworzenie obiektu anonimowej klasy implementującej interfejs Fun:
        // Definicja lambda:
        // Fun powerOfTwo = x -> x * x;
        double r = 25.50;

        Fun value = new Fun() {
            @Override
            public double f(double x) {
                return x;
            }
        };

        Fun circumference = new Fun() {
            @Override
            public double f(double x) {
                return 2 * Math.PI * x;
            }
        };

        Fun area = new Fun() {
            @Override
            public double f(double x) {
                return Math.PI * x * x;
            }
        };

        System.out.println("Circle:");
        printResult("Radius", value, r);
        printResult("Circumference", circumference, r);
        printResult("Area", area, r);

        Fun powerOfTwo = new Fun() {
            // Definicja przesłaniająca abstrakcyjną metodę Fun.f(x),
            // która zwróci liczbę x podniesioną do potęgi 2:
            @Override
            public double f(double x) {
                return x * x;
            }
        };
        System.out.println();
        printResult("Power of two", powerOfTwo, 12);
    }

    private static void printResult(String what, Fun operation, double x) {
        System.out.println(what + ": " + df.format(operation.f(x)));
    }
}