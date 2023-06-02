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

    private Row row_choisie;


    private List<Cartes> cartesList;



    public  Board(List<Player> playerList,Deck deck,Row row) {

        grid = new GridPane();
        cartesList=new ArrayList<>();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 1300, 700);
        /*
        String imagePath = "com/example/six_qui_prend/clientjavafx/ui/fond-ecran.png";
        Image backgroundImage = new Image(getClass().getClassLoader().getResourceAsStream(imagePath));

        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background1 = new Background(background);

        grid.setBackground(background1);

         */
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
        this.row_choisie=row;
        affichecartePlateau(rows);
        affichecarteMain(playerList.get(0),playerList,0);


        //recupCartes(playerList, );
        // Ajouter des cartes à la grille

    }
    public void recupCartes(List<Player> playerList, String carteId, Row row){
        List<Tuple> list_carte_player= new ArrayList<>();
        for(Player player: playerList){
            affichecarteMain(player,playerList,0);
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
            row1.getImageViewList().add(imageView1);
            this.rows[0]=row1;


            grid.add(row1.getImageViewList().get(0), 1, 0);

            Cartes carte2 = deck.getValue()[101];
            String imagePath2 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte2.getNumber() + ".png";
            Image carteImage2 = chargeImage(imagePath2);
            ImageView imageView2 = new ImageView(carteImage2);
            imageView2.setId("imageView" + carte2.getNumber());
            Row row2 = new Row();
            row2.getImageViewList().add(imageView2);
            this.rows[1]=row2;

            grid.add(row2.getImageViewList().get(0), 1, 1);

            Cartes carte3 = deck.getValue()[102];
            String imagePath3 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte3.getNumber() + ".png";
            Image carteImage3 = chargeImage(imagePath3);
            ImageView imageView3 = new ImageView(carteImage3);
            imageView3.setId("imageView" + carte3.getNumber());
            Row row3 = new Row();
            row3.getImageViewList().add(imageView3);
            this.rows[2]=row3;

            grid.add(row3.getImageViewList().get(0), 1, 2);

            Cartes carte4 = deck.getValue()[103];
            String imagePath4 = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte4.getNumber() + ".png";
            Image carteImage4 = chargeImage(imagePath4);
            ImageView imageView4 = new ImageView(carteImage4);
            imageView4.setId("imageView" + carte4.getNumber());
            Row row4 = new Row();
            row4.getImageViewList().add(imageView4);
            this.rows[3]=row4;

            grid.add(row4.getImageViewList().get(0), 1, 3);




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

        //grid.getChildren().clear();
        grid.getChildren().removeIf(node -> {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer columnIndex = GridPane.getColumnIndex(node);
            return rowIndex != null && columnIndex != null &&
                    rowIndex >= 0 && rowIndex <= 3 &&
                    columnIndex >= 1 && columnIndex <= 7;
        });

        for(int i=0;i<=f;i++){
            grid.add(rows[0].getImageViewList().get(i), i+1, 0);

        }
        for (int i=0;i<=d;i++){
            grid.add(rows[1].getImageViewList().get(i), i+1, 1);



        }
        for (int i=0;i<=p;i++){
            grid.add(rows[2].getImageViewList().get(i), i+1, 2);

        }
        for (int i=0;i<=s;i++){
            grid.add(rows[3].getImageViewList().get(i), i+1, 3);

        }





    }
    public void affichecarteMain(Player player,List<Player> playerList,int p)  {
        try {
            int a=0;
            cache_main();
            p+=1;

            if (p<=playerList.size()){

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
                    imageView.setOnMouseClicked(event -> selection(imageView, carte,player));

                    //imageView.setOnMouseClicked(event2 -> player.choose_Card());





                /*
                int currentPlayerIndex = players_List.indexOf(player);
                int nextPlayerIndex = (currentPlayerIndex + 1) % players_List.size();
                Player nextPlayer = players_List.get(nextPlayerIndex);
                Button nextPlayerButton = new Button("Next Player");
                nextPlayerButton.setOnAction(e -> affichecarteMain(nextPlayer));
                grid.add(nextPlayerButton, 7, 7);

                 */







                    grid.add(imageView, a, 5);

                }
                //permet de passer à l'autre joueur en appuyant
                int nextPlayerIndex = (player.getNumber()) % playerList.size(); //Cheat code +3/20
                Button nextPlayerButton = new Button("Next Player to choose a card");
                int x=p;
                nextPlayerButton.setOnAction(e -> affichecarteMain(playerList.get(nextPlayerIndex),playerList,x));
                grid.add(nextPlayerButton, 12, 5);

            } else if(p>playerList.size())  {
                grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 5 && GridPane.getColumnIndex(node)==12);
                List<Tuple> tupleList=quijoue(playerList,cartesList);
                List<Player> playerList2=new ArrayList<>();
                for(int j=0;j<tupleList.size();j++) {
                    playerList2.add(tupleList.get(j).getPlayer());

                }
                suite_affiche_carte_main(tupleList,tupleList.get(0).getPlayer(),playerList2,0,playerList);



            }

        }

        catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public void selection(ImageView imageView, Cartes carte,Player player) {
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
            retourn_carte(carteId);

            player.hand.getValue_list().remove(carte);
            this.cartesList.add(carte);



        }

        catch (Exception e) {
            throw new RuntimeException(e);

        }}
    public void suite_affiche_carte_main(List<Tuple> tupleList,Player player,List<Player> playerList2,int p,List<Player> playerList) {
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

        p+=1;
        if (p<=playerList2.size()) {

            grid.getChildren().removeIf(node -> {
                Integer rowIndex = GridPane.getRowIndex(node);
                Integer columnIndex = GridPane.getColumnIndex(node);
                return rowIndex != null && columnIndex != null &&
                        rowIndex >= 0 && rowIndex <= 3 &&
                        columnIndex == 0;
            });
            int index = -1; // Initialiser l'index à -1 (valeur par défaut si l'objet n'est pas trouvé)

            for (int i = 0; i < playerList2.size(); i++) {
                Player player2 = playerList2.get(i);

                if (player2.equals(player)) { // Comparer les objets avec equals()
                    index = i; // Mettre à jour l'index si l'objet est trouvé
                    player2 = null;

                    break; // Sortir de la boucle une fois l'objet trouvé
                }
            }


            System.out.println(index);

            Cartes carte = new Cartes(tupleList.get(index).getCarte_value());
            System.out.println(tupleList.get(index).getCarte_value());

            List<Integer> ouposer_list = ouposer(tupleList.get(index).getPlayer(), carte);


            addbutton(ouposer_list, carte);
            //ifrowfull(tupleList.get(index).getPlayer(),row_choisie);

            //System.out.println(row_choisie.getImageViewList().get(row_choisie.getImageViewList().size()-1));
            //row_choisie=null;
            //System.out.println(ouposer_list.get(0));


            //ifrowfull(tupleList.get(index).getPlayer(),row_choisie);
            //ifcarteinf(tupleList.get(index).getPlayer(),row_choisie);

            int nextPlayerIndex = (index + 1) % playerList2.size(); //Cheat code +3/20
            System.out.println(nextPlayerIndex);
            Button nextPlayerButton2 = new Button("Next Player to place a card");
            int x=p;
            int finalIndex = index;
            nextPlayerButton2.setOnAction(e -> {

                ifcarteinf(tupleList.get(finalIndex).getPlayer(),row_choisie);
                suite_affiche_carte_main(tupleList, playerList2.get(nextPlayerIndex), playerList2,x,playerList);




                affichecartePlateau(rows);



            });
            grid.add(nextPlayerButton2, 12, 5);


        }
        // chose a faire apres
        else {
            grid.getChildren().removeIf(node -> {
                Integer rowIndex = GridPane.getRowIndex(node);
                Integer columnIndex = GridPane.getColumnIndex(node);
                return rowIndex != null && columnIndex != null &&
                        rowIndex >= 1 && rowIndex <= 3 &&
                        columnIndex >= 7;
            });
            System.out.println("ok");
            affichecarteMain(playerList2.get(0),playerList,0);
        }
    }


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


    private void retourn_carte(String carteId ) {
        int row = 1;
        int column = 8;

        try {
            String newImagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/backside.png";
            Image newImage = chargeImage(newImagePath);
            ImageView imageView = new ImageView(newImage);


            final int[] finalRow = {row};
            final int[] finalColumn = {column};


            while (grid.getChildren().stream().anyMatch(node -> GridPane.getRowIndex(node) == finalRow[0] && GridPane.getColumnIndex(node) == finalColumn[0])) {
                if (finalColumn[0]>11){
                    finalColumn[0]=8;
                    finalRow[0]++;
                }
                else{
                    finalColumn[0]++;
                }
            }
            grid.add(imageView, finalColumn[0], finalRow[0]);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private List<Integer> ouposer(Player player,Cartes carte){
        List<Tuple2> tuple2List=new ArrayList<>();
        List<Integer> ouposer_list=new ArrayList<>();
        int value = carte.getNumber();
        String dc0_string = rows[0].getImageViewList().get(rows[0].getImageViewList().size()-1).getId();
        String numberString0 = dc0_string.substring("imageView".length());
        int dc0 = Integer.parseInt(numberString0);
        Tuple2 tuple0= new Tuple2(0,dc0);
        tuple2List.add(tuple0);
        String dc1_string = rows[1].getImageViewList().get(rows[1].getImageViewList().size()-1).getId();
        String numberString1 = dc1_string.substring("imageView".length());
        int dc1 = Integer.parseInt(numberString1);
        Tuple2 tuple1= new Tuple2(1,dc1);
        tuple2List.add(tuple1);
        String dc2_string = rows[2].getImageViewList().get(rows[2].getImageViewList().size()-1).getId();
        String numberString2 = dc2_string.substring("imageView".length());
        int dc2 = Integer.parseInt(numberString2);
        Tuple2 tuple2=new Tuple2(2,dc2);
        tuple2List.add(tuple2);
        String dc3_string = rows[3].getImageViewList().get(rows[3].getImageViewList().size()-1).getId();
        String numberString3 = dc3_string.substring("imageView".length());
        int dc3 = Integer.parseInt(numberString3);
        Tuple2 tuple3=new Tuple2(3,dc3);
        tuple2List.add(tuple3);


        tuple2List.sort(Comparator.comparingInt(Tuple2::getValue));
        if(value<tuple2List.get(0).getValue()){
            ouposer_list.add(0);
            ouposer_list.add(1);
            ouposer_list.add(2);
            ouposer_list.add(3);
        } else if (value>tuple2List.get(3).getValue()) {
            ouposer_list.add(tuple2List.get(3).getRow());
        } else if (value>tuple2List.get(2).getValue()) {
            ouposer_list.add(tuple2List.get(2).getRow());
        }else if (value>tuple2List.get(1).getValue()) {
            ouposer_list.add(tuple2List.get(1).getRow());
        }else if (value>tuple2List.get(0).getValue()) {
            ouposer_list.add(tuple2List.get(0).getRow());
        }

        return ouposer_list;
    }
    private void placerCarte(Row row, Cartes carte){
        grid.getChildren().removeIf(node -> {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer columnIndex = GridPane.getColumnIndex(node);
            return rowIndex != null && columnIndex != null &&
                    rowIndex >= 0 && rowIndex <= 3 &&
                    columnIndex == 0;
        });

        try{

            String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte.getNumber() + ".png";
            Image carteImage = chargeImage(imagePath);
            ImageView imageView1 = new ImageView(carteImage);
            imageView1.setId("imageView" + carte.getNumber());

            row.getImageViewList().add(imageView1);

        /*
        int index = -1; // Initialiser l'index à -1 (valeur par défaut si l'élément n'est pas trouvé)
            for (int i = 0; i < rows.; i++) {
                Row row2 = rows.get(i);

                if (row.equals(rowToFind)) { // Comparer les éléments avec equals()
                    index = i; // Mettre à jour l'index si l'élément est trouvé
                    break; // Sortir de la boucle une fois l'élément trouvé
                }
            }



        grid.add(row.getImageViewList().get(row.getImageViewList().size()-1),1,1);

         */

            affichecartePlateau(rows);
            cartesList.remove(0);


        }catch (Exception e) {
            throw new RuntimeException(e);

        }



    }
    private void ifrowfull(Player player,Row row){
        if(row.getImageViewList().size()>=6){
            System.out.println("ca rentre dans le if");

            for(int i=0; i<=4;i++){
                String carte_string = row.getImageViewList().get(i).getId();
                String numberString = carte_string.substring("imageView".length());
                int carte_value = Integer.parseInt(numberString);

                Cartes carte= new Cartes(carte_value);
                player.getCartesRamasse().add(carte);
                row.getImageViewList().remove(i);
                carte=null;


            }
            player.calculatePenalite();
            System.out.println(row.getImageViewList().size());


        }
        System.out.println("ca rentre pas dans le if");

    }


    public void addbutton(List<Integer> liste,  Cartes carte){

        if (liste.size() == 1 && liste.contains(0)) {
            Button addPlayerButton = new Button("---->");
            row_choisie=rows[0];
            addPlayerButton.setOnAction(e -> placerCarte(rows[0], carte ));

            grid.add(addPlayerButton, 0,  0);
        }else if (liste.size() == 1 && liste.contains(1)){
            Button addPlayerButton = new Button("---->");
            row_choisie=rows[1];
            addPlayerButton.setOnAction(e -> placerCarte(rows[1], carte ));

            grid.add(addPlayerButton, 0,  1);
        }else if (liste.size() == 1 && liste.contains(2)){
            Button addPlayerButton = new Button("---->");
            row_choisie=rows[2];
            addPlayerButton.setOnAction(e -> placerCarte(rows[2], carte ));
            grid.add(addPlayerButton, 0,  2);
        }else if (liste.size() == 1 && liste.contains(3)){
            Button addPlayerButton = new Button("---->");
            row_choisie=rows[3];
            addPlayerButton.setOnAction(e -> placerCarte(rows[3], carte ));
            grid.add(addPlayerButton, 0,  3);

        } else if (liste.size() == 4 && liste.containsAll(List.of(0, 1, 2, 3))) {
            Button addPlayerButton1 = new Button("---->");
            addPlayerButton1.setOnAction(e -> {
                placerCarte(rows[0], carte );
                row_choisie=rows[0];
            });

            grid.add(addPlayerButton1, 0,  0);

            Button addPlayerButton2 = new Button("---->");
            addPlayerButton2.setOnAction(e -> {
                placerCarte(rows[1], carte );
                row_choisie=rows[1];
            });
            grid.add(addPlayerButton2, 0,  1);

            Button addPlayerButton3 = new Button("---->");
            addPlayerButton3.setOnAction(e -> {
                placerCarte(rows[2], carte );
                row_choisie=rows[2];
            });
            grid.add(addPlayerButton3, 0,  2);

            Button addPlayerButton4 = new Button("---->");
            addPlayerButton4.setOnAction(e -> {
                placerCarte(rows[3], carte );
                row_choisie=rows[3];

            });
            grid.add(addPlayerButton4, 0,  3);
        }
    }
    private List<Tuple> quijoue(List<Player> playerList,List<Cartes> cartesList){
        List<Tuple> tupleList=new ArrayList<>();
        int i=0;
        for(Player player:playerList){
            Tuple tuple= new Tuple(cartesList.get(i).getNumber(),player);
            tupleList.add(tuple);
            i+=1;
        }
        tupleList.sort(Comparator.comparingInt(Tuple::getCarte_value));

        return tupleList;

    }

    private void clearGrid() {  //permet
        grid.getChildren().clear();
    }
    private void ifcarteinf(Player player,Row row){
        String value_string1 = row.getImageViewList().get(row.getImageViewList().size()-2).getId();
        String numberString1 = value_string1.substring("imageView".length());
        int value_n_1 = Integer.parseInt(numberString1);
        String value_string2 = row.getImageViewList().get(row.getImageViewList().size()-1).getId();
        String numberString2 = value_string2.substring("imageView".length());
        int value_n = Integer.parseInt(numberString2);
        if(value_n<value_n_1){


            for(int i=0; i<=row.getImageViewList().size()-2;i++){
                String value_stringi = row.getImageViewList().get(row.getImageViewList().size()-2).getId();
                String numberStringi = value_stringi.substring("imageView".length());
                int value_i = Integer.parseInt(numberStringi);

                Cartes carte= new Cartes(value_i);
                player.getCartesRamasse().add(carte);
                row.getImageViewList().remove(i);
                carte=null;


            }
            player.calculatePenalite();
            System.out.println(row.getImageViewList().size());


        }

    }





}