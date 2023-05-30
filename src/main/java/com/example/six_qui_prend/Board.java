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
        Scene scene = new Scene(grid, 1080, 700);
        setScene(scene);
        setTitle("distribution");
        affichecartePlateau();
        affichecarteMain();
        System.out.println("Hello");
        // Ajouter des cartes à la grille

    }
    public void affichecartePlateau()  {
        try {
            for (int i = 101; i <= 104; i++) {
                //4 cartes du début du jeu

                //int a = Cartes[i];
                //choper la valeur de la 101ème carte du deck


                String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + i + ".png";
                Image carte = chargeImage(imagePath);
                ImageView imageView = new ImageView(carte);
                grid.add(imageView, 0, i - 101);
            }

        }catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    public void affichecarteMain()  { //peu-etre mettre en argument le deck et le joueur pcq on les utilise
        try {
            for (int i = 1; i <= 10; i++) {
                //10 cartes de la main du joueur
                //changer source et mettre la main

                //int j= i+PLAYER_ID*10; //comme ça le 1 joueur(avec un id=0) ça va de 1 à 10 ET le 2ème de 11à20 ect..
                //int a = Deck[i];   prendre la valeur de la ième carte du deck

                String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + i + ".png";
                Image carte = chargeImage(imagePath);
                ImageView imageView = new ImageView(carte);

                /*String imageViewName = "imageView_" + i ;
                imageView.setId(imageViewName);

                 */

                grid.add(imageView, i, 5);
            }

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
