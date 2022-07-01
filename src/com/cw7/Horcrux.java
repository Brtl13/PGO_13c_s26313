package com.cw7;

// Horcrux class:
// Place of all horcruxes in the story.
import java.util.ArrayList;

public class Horcrux {
    // List of all horcruxes:
    private static ArrayList<Horcrux> horcruxes = new ArrayList<>();

    // Horcrux Id name:
    private int id;

    // Private C'tor (object can't be created by 'new' expression):
    private Horcrux(int id) {
        setId(id);
    }

    // Set horcrux name (id):
    private void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            throw new RuntimeException("Horcrux id must be positive number!");
        }
    }

    // Get horcrux name (id):
    public int getId() {
        return id;
    }

    // Get id of the last horcrux in the list (if any):
    private static int getLastId() {
        return horcruxes.isEmpty() ? 0 : horcruxes.get(horcruxes.size() - 1).getId();
    }

    // Create new horcrux object and add it to list:
    // Only Voldemort can create new horcruxes.
    public static void create(Voldemort youKnowWho, int num) {
        if (num > 0) {
            int nextId = getLastId() + 1;
            // Create num horcruxes:
            for (int i = 0; i < num; ++i, ++nextId) {
                horcruxes.add(new Horcrux(nextId));
            }

        } else {
            throw new RuntimeException("Negative value for horcruxes!");
        }
    }

    // Horcrux list dump:
    public static void print() {
        System.out.print("Created horcruxes:");
        if (!horcruxes.isEmpty()) {
            for (int i = 0; i < horcruxes.size(); ++i) {
                Horcrux horcrux = horcruxes.get(i);
                System.out.printf("\nhorcrux %d", horcrux.getId());
            }
            System.out.println();
        } else {
            System.out.println("none.");
        }
    }
}
