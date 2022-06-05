package com.cw5;

// Class Ore:
// Inheritance: Ingredient <- Mineral <- Ore.

public class Ore extends Mineral {
    private boolean metallic;

    public Ore(String name, int baseReagent, int power, boolean metallic) {
        super(name + " Ore", baseReagent, power);
        this.metallic = metallic;
    }

    @ Override
    public int getReagent() {
        // If not metallic divide reagent by 2:
        return metallic ? super.getReagent() : super.getReagent() / 2;
    }

    @ Override
    public void print() {
        super.print();
        System.out.printf(", Metallic: %s)\n", super.yesOrNo(metallic));
    }
}
