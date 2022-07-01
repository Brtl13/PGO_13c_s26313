package com.cw7;


// Common abstraction class for all story characters:

public abstract class Character extends NamedObject {
    // List of all created characters:
    protected static CharacterCollector characters = new CharacterCollector();
    // Character strength (health points):
    private int strength;

    // Protected Constructor:
    protected Character(String name, Location location) {
        setName(name);
        setLocation(location);
        setStrength(100);
        characters.addCharacter(this);
    }

    // Set strength of character:
    public void setStrength(int strength) {
        if (strength <= 100) {
            this.strength = strength;
        } else {
            throw new RuntimeException("strength can't exceed 100%!");
        }
    }

    // Get strength of character:
    public int getStrength() {
        return strength;
    }

    // Move character to specified location:
    public void moveTo(NamedObject nlObject) {
        setLocation(nlObject.getLocation());
    }

    // Character self introduction:
    public void introduce() {
        System.out.printf("Hello, I am %s.\n", getName());
    }

    // Conversation with other character:
    public void say(String what, Character to) {
        if (what != null && !what.isEmpty()) {
            System.out.printf("%s to %s:\n    %s\n", getName(), to.getName(), what);
        } else {
            System.out.printf("%s to %s:\n    [meaningful silence]...\n", getName(), to.getName());
        }
    }

    // Action to perform:
    public void doSth(String what) {
        if (what != null && !what.isEmpty()) {
            System.out.printf("I am %s, I am %s.\n", getName(), what);
        } else {
            System.out.printf("I am %s, I am hanging around...\n", getName());
        }
    }

    // Action to perform for listed characters:
    public static void doSth(String what, Character... characters) {
        for (int i = 0; i < characters.length; ++i) {
            characters[i].doSth(what);
        }
    }

    // Spell effect:
    // Each spell removes its power from character strength.
    // If strength reaches 0, character dies.
    public void enchanted(Spell spell) {
        strength -= spell.power;
        if (strength <= 0) {
            strength = 0;
            System.out.printf("%s has died.\n", getName());
        }
    }

    // Character status dump:
    public static void status() {
        characters.status();
    }
}

// End of Character