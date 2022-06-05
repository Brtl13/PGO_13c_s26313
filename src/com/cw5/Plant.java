package com.cw5;

// Class Plant:
// Base class for Flower and Root.
// Inheritance: Ingredient <- Plant.

public class Plant extends Ingredient {
    private int toxity;

    public Plant(String name, int baseReagent, int toxity) {
        super(name, baseReagent);
        this.toxity = toxity;
    }

    public int getToxity() {
        return toxity;
    }

    public void setToxity(int toxity) {
        this.toxity = toxity;
    }

    @ Override
    public int getReagent() {
        if (toxity > 0)
        {
            return super.getReagent() * toxity;
        }
        return super.getReagent();
    }

    @ Override
    public void print() {
        super.print();
        System.out.printf(", Toxity: %d", toxity);
    }
}