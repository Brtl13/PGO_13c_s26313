package com.cw5;

// Class Water:
// Inheritance: Ingredient <- Liquid <- Water.

public class Water extends Liquid {
    // Default dissolubility for water:
    private static final int thisDissolubility = 55;
    private boolean distilated;

    public Water(int baseReagent, boolean distilated) {
        super("Water", baseReagent, thisDissolubility);
        this.distilated = distilated;
    }

    @Override
    public int getReagent() {
        // If water not distilated div reagent by 2:
        return distilated ? super.getReagent() : super.getReagent() / 2;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf(", Distilated: %s)\n", super.yesOrNo(distilated));
    }
}
