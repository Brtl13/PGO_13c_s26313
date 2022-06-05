package com.cw5;

// Class Mineral:
// Base class for Ore and Crystal.
// Inheritance: Ingredient <- Mineral.

public class Mineral extends Ingredient {
    private int power;

    public Mineral(String name, int baseReagent, int power) {
        super(name, baseReagent);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @ Override
    public int getReagent() {
        return super.getReagent() + power;
    }

    @ Override
    public void print() {
        super.print();
        System.out.printf(", Power: %d", power);
    }
}