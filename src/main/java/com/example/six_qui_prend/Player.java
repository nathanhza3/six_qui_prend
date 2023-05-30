package com.example.six_qui_prend;
import java.util.*;


public class Player {
    private String name;
    private int number;
    public ArrayList<Cartes> hand;
    private ArrayList<Cartes> cartesRamasse;

    private int points;


    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
        this.number = number;
        this.hand = new ArrayList<Cartes>();
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

    public ArrayList<Cartes> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Cartes> hand) {
        this.hand = hand;
    }

    public ArrayList<Cartes> getCartesRamasse() {
        return cartesRamasse;
    }

    public void setCartesRamasse(ArrayList<Cartes> cartesRamasse) {
        this.cartesRamasse = cartesRamasse;
    }

}
