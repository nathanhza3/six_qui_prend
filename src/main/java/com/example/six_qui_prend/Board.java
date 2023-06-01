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

import java.util.HashMap;
import java.util.Map;

public class Board extends Stage {
    private GridPane grid;
    private Row[] rows = new Row[4];

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
        affichecartePlateau_debut(deck);


        /* TEst pour montrer qu'on ait pas 0

        Cartes carte1 = deck.getValue()[69];
        try {
            ImageView imageView1 = new ImageView(chargeImage("src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte1.getNumber() + ".png"));
            imageView1.setId("imageView" + carte1.getNumber());


            rows[0].getImageViewList().add(imageView1);
        }
        catch (Exception e) {
            throw new RuntimeException(e);

        }

         */
        affichecartePlateau(rows);






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

    public void affichecartePlateau_debut(Deck deck)  {
        try {

            //création affichage et ajout à la row1 de la 1er carte
            Cartes carte1 = deck.getValue()[100];
            String imagePath1 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte1.getNumber() + ".png";
            Image carteImage1 = chargeImage(imagePath1);
            ImageView imageView1 = new ImageView(carteImage1);
            imageView1.setId("imageView" + carte1.getNumber());
            Row row1 = new Row();
            this.rows[0]=row1;
            row1.getImageViewList().add(imageView1);

            grid.add(row1.getImageViewList().get(0), 0, 0);

            Cartes carte2 = deck.getValue()[101];
            String imagePath2 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte2.getNumber() + ".png";
            Image carteImage2 = chargeImage(imagePath2);
            ImageView imageView2 = new ImageView(carteImage2);
            imageView2.setId("imageView" + carte2.getNumber());
            Row row2 = new Row();
            this.rows[1]=row2;
            row2.getImageViewList().add(imageView2);
            grid.add(row2.getImageViewList().get(0), 0, 1);

            Cartes carte3 = deck.getValue()[102];
            String imagePath3 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte3.getNumber() + ".png";
            Image carteImage3 = chargeImage(imagePath3);
            ImageView imageView3 = new ImageView(carteImage3);
            imageView3.setId("imageView" + carte3.getNumber());
            Row row3 = new Row();
            this.rows[2]=row3;
            row3.getImageViewList().add(imageView3);
            grid.add(row3.getImageViewList().get(0), 0, 2);

            Cartes carte4 = deck.getValue()[103];
            String imagePath4 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte4.getNumber() + ".png";
            Image carteImage4 = chargeImage(imagePath4);
            ImageView imageView4 = new ImageView(carteImage4);
            imageView4.setId("imageView" + carte4.getNumber());
            Row row4 = new Row();
            this.rows[3]=row4;
            row4.getImageViewList().add(imageView4);
            grid.add(row4.getImageViewList().get(0), 0, 3);




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
    public void affichecartePlateau(Row[] rows){
        int f=rows[0].getImageViewList().size()-1;
        int d=rows[1].getImageViewList().size()-1;
        int p=rows[2].getImageViewList().size()-1;
        int s=rows[3].getImageViewList().size()-1;

        grid.getChildren().clear();
        for(int i=0;i<=f;i++){
            grid.add(rows[0].getImageViewList().get(i), i, 0);

        }
        for (int i=0;i<=d;i++){
            grid.add(rows[1].getImageViewList().get(i), i, 1);



        }
        for (int i=0;i<=p;i++){
            grid.add(rows[2].getImageViewList().get(i), i, 2);

        }
        for (int i=0;i<=d;i++){
            grid.add(rows[3].getImageViewList().get(i), i, 3);

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
    private List<Integer> ouposer(Player player,Cartes carte){
        List<Integer> ouposer_list=new ArrayList<>();
        int value= carte.getNumber();
        int dc0=Integer.parseInt(rows[0].getImageViewList().get(rows[0].getImageViewList().size()-1).getId());
        int dc1=Integer.parseInt(rows[1].getImageViewList().get(rows[1].getImageViewList().size()-1).getId());
        int dc2=Integer.parseInt(rows[2].getImageViewList().get(rows[2].getImageViewList().size()-1).getId());
        int dc3=Integer.parseInt(rows[3].getImageViewList().get(rows[3].getImageViewList().size()-1).getId());
        int i=0;
            if(value<dc0&&value<dc1&&value<dc2&&value<dc3){

                ouposer_list.add(0);
                ouposer_list.add(1);
                ouposer_list.add(2);
                ouposer_list.add(3);
            } else if (value>dc0&&value>dc1&&value>dc2&&value>dc3) {


            }

        return ouposer_list;
    }
    private void placerCarte(Row row, Cartes carte){


    }
    private void ifrowfull(Player player,Row row){
        if(row.getImageViewList().size()>=6){

            for(int i=0; i<=4;i++){
                Cartes carte= new Cartes(Integer.parseInt(row.getImageViewList().get(i).getId()));
                player.getCartesRamasse().add(carte);
                row.getImageViewList().remove(i);
                carte=null;


            }
            player.calculatePenalite();
            System.out.println(row.getImageViewList().size());


        }

    }

}
