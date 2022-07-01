package com.cw7;

// Orphanage class:
// Can collect only Child class objects.

public class Orphanage extends NamedObject {

    // HashMap of children in this orphanage:
    private CharacterCollector children;

    // C'tor:
    public Orphanage(String name, Location location) {
        setName(name);
        setLocation(location);
        children = new CharacterCollector();
    }

    // Add new child to the map (with location change):
    public void addChild(Child child) {
        child.setLocation(getLocation());
        children.addCharacter(child);
    }

    // Remove child from map:
    public void removeChild(Child child) {
        children.removeCharacter(child);
    }
}

