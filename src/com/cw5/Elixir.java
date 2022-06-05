package com.cw5;

import java.util.ArrayList;

public class Elixir {
    private String name;
    private boolean isCreated;
    private int power;
    private Liquid catalyst;
    private ArrayList<Ingredient> ingredients;

    protected void checkCreated() throws RuntimeException {
        if (isCreated) {
            throw new RuntimeException("Elixir: can't change, Elixir already created!");
        }
    }

    protected Ingredient findByName(String name) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(name))
                return ingredient;
        }
        return null;
    }

    public Elixir(String name) throws RuntimeException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            isCreated = false;
            power = 0;
            catalyst = null;
            ingredients = new ArrayList<>();
        } else {
            throw new RuntimeException("Elixir: no name or zero sized name!");
        }
    }

    public String getName() {
        return name;
    }

    public int getPower() throws RuntimeException {
        if (isCreated) {
            return power;
        } else {
            throw new RuntimeException("Elixir: not created, power unavailable!");
        }
    }

    public void setCatalyst(Liquid catalyst) throws RuntimeException {
        if (catalyst != null) {
            checkCreated();
            this.catalyst = catalyst;
        } else {
            throw new RuntimeException("Elixir: no catalyst!");
        }
    }

    public Liquid getCatalyst() {
        return catalyst;
    }

    public void addIngredient(Ingredient ingredient) throws RuntimeException {
        if (ingredient != null) {
            checkCreated();
            // Check for amount:
            //if (ingredient.getReagent() > 0) {
            // We expect each ingredient only once:
            if (findByName(ingredient.getName()) == null) {
                ingredients.add(ingredient);
            } else {
                throw new RuntimeException("Elixir: Ingredient already added!");
            }
            //} else {
            //throw new RuntimeException("Elixir: can't add zero amount!");
        } else {
            throw new RuntimeException("Elixir: no Ingredient!");
        }
    }

    public void removeIngredient(Ingredient ingredient) {
        checkCreated();
        ingredients.remove(ingredient);
    }

    public void create() throws RuntimeException {
        checkCreated();
        if (catalyst != null) {
            // Calculate overall power...
            for (Ingredient ingredient : ingredients) {
                power += ingredient.getReagent();
            }
            // Divide by catalyst reagent:
            power /= catalyst.getReagent();
            isCreated = true;
        } else {
            throw new RuntimeException("Elixir: no catalyst specified!");
        }
    }

    public void print() {
        final String bar = "====================================================================\n";
        System.out.print(bar);
        System.out.printf("ELIXIR: \"%s\" Ingredients:\n", name);
        System.out.print(bar);
        for (int i = 0; i < ingredients.size(); ++i) {
            Ingredient item = ingredients.get(i);
            System.out.printf("% 2d. ", i + 1);
            item.print();
        }
        System.out.print("\nCatalyst: ");
        catalyst.print();

        System.out.print(bar);
        System.out.printf("POWER: %d\n\n", power);
    }
}
