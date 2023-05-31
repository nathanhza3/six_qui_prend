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

   public Cartes choose_Card(){
       for (Cartes carte : this.hand.getValue_list()) {
           System.out.println("numéro de la carte "+carte.getNumber()+" nombre de tete "+carte.getNumber_head());

       }
       Cartes choose_card= hand.getValue_list().get(0); // ici
       hand.getValue_list().remove(0); //ici
       hand.setValue_list(hand.getValue_list());
       System.out.println(hand.getValue_list().size()); // test
       //TODO:NATHAN et ESTHELLE faire en sorte que c'est la carte qu'il clique/ choisit la on supprime a chaque fois l'index 0
       return choose_card;







   }

}
