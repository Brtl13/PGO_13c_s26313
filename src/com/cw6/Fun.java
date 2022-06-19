package com.cw6;

public interface Fun {
    double f(double x);

    static double minimum(Fun func, double a, double b, double alpha) {
        double min = 0;
        // We need at least two points, so a + alpha must be less or equal b:
        if ((a + alpha) <= b) {
            min = func.f(a);
            double tmp = 0;
            a += alpha;
            for (; a <= b; a += alpha) {
                tmp = func.f(a);
                if (tmp < min)
                    min = tmp;
            }

        } else {
            throw new RuntimeException("Fun:minimum() parameters: a + alpha must be less than or equal to b!");
        }
        return min;
    }
}
