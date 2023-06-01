package com.example.six_qui_prend;

import javafx.geometry.Insets;
import javafx.scene.Node;
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

            //création affichage et ajout à la row1 de la 1er carte
            Cartes carte1 = deck.getValue()[100];
            String imagePath1 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte1.getNumber() + ".png";
            Image carteImage1 = chargeImage(imagePath1);
            ImageView imageView1 = new ImageView(carteImage1);
            imageView1.setId("imageView" + carte1.getNumber());
            Row row1 = new Row();
            row1.getImageViewList().add(imageView1);
            grid.add(imageView1, 0, 0);

            Cartes carte2 = deck.getValue()[101];
            String imagePath2 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte2.getNumber() + ".png";
            Image carteImage2 = chargeImage(imagePath2);
            ImageView imageView2 = new ImageView(carteImage2);
            imageView2.setId("imageView" + carte2.getNumber());
            Row row2 = new Row();
            row2.getImageViewList().add(imageView2);
            grid.add(imageView2, 0, 1);

            Cartes carte3 = deck.getValue()[102];
            String imagePath3 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte3.getNumber() + ".png";
            Image carteImage3 = chargeImage(imagePath3);
            ImageView imageView3 = new ImageView(carteImage3);
            imageView3.setId("imageView" + carte3.getNumber());
            Row row3 = new Row();
            row3.getImageViewList().add(imageView3);
            grid.add(imageView3, 0, 2);

            Cartes carte4 = deck.getValue()[103];
            String imagePath4 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte4.getNumber() + ".png";
            Image carteImage4 = chargeImage(imagePath4);
            ImageView imageView4 = new ImageView(carteImage4);
            imageView4.setId("imageView" + carte4.getNumber());
            Row row4 = new Row();
            row4.getImageViewList().add(imageView4);
            grid.add(imageView4, 0, 3);

            Row[] rows = new Row[4];
            rows[0] = row1;
            rows[1] = row2;
            rows[2] = row3;
            rows[3] = row4;

            /*test
            System.out.println(row1.getImageViewList().get(0));
            System.out.println(row2.getImageViewList().get(0));
            System.out.println(row3.getImageViewList().get(0));
            System.out.println(row4.getImageViewList().get(0));
            System.out.println(rows[1].getImageViewList().get(0));

             */

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

    private void returncarte(String carteId ) {
        int row = 2;
        int column = 6;

        try {
            String newImagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/backside.png";
            Image newImage = chargeImage(newImagePath);
            ImageView imageView = new ImageView(newImage);


            boolean isOccupied = false;
            for (Node node : grid.getChildren()) {
                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                    isOccupied = true;
                    break;
                }
            }
            if (isOccupied) {
                column++; //mets la carte a droite
            }

            grid.add(imageView, column, row);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
