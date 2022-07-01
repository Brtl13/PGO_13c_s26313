package com.cw7;

// Voldermort family class:
// Real bad character.
public class Voldemort extends Character {

    // Target map for spells:
    private CharacterCollector targets;

    // C'tor:
    // New Voldermort character will morph other character (Tom Riddle):
    public Voldemort(Character character) {
        // Add new (black) character object:
        super("Lord Voldemort", character.getLocation());
        // Get giver's life energy:
        setStrength(character.getStrength());
        // Kill previous instance:
        characters.removeCharacter(character);
    }

    // Voldemort can't move to Hogwarts, so override super method moveTo.
    // In original Main this code seemed to be omitted, but here it works
    // and throws proper exception.
    @Override
    public void moveTo(Location location) {
        if (location == Location.Hogwarts) {
            throw new StoryViolationException(
                    "Story violation: Voldemort can't move to Hogwarts! (This check is included in Main() but no result in attached listing).");
        } else {
            super.moveTo(location);
        }
    }

    // Create horcrouxes:
    // Exclusively for Voldemort.
    public void createHorcruxes(int num) {
        Horcrux.create(this, num);
    }

    // Horcruxes list dump:
    public void printHorcruxes() {
        Horcrux.print();
    }

    // Make other character spell target:
    public void target(Character character) {
        if (targets == null) {
            targets = new CharacterCollector();
        }
        if (!targets.isCharacter(character)) {
            targets.addCharacter(character);
        } else {
            throw new RuntimeException("Target already on the list!");
        }
    }

    // Cast spell on targets:
    public void castSpell(Spell spell) {
        // Use function interface (see ListAction and CharacterCollector.foreach):
        targets.foreach(new ListAction() {
            public void action(Character character) {
                character.enchanted(spell);
            }
        });
        targets.clear();
        enchanted(spell);
    }
}
