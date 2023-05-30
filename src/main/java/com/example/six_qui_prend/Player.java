package com.example.six_qui_prend;
import java.util.*;


public class Player {
    private String name;
    private int number;
    public Hand hand;
    private ArrayList<Cartes> cartesRamasse;

    private int points;
    private int id_player;


    public String getName() {
        return name;
    }

    public Player(String name, int number,int id_player,Hand hand) {
        this.name = name;
        this.number = number;
        this.hand = hand;
        this.cartesRamasse = new ArrayList<Cartes>();
        this.points = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

   public void choose_Card(){
       for (Cartes carte : this.hand.getValue()) {
           System.out.println("numéro de la carte "+carte.getNumber()+" nombre de tete "+carte.getNumber_head());
           //TODO:NATHAN et ESTHELLE faire en sorte que c'est la carte qu'il clique/ choisit

       }

   }

}
