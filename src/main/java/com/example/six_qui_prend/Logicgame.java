package com.example.six_qui_prend;

public class Logicgame {

    //distribuer les cartes
    /*public static List<Carte> disturb(List<Carte> deck){
        int idCard;
        int deckSize = deck.size()-1;
        List<Carte> playerCards = new ArrayList<Carte>();
        for(int i = 0; i<10; i++){
            idCard = (int) (Math.random()*deckSize);
            Carte card = deck.get(idCard);
            playerCards.add(card);
            deck.remove(card);
            deckSize = deck.size()-1;
        }
        return playerCards;
    }*/


    /*public static boolean testPetit(Cartes cardToPlace, List<Cartes> cards){
        boolean isPetit = true;
        for (Cartes carte : cards) {
            if(carte.getValue()<cardToPlace.getValue()){
                isPetit = false;
            }
        }
        return isPetit;
    }*/


}
