package com.cw5;

// Class Crystal:
// Inheritance: Ingredient <- Mineral <- Crystal.

public class Crystal extends Mineral {
    private int magicPower;

    public Crystal(String name, int baseReagent, int power, int magicPower) {
        super(name + " Crystal", baseReagent, power);
        this.magicPower = magicPower;
    }

    @ Override
    public int getReagent() {
        // Add magic power to reagent:
        return super.getReagent() + magicPower;
    }

    @ Override
    public void print() {
        super.print();
        System.out.printf(", Magic Power: %d)\n", magicPower);
    }
}
