package com.example.six_qui_prend;

import javafx.application.Platform;
public class Main {
    public static void main (String[] args ){
        Platform.startup(()->{
            StartGame startGame = new StartGame();
            startGame.show();

        });//M
        Deck deck= new Deck();

        Hand hand1= new Hand(11,deck.getValue());

    }
}
