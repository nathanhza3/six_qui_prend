package com.example.six_qui_prend;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;


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

        // ca ne doit pas être ici c'est pour tester
        Deck deck = new Deck();
        Hand hand1= new Hand(1,deck.getValue());
        Player player1 = new Player("Jérémy",1,1,hand1);
        //jusque ici et retirer meme le player 1
        affichecartePlateau(deck);
        affichecarteMain(player1);
        System.out.println("Hello");
        // Ajouter des cartes à la grille


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
            int a=1;

            for (Cartes carte : player.hand.getValue_list()) {
                a+=1;
                    //10 cartes de la main du joueur
                    //changer source et mettre la main

                    //int j= i+PLAYER_ID*10; //comme ça le 1 joueur(avec un id=0) ça va de 1 à 10 ET le 2ème de 11à20 ect..
                    //int a = Deck[i];   prendre la valeur de la ième carte du deck



                    //player.hand.getValue_i(i);
                    //String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + player.hand.getValue()[i].getNumber() + ".png";

                    String imagePath = "src/main/resources/com/example/six_qui_prend/clientjavafx/ui/card/" + carte.getNumber() + ".png";
                    Image card = chargeImage(imagePath);
                    ImageView imageView = new ImageView(card);
                    imageView.setId(""+carte.getNumber());
                    imageView.setOnMouseClicked(event -> selection(imageView));
                    grid.add(imageView, a, 5);
                }

        }catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    private void selection(ImageView imageView){
        // Réagir au clic sur l'image
        // Par exemple, afficher un message "Hello" dans la console
        System.out.println("Hello"+imageView);


    }
    public static Image chargeImage(String url) throws Exception{
        //Image image = new Image(Objects.requireNonNull(HelloApplication.class.getResource(url)).openStream());
        //System.out.println(image);
        File file = new File(url);
        Image image = new Image(file.toURI().toString());
        return image;
    }
}
