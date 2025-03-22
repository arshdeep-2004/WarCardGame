/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private String name;
    private LinkedList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Card drawCard() {
        return hand.poll(); // removes and returns the top card
    }

    public void addCards(List<Card> cards) {
        hand.addAll(cards); // adds won cards to the bottom of the hand
    }

    public int getHandSize() {
        return hand.size();
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }
}
