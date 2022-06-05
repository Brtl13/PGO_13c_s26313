package com.cw5;

// Class Root:
// Inheritance: Ingredient <- Plant <- Root.

public class Root extends Plant {
    public Root(String name, int baseReagent, int toxity) {
        super(name + " Root", baseReagent, toxity);
    }

    @ Override
    public int getReagent() {
        // Dvide reagent by 2:
        return super.getReagent() / 2;
    }

    @ Override
    public void print() {
        super.print();
        System.out.printf(")\n");
    }
}

