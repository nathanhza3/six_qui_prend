package com.example.six_qui_prend;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public abstract class Board extends Application{
    private GridPane grid;
    public Began{
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
    }
}
