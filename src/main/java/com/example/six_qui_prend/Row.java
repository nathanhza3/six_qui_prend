package com.example.six_qui_prend;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<ImageView> imageViewList;

    public List<ImageView> getImageViewList() {
        return imageViewList;
    }

    public Row() {
        imageViewList = new ArrayList<>();


    }

    public void setImageViewList(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }
}
