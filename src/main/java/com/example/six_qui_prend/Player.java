package com.example.six_qui_prend;

public class Player {
    public String getName() {
        return name;
    }

    public Player(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String name;
    private String number;

}
