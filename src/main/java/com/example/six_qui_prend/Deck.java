package com.example.six_qui_prend;
import java.util.Arrays;

import java.util.Collections;
public class Deck {

    private Cartes[] value;

    public Deck() {
        this.value = new Cartes[104];

        for (int i = 0; i <= 103; i++) {

            value[i] = new Cartes(i+1);

        }
        Collections.shuffle(Arrays.asList(value));

    }


    public Cartes getValue_i(int i) {

        return value[i];
    }
    public Cartes[] getValue() {

        return value;
    }
}