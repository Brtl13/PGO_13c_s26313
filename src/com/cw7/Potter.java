package com.cw7;

// Potter family class:

public class Potter extends Child {

    // C'tor:
    public Potter(String name, Location location) {
        super(name, location);
    }

    // Override enchanted method of Character class.
    // Harry will be immunized to spells here but others won't be so lucky.
    @Override
    public void enchanted(Spell spell) {
        if (getName() == "Harry") {
            System.out.printf("Harry goes LOL...\n");
        } else {
            super.enchanted(spell);
        }
    }
}

