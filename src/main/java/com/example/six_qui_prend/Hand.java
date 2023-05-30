package com.example.six_qui_prend;




public class Hand {
    private Cartes[] value;
    private int id_player;
    public Hand(int id_player, Cartes[] deckvalue) {
        this.value = new Cartes[10];

        for (int i = 0; i<=id_player*10; i++) {

            this.value[i] = deckvalue[i];



        }

    }
}
