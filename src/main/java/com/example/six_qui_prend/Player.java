package com.example.six_qui_prend;

public class Player {
    public String getName() {
        return name;
    }

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
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

    private String name;
    private int number;

}
