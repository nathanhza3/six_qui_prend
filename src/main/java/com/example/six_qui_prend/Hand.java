package com.example.six_qui_prend;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Hand {
    private Cartes[] value;
    public List<Cartes> value_list;

    public void setValue_list(List<Cartes> value_list) {
        this.value_list = value_list;
    }

    public List<Cartes> getValue_list() {
        return value_list;
    }

    private int id_player;
    public Hand(int id_player, Cartes[] deckvalue) {
        this.value = new Cartes[10];

        for (int a=0; a<=9; a++) {
            
            this.value[a]=deckvalue[id_player+a-1];
        }
        this.value_list=new ArrayList<>(Arrays.asList(value));



    }
    public Cartes getValue_i(int i) {
        return value[i];
    }
    public Cartes[] getValue() {
        return value;
    }
}
