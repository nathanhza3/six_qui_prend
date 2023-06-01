package com.example.six_qui_prend;
import javafx.scene.image.ImageView;

import java.util.*;


public class Player {
    private String name;
    private int number;
    public Hand hand;
    private ArrayList<Cartes> cartesRamasse;
    private int penalite;

    private int points;
    private int id_player;


    public String getName() {
        return name;
    }

    public Player(String name, int number,int id_player,Hand hand) {
        this.name = name;
        this.number = number;
        this.hand = hand;
        this.cartesRamasse = new ArrayList<Cartes>();
        this.penalite = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setNumber(int number) {
        this.number = number;
    }

   public Cartes choose_Card(String carteId){
       for (Cartes carte : this.hand.getValue_list()) {
           System.out.println("numéro de la carte "+carte.getNumber()+" nombre de tete "+carte.getNumber_head());

       }
       Cartes choose_card= hand.getValue_list().get(0); // ici
       hand.getValue_list().remove(Integer.parseInt(carteId));

       hand.getValue_list().remove(0); //ici
       hand.setValue_list(hand.getValue_list());
       System.out.println(hand.getValue_list().size()); // test
       //Board.selection();

       //TODO:NATHAN et ESTHELLE faire en sorte que c'est la carte qu'il clique/ choisit la on supprime a chaque fois l'index 0

       return choose_card;
    }


    private void selection(ImageView imageView){
        //TODO:
        //System.out.println("Hello"+imageView);
        System.out.println(imageView.getId());

    }


    public void calculatePenalite() {
        penalite = 0;
        for (Cartes carte : cartesRamasse) {
            int valeurPena = valeur_pena(carte.getNumber()); // Appeler la méthode valeur_pena de la classe Cartes
            penalite += valeurPena;
        }
        setPenalite(penalite);
    }
    public int valeur_pena(int number) {
        int number_head=0;
        if (number == 55) {
            number_head = 7;
        } else if (number % 10 == 0) {
            number_head = 3;
        } else if (number % 5 == 0) {
            number_head = 2;
        } else if (number % 11 == 0) {
            number_head = 5;
        } else {
            number_head = 1;
        }
        return number_head;
    }

    public ArrayList<Cartes> getCartesRamasse() {
        return cartesRamasse;
    }

    public void setCartesRamasse(ArrayList<Cartes> cartesRamasse) {
        this.cartesRamasse = cartesRamasse;
    }

    public int getPenalite() {
        return penalite;
    }

    public void setPenalite(int penalite) {
        this.penalite = penalite;
    }




    /*class ImageInfo {
        private int x;
        private int y;

        public ImageInfo(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

     */






}
