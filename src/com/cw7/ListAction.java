package com.cw7;

// Function interface for action on CharacterCollector
// container elements.
// See ovverides: Character.action and Voldemort.castSpell
// for details.
@FunctionalInterface
public interface ListAction {

    public abstract void action(Character character);

}
