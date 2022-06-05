package com.cw5;

// Class Flower:
// Inheritance: Ingredient <- Plant <- Flower.

public class Flower extends Plant {
    public Flower(String name, int baseReagent, int toxity) {
        super(name + " Flower", baseReagent, toxity);
    }

    @ Override
    public int getReagent() {
        // Multiply reagent by 2:
        return super.getReagent() * 2;
    }

    @ Override
    public void print() {
        super.print();
        System.out.printf(")\n");
    }
}

