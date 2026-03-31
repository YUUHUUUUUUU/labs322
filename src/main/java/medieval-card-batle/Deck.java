package main.java;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> trash = new ArrayList<Card>();
    private ArrayList<Card> shop = new ArrayList<Card>();

    Deck(ArrayList<Card> hand){
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public ArrayList<Card> getShop() {
        return shop;
    }
    public ArrayList<Card> getTrash() {
        return trash;
    }

    public void shuffle_shop(){
        Collections.shuffle(shop);
    }

    //maybe implement the reShuffle, pop, etc here, but it is already possible to do everything with the getters
    //since they return pointers to the objects
}
