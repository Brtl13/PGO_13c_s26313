package com.cw5;

// Class Alcohol:
// Inheritance: Ingredient <- Liquid <- Alcohol.

public class Alcohol extends Liquid {
    private int percent;

    public void setPercent(int percent) {
        if (percent >= 0 && percent <= 100) {
            this.percent = percent;
        } else {
            throw new RuntimeException("Alcohol: percentage out of bounds!");
        }
    }

    public Alcohol(int baseReagent, int percent, int dissolubility) throws RuntimeException {
        super("Alcohol", baseReagent, dissolubility);
        setPercent(percent);
    }

    @Override
    public int getReagent() {
        // Percent of reagent:
        return super.getReagent() * percent / 100;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf(", Percent: %d%%)\n", percent);
    }
}

