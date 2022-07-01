package com.cw7;

public class Main {
    public static void main(String[] args) {
        Child tom = new Riddle("Tom Marvolo Riddle", Location.England);
        Orphanage woolsOrphanage = new Orphanage("Wool's Orphanage", Location.London);

        woolsOrphanage.addChild(tom);
        if (tom.getLocation() != Location.London) {
            throw new StoryViolationException("Tom Riddle should be in London");
        }

        Dumbledore albus = new Dumbledore("Albus Percival Wulfric Brian Dumbledore", Location.England);
        albus.moveTo(woolsOrphanage);

        tom.introduce();
        albus.introduce();

        Character.MoveAllTo(Location.Hogwarts, tom, albus);

        albus.say("Do you have anything to tell me?", tom);
        tom.say("No, professor.", albus);

        Voldemort youKnowWho = new Voldemort((Riddle) tom);
        youKnowWho.createHorcruxes(7);
        youKnowWho.printHorcruxes();

        Character lily = new Potter("Lily", Location.GodricsHollow);
        Character james = new Potter("James", Location.GodricsHollow);
        Child harry = new Potter("Harry", Location.GodricsHollow);

        lily.doSth("hiding");
        james.doSth("hiding");
        harry.doSth("hiding");

        try {
            youKnowWho.moveTo(Location.Hogwarts);
        } catch (StoryViolationException e) {
            e.printMessage();
        }

        Character.status();

        youKnowWho.moveTo(Location.GodricsHollow);

        youKnowWho.target(james);
        youKnowWho.target(lily);
        youKnowWho.target(harry);

        Character.doSth("defending", lily, james, harry);
        albus.doSth("drinking evening tea");

        youKnowWho.castSpell(Spell.AvadaKedavra);

        youKnowWho.createHorcruxes(1);
        youKnowWho.printHorcruxes();

        Character.status();

        albus.doSth("finish drinking tea");
        albus.moveTo(Location.GodricsHollow);
        albus.say("You are a wizzard, Harry", harry);
    }
}
