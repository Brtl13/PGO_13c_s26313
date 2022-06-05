package com.cw5;

public class Main {
    public static void main(String[] args) {
        Liquid blood = new Liquid("Virgin Blood", 80, 20);
        Water water = new Water(100,false);
        Alcohol vodka = new Alcohol(100, 40, 85);
        Ore sulphur = new Ore("Sulphur", 50, 30, false);
        Ore coal = new Ore("Coal", 100, 10, false);
        Ore gold = new Ore("Gold", 300, 50,true);
        Crystal ruby = new Crystal("Ruby", 30, 20, 40);
        Crystal diamond = new Crystal("Diamond", 60, 120, 200);
        Crystal blackDiamond = new Crystal("Black Soul Diamond", 100, 250, 400);
        Plant ivy = new Plant("Poison Ivy", 60, 50);
        Flower deathBell = new Flower("Death Bell", 120, 100);
        Root ginseng = new Root("Ginseng", 20, 5);

        water.print();
        System.out.println("Actual Reagent of Water: " + water.getReagent() + "\n");
        vodka.print();
        System.out.println("Actual Reagent of Alcohol: " + vodka.getReagent() + "\n");
        coal.print();
        System.out.println("Actual Reagent of Coal (Ore): " + coal.getReagent() + "\n");
        blackDiamond.print();
        System.out.println("Actual Reagent of Black Soul Diamond: " + blackDiamond.getReagent() + "\n");
        deathBell.print();
        System.out.println("Actual Reagent of Death Bell: " + deathBell.getReagent() + "\n");
        ginseng.print();
        System.out.println("Actual Reagent of Ginseng: " + ginseng.getReagent() + "\n");

        Elixir elixir1 = new Elixir("Deathwish");
        elixir1.addIngredient(blood);
        elixir1.addIngredient(sulphur);
        elixir1.addIngredient(gold);
        elixir1.addIngredient(deathBell);
        elixir1.addIngredient(blackDiamond);
        elixir1.removeIngredient(blood);
        elixir1.setCatalyst(vodka);
        elixir1.create();
        elixir1.print();

    }
}
