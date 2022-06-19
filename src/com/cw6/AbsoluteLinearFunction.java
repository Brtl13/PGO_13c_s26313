package com.cw6;

public class AbsoluteLinearFunction extends LinearFunction {

    public AbsoluteLinearFunction(double a, double b) {
        super(a, b);
    }

    @ Override
    public double f(double x) {
        double y = super.f(x);
        // Make absolute value:
        return (y < 0) ? y * -1 : y;
    }
};
