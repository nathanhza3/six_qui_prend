package com.example.six_qui_prend;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;


public class Board extends Stage {
    private GridPane grid;

    public  Board() {

        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 300, 450);
        setScene(scene);
        setTitle("distribution");
        affichecarte();
        System.out.println("Hello");
        // Ajouter des cartes à la grille

    }
    public void affichecarte()  {
        try {
            Image carte1 = chargeImage("src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/1.png");
            ImageView imageView1 = new ImageView(carte1);
            grid.add(imageView1, 0, 0);
            Image carte2 = chargeImage("src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/2.png");
            ImageView imageView2 = new ImageView(carte2);
            grid.add(imageView2, 0, 1);

        }catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    public static Image chargeImage(String url) throws Exception{
        //Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource(url)).openStream());
        //System.out.println(image);
        File file = new File(url);
        Image image = new Image(file.toURI().toString());
        return image;
    }
}
