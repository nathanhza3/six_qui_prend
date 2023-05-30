package com.example.six_qui_prend;

import javafx.application.Platform;
public class Main {
    public static void main (String[] args ){
        Platform.startup(()->{
            StartGame startGame = new StartGame();
            startGame.show();

        });//M



    }
}
