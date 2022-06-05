package com.cw5;

// Base abstract class with protected constructor
// and methods (can't be constructed as alone object).
// Base class for Liquid, Mineral and Plant.

public abstract class Ingredient {
    private String name;
    private int baseReagent;

    protected Ingredient(String name, int baseReagent) {
        this.name = name;
        this.baseReagent = baseReagent;
    }

    protected String getName() {
        return name;
    }

    protected int getReagent() {
        return baseReagent;
    }

    // Returns boolean strings of condition:
    protected static String yesOrNo(boolean condition) {
        return condition ? "yes" : "no";
    }

    public void print() {
        System.out.printf("%s (Reagent: %s", name, baseReagent);
    }
}
