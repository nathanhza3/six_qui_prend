package com.example.six_qui_prend;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class StartGame extends Stage {
    private GridPane grid;
    private Label numPlayersLabel;
    private TextField numPlayersField;
    private Button addPlayerButton;
    private Button startButton;
    private int currentRow;

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 10;

    public StartGame() {

        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label playerNameLabel = new Label("Player's Name:");
        //Label playerTypeLabel = new Label("Player's Type :");
        currentRow = 2;
        addPlayerRow();
        addPlayerRow();
        grid.add(playerNameLabel, 1, 0);
        //grid.add(playerTypeLabel, 2, 0);

        Scene scene = new Scene(grid, 300, 450);
        setScene(scene);
        setTitle("Lancement du jeu");
    }

    private void addPlayerRow() {
        if (currentRow > MAX_PLAYERS + 1) {
            return;
        }

        TextField playerNameField = new TextField();
        playerNameField.setPromptText("Joueur " + (currentRow - 1));
        addPlayerButton = new Button("+");
        addPlayerButton.setOnAction(e -> addPlayerRow());
        startButton = new Button("Start Game");
        startButton.setOnAction(e -> startGame());


        grid.add(playerNameField, 1, currentRow);
        grid.add(addPlayerButton, 2, currentRow + 1);
        grid.add(startButton, 1, currentRow + 1);

        currentRow++;


    }
    private List<Hand> créer_hand(int n, Deck deck){
        List<Hand> hands = new ArrayList<>();
        int a=1;
        for (int i=1;i<=n;i++) {
            Hand hand = new Hand(a, deck.getValue());
            hands.add(hand);
            a += 10;
        }
        return hands;
    }
    private List<Player> créer_player(int n, List<Hand> hands){
        List<Player> players_List = new ArrayList<>();
        int a=1;
        for (int i=1;i<=n;i++) {
            Player player = new Player("Jérémy",i,a,hands.get(i));
            players_List.add(player);
            a += 10;
        }
        return players_List;
    }
    private void startGame() {

        // Elle crée une nouvelle liste vide appelée players pour stocker les informations des joueurs
        List<String> playerNames = new ArrayList<>();

        for (Node node : grid.getChildren()) {
            if (node instanceof TextField) {
                TextField playerNameField = (TextField) node;
                String playerName = playerNameField.getText().trim();

                // Verifie que le champs n est pas vide
                if (playerName.isEmpty()) {
                    showAlert("Player's name cannot be empty.");
                    return;
                }


                playerNames.add(playerName);
            }
        }

        // Validate the number of players
        if (playerNames.size() < MIN_PLAYERS) {
            showAlert("Minimum " + MIN_PLAYERS + " players are required.");
            return;
        }

        if (playerNames.size() > MAX_PLAYERS) {
            showAlert("Maximum " + MAX_PLAYERS + " players are allowed.");
            return;
        }

        close();
        Deck deck = new Deck();
        int n=3;
        List<Hand> hands=créer_hand(n, deck);
        List<Player> playerList=créer_player(n,  hands);

        Hand hand1= new Hand(1,deck.getValue());
        Hand hand2= new Hand(11,deck.getValue());
        Hand hand3= new Hand(21,deck.getValue());
        Player player1 = new Player("Jérémy",1,1,hand1);
        Player player2=new Player("estelle",2,11,hand2);
        Player player3=new Player("nathan",3,21,hand3);
        playerList.add(player1);
        playerList.add(player3);
        playerList.add(player2);

            Board firstWindow = new Board(playerList, deck);
            firstWindow.show();
        }


    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}








