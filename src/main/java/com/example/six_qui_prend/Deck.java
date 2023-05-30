package com.example.six_qui_prend;
import java.util.Arrays;

import java.util.Collections;
    public class Deck {
        private Cartes[] createDeck() {
            Cartes[] deck = new Cartes[104];

            for (int i = 1; i <= 104; i++) {

                deck[i] = new Cartes(i, number_head(i));

            }
            Collections.shuffle(Arrays.asList(deck));
            return deck;
        }

        private int number_head(int i){
            if(i==55){
                return 7;
            } else if(i%10==0){
                return 3;
            } else if(i%5==0){
                return 2;
            } else if(i%11==0){
                return 5;
            } else {
                return 1;
            }

        }
    }