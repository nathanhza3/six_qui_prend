package com.example.six_qui_prend;
import java.util.Arrays;

import java.util.Collections;
public class Deck {

    private Cartes[] value;

    public Deck() {
        this.value = new Cartes[104];

        for (int i = 0; i <= 103; i++) {

            //value[i] = new Cartes(i+1, number_head(i+1));


        }
        System.out.println(value[10].getNumber());
        Collections.shuffle(Arrays.asList(value));
        System.out.println(value[10].getNumber());
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