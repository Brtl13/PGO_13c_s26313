package com.cw6;

public class SquareFunction extends Function {
    private double a = 0;
    private double b = 0;
    private double c = 0;

    public SquareFunction(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getB() {
        return b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getC() {
        return c;
    }

    @ Override
    public double f(double x) {
        return a * x * x + b * x + c;
    }

    @Override
    public void increaseCoefficientsBy(double delta) {
        a += delta;
        b += delta;
        c += delta;
    }

    @Override
    public void decreaseCoefficientsBy(double delta) {
        a -= delta;
        b -= delta;
        c -= delta;
    }
}