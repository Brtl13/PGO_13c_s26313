package com.cw5;

// Class Liquid:
// Base class for Water and Alcohol.
// Inheritance: Ingredient <- Liquid.

public class Liquid extends Ingredient {
    private int dissolubility;

    // Copy constructor (for adding catalyst in Elixir):
    public Liquid(Liquid otherLiquid) {
        super(otherLiquid.getName(), otherLiquid.getReagent());
        this.dissolubility = otherLiquid.dissolubility;
    }

    public void setDissolubility(int dissolubility) {
        if (dissolubility >= 0 && dissolubility <= 100) {
            this.dissolubility = dissolubility;
        } else
            throw new RuntimeException("Liquid: dissolubility out of bounds!");
    }

    public Liquid(String name, int baseReagent, int dissolubility) throws RuntimeException {
        super(name, baseReagent);
        setDissolubility(dissolubility);
    }

    @Override
    public int getReagent() {
        return super.getReagent() * dissolubility / 100;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf(", Dissolubility: %d%%", dissolubility);
    }
}