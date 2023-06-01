package com.example.six_qui_prend;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Comparator;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import javafx.scene.control.Button;


public class Board extends Stage {
    private GridPane grid;

    public  Board(List<Player> playerList,Deck deck) {

        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 1080, 700);
        setScene(scene);
        setTitle("distribution");

       // ca ne doit pas être ici c'est pour tester
        //jusque ici et retirer meme le player 1
        affichecartePlateau(deck);
        affichecarteMain(playerList.get(0));
        //recupCartes(playerList, );
        System.out.println("Hello");
        // Ajouter des cartes à la grille


    }
    public void recupCartes(List<Player> playerList, String carteId){
        List<Tuple> list_carte_player= new ArrayList<>();
        for(Player player: playerList){
            affichecarteMain(player);
            Tuple tuple=new Tuple(player.choose_Card(carteId).getNumber(),player);
            list_carte_player.add(tuple);
        }
        Collections.sort(list_carte_player, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple tuple1, Tuple tuple2) {
                return Integer.compare(tuple1.getCarte_value(), tuple2.getCarte_value());
            }
        });


    }

    public void affichecartePlateau(Deck deck)  {
        try {
            for (int i = 100; i <= 103; i++) {
                //4 cartes du début du jeu
                //int a = Cartes[i];
                //choper la valeur de la 101ème carte du deck
                String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + deck.getValue()[i].getNumber() + ".png";
                Image carte = chargeImage(imagePath);
                ImageView imageView = new ImageView(carte);
                imageView.setId("imageView" +deck.getValue()[i].getNumber());
                grid.add(imageView, 0, i - 100); // ici j'ai modifié j'ai mis 100 avant il yavait 101 jsp trop pk
            }

        }catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    public void affichecarteMain(Player player)  { //peut-etre mettre en argument le deck et le joueur pcq on les utilise
        try {
            int a=0;
            cache_main();

            for (Cartes carte : player.hand.getValue_list()) {
                a+=1;

                //affichage du nom du joueur
                grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 5 && GridPane.getColumnIndex(node) == 0);
                String name = player.getName();
                Label nameLabel = new Label(name);
                nameLabel.setStyle("-fx-font-size: 18px;");
                grid.add(nameLabel, 0, 5);

                //affichage du nombre de péna du joueur
                grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 6 && GridPane.getColumnIndex(node) == 0);
                int pena = player.getPenalite();
                Label penaLabel = new Label(String.valueOf(pena)+" penalty");
                penaLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: red;");
                grid.add(penaLabel, 0, 6);






                //10 cartes de la main du joueur
                //changer source et mettre la main

                //int j= i+PLAYER_ID*10; //comme ça le 1 joueur(avec un id=0) ça va de 1 à 10 ET le 2ème de 11à20 ect..
                //int a = Deck[i];   prendre la valeur de la ième carte du deck



                //player.hand.getValue_i(i);
                //String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + player.hand.getValue()[i].getNumber() + ".png";

                String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte.getNumber() + ".png";
                Image card = chargeImage(imagePath);
                ImageView imageView = new ImageView(card);
                imageView.setId("" + carte.getNumber());
                imageView.setOnMouseClicked(event -> selection(imageView));
                //imageView.setOnMouseClicked(event2 -> player.choose_Card());




                grid.add(imageView, a, 5);
               }

        }catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public void selection(ImageView imageView) {
        try {
            System.out.println(imageView);

            String carteId = imageView.getId();
            System.out.println("Mon id est :"+carteId);

            String newImagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/blanc.png";
            Image newImage = chargeImage(newImagePath);

            imageView.setImage(newImage);

            double x = imageView.getLayoutX();
            double y = imageView.getLayoutY();

            //System.out.println(imageView.getLayoutY());
            //System.out.println(imageView.getX());
            returncarte(carteId);


        }

    catch (Exception e) {
        throw new RuntimeException(e);

    }}

    public void cache_main(){
        try{
        for (int b = 1; b <= 10; b++) {
            String newImagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/blanc.png";
            Image newImage = chargeImage(newImagePath);
            ImageView blanc = new ImageView(newImage);
            grid.add(blanc, b, 5);
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

    private void nextplayer(Player player){
        Button addPlayerButton = new Button("Next Player");
        addPlayerButton.setOnAction(e ->affichecarteMain(player) );
    }

    private void returncarte(String carteId) {
        try {
            String newImagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/backside.png";
            Image newImage = chargeImage(newImagePath);
            ImageView imageView = new ImageView(newImage);
            grid.add(imageView, 2, 4);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
