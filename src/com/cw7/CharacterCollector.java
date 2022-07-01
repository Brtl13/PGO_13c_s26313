package com.cw7;

// Common container class for collect Character objects:
// (For Character and Orphanage static members).

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class CharacterCollector implements ListAction {

    // HashMap of characters:
    private HashMap<String, Character> characters;

    // Nested class for status dump sorting:
    class Pair {
        // Character name:
        public String name;
        // Character strength:
        public int strength;
        // C'tor:
        public Pair(String name, int strength) {
            this.name = name;
            this.strength = strength;
        }
    }

    // C'tor:
    protected CharacterCollector() {
        characters = new HashMap<>();
    }

    // Default implementation of function interface method action:
    @Override
    public void action(Character character) {
        // Do nothing...
        // See Voldemort.castSpell for details.
    }

    // Applies the action (above) to everyone:
    protected void foreach(ListAction listAction) {
        for (HashMap.Entry<String, Character> elem : characters.entrySet()) {
            Character character = elem.getValue();
            listAction.action(character);
        }
    }

    // Does character exist?
    protected boolean isCharacter(Character character) {
        return characters.containsValue(character);
    }

    // Adds new character to map:
    protected void addCharacter(Character character) {
        if (!characters.containsKey(character.getName())) {
            characters.put(character.getName(), character);
        } else {
            throw new RuntimeException("Character with name already in list!");
        }
    }

    // Remove existing character from map:
    protected void removeCharacter(Character character) {
        if (characters.remove(character.getName()) == null) {
            throw new RuntimeException("Character not found!");
        }
    }

    // Name order on Main() listing is other (it uses ArrayList I believe),
    // because of alphabetical output sort from unordered HashMap here.
    public void status() {
        ArrayList<Pair> sortedPairs = new ArrayList<>();
        // Get names and strength values and put them in the ArrayList:
        for (HashMap.Entry<String, Character> elem : characters.entrySet()) {
            Character character = elem.getValue();
            sortedPairs.add(new Pair(character.getName(), character.getStrength()));
        }
        // Sort the ArrayList by name:
        sortedPairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return pair1.name.compareTo(pair2.name);
            }
        });
        // Print result:
        System.out.print("====Status====");
        for (Pair elem : sortedPairs) {
            System.out.printf("\n%s : %d", elem.name, elem.strength);
        }
        System.out.println("\n==============");
    }

    // Clear map:
    protected void clear() {
        characters.clear();
    }
}


