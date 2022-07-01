package com.cw7;

// Spell enum class:
// Each spell has its strength.

public enum Spell {
    AvadaKedavra(100),
    Expelliarmus(10);

    public final int power;

    private Spell(int power) {
        this.power = power;
    }
}
