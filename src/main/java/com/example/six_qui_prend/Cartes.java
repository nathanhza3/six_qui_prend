package com.example.six_qui_prend;

import java.net.URL;
import javax.swing.ImageIcon;

public class Cartes {
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
    public Cartes(int number, int number_head, ImageIcon image) {
        this.number = number;
        this.number_head = number_head;
        URL url = getClass().getResource("src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/"+number+".png");
        this.image = new ImageIcon(url);
    }



}
