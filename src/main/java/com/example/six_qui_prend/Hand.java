package com.example.six_qui_prend;




public class Hand {
    private Cartes[] value;
    private int id_player;
    public Hand(int id_player, Cartes[] deckvalue) {
        this.value = new Cartes[10];

        for (int a=0; a<=9; a++) {


            this.value[a]=deckvalue[id_player+a-1];
            System.out.println(getValue_i(a).getNumber());
        }




    }
    public Cartes getValue_i(int i) {

        return value[i];
    }
}
