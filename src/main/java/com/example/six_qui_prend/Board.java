package com.example.six_qui_prend;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Board extends Stage {
    private GridPane grid;

    public void firstwindow() {
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 300, 450);
        setScene(scene);
        setTitle("Lancement du jeu");


    }


}
