package com.example.six_qui_prend;

import javax.swing.ImageIcon;

public class Cartes{
    private int number;
    private int number_head;
    private ImageIcon image;

    public int getNumber_head() {
        return number_head;
    }
    public int getNumber() {
        return number;
    }

    public ImageIcon getImageIcon() {
        return image;
    }
    public Cartes(int number) {
        this.number = number;
        if (number == 55) {
            this.number_head = 7;
        } else if (number % 10 == 0) {
            this.number_head = 3;
        } else if (number % 5 == 0) {
            this.number_head = 2;
        } else if (number % 11 == 0) {
            this.number_head = 5;
        } else {
            this.number_head = 1;
        }
    }

}
