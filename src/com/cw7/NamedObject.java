package com.cw7;

// Abstract class for named and located objects.
// Currently all Character and Orphanage objects will
// inherit it.

public abstract class NamedObject {

    // Object name:
    protected String name;

    // Object location:
    protected Location location;

    // Set object name:
    protected void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new RuntimeException("name can't be empty!");
        }
    }

    // Get object name:
    public String getName() {
        return name;
    }

    // Set object location:
    protected void setLocation(Location location) {
        if (location != null) {
            this.location = location;
        } else {
            // throw: location can't be null!
            throw new RuntimeException("no location specified!");
        }
    }

    // Get object location:
    public Location getLocation() {
        return location;
    }

    // Move object to another location:
    public void moveTo(Location location) {
        setLocation(location);
    }

    // Move listed objects to another location:
    public static void MoveAllTo(Location location, NamedObject... objects) {
        for (int i = 0; i < objects.length; ++i) {
            objects[i].setLocation(location);
        }
    }

}