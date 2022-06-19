package com.cw6;

public class LinearFunction extends Function {
    private double a = 0;
    private double b = 0;

    public LinearFunction(double a, double b) {
        setA(a);
        setB(b);
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

    @ Override
    public double f(double x) {
        return a * x + b;
    }

    @Override
    public void increaseCoefficientsBy(double delta) {
        a += delta;
        b += delta;
    }

    @Override
    public void decreaseCoefficientsBy(double delta) {
        a -= delta;
        b -= delta;
    }
}