package com.example.six_qui_prend;

public class Tuple {
    private int carte_value;
    private Player player;

    public Tuple(int carte_value, Player player) {
        this.carte_value = carte_value;
        this.player = player;
    }

    public int getCarte_value() {
        return carte_value;
    }

    public Player getPlayer() {
        return player;
    }
    //
}
