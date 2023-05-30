package com.example.six_qui_prend;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Board extends Stage {
    private GridPane grid;



    public void firstwindow() {
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 300, 450);
        setScene(scene);
        setTitle("distribution");

        // Ajouter des cartes à la grille
        Image carte1 = new Image("/com/example/six_qui_prend/clientjavafx/ui/card/1.png");
        ImageView imageView1 = new ImageView(carte1);
        grid.add(imageView1, 1, 1);
    }


}
